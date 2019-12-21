package com.shengxi.carblog.service.blog.impl;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.shengxi.carblog.pojo.Blog;
import com.shengxi.carblog.pojo.weak.ResponsePojo;
import com.shengxi.carblog.repository.IBlogRepository;
import com.shengxi.carblog.repository.IUserRepository;
import com.shengxi.carblog.service.blog.IBlogService;
import com.shengxi.compent.constant.StatusConstant;
import com.shengxi.compent.utils.ResponseStatus;
import com.shengxi.compent.utils.UserUtil;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 博客服务层实现类
 *
 * @author yan
 * @version 1.0.0
 * @date 2019-12-17 20:43:07
 */
@Primary
@Service
public class BlogServiceImpl implements IBlogService {

    /**
     * 保存时使用的路径前缀，系统目录下对应模块的uploads文件夹
     */
    private final String UPLOAD_PATH_PREFIX = System.getProperty("user.dir") + "/carblog/uploads/";
    /**
     * 模块路径
     */
    private final String SYSTEM_PATH = System.getProperty("user.dir") + "/carblog";

    /**
     * 项目内相对路径
     */
    private final String MODULE_PATH = "/carblog/uploads/";

    /**
     * 相对路径前缀
     */
    private final String SQL_PATH_PREFIX = "/uploads/";
    /**
     * 后缀
     */
    private final String SUFFIX = ".html";

    private IBlogRepository blogRepository;

    private IUserRepository userRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponsePojo addBlog(Map data) throws IOException {
        Blog blog = new Blog();
        String fileName = UUID.randomUUID(true).toString().replace("-", "").concat(SUFFIX);
        Integer userId = userRepository.findByName(UserUtil.getUserName()).getId();
        /* 初始化审核人为自己 */
        blog.setReviewer(userId);
        blog.setStatus(StatusConstant.BLOG_CONFIG_STATUS);
        blog.setUser(userRepository.findById(userId).get());
        blog.setCreateTime(LocalDateTime.now());
        blog.setTitle((String) data.get("title"));
        /*自动获取74个文字作为摘要，同时删除对应的<p>标签*/
        blog.setRemark(data.get("content").toString().substring(0, 74).replace("<p>", ""));
        blog.setBlogUrl(SQL_PATH_PREFIX + this.saveFile(fileName, data).concat("/") + fileName);
        Blog save = blogRepository.save(blog);
        if (ObjectUtil.isNotEmpty(save)) {
            ResponsePojo pojo = new ResponsePojo(ResponseStatus.SUCCESS, "发表成功!");
            pojo.put("id", save.getId());
            return pojo;
        }
        return new ResponsePojo(ResponseStatus.FAIL, "服务器错误，请稍后再试!");
    }


    @Override
    public HashMap<String, Object> findBlogById(String id) {
        Blog blog = blogRepository.findBlogById(id);
        if (ObjectUtil.isEmpty(blog)) {
            return null;
        }
        HashMap<String, Object> data = new HashMap<>(3);
        data.put("blog", blog);
        data.put("content", this.readHtml(blog.getBlogUrl()));
        return data;
    }

    @Override
    public List<Blog> findPassBlogAll() {
        return blogRepository.findAll();
    }


    /**
     * @param fileName
     * @param data
     * @return
     * @throws IOException
     */
    private String saveFile(String fileName, Map data) throws IOException {
        String tmpPath = LocalDate.now(ZoneId.of("Asia/Shanghai")).toString().replace("-", "");
        File dirFile = new File(UPLOAD_PATH_PREFIX + tmpPath);
        /* 单例模式双重校验锁 */
        if (BooleanUtil.isFalse(dirFile.exists())) {
            synchronized (dirFile) {
                if (BooleanUtil.isFalse(dirFile.exists())) {
                    dirFile.mkdirs();
                }
            }
        }
        File saveFile = new File(dirFile.getAbsolutePath(), fileName);
        if (BooleanUtil.isFalse(saveFile.exists())) {
            synchronized (saveFile) {
                if (BooleanUtil.isFalse(saveFile.exists())) {
                    saveFile.createNewFile();
                }
            }
        }
        FileOutputStream outputStream = new FileOutputStream(saveFile, true);
        outputStream.write(String.valueOf(data.get("content")).getBytes("utf-8"));
        outputStream.close();
        return tmpPath;
    }


    /**
     * 根据路径读取对应的html
     * @param url 相对路径
     * @return concent :StringBuffer
     */
    private StringBuffer readHtml(String url) {
        StringBuffer content = new StringBuffer();
        String line = "";
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;

        /*
         * 根据路径读取数据
         */
        File file = new File(SYSTEM_PATH + url);
        try {
            reader = new InputStreamReader(new FileInputStream(file));
            bufferedReader = new BufferedReader(reader);
            line = bufferedReader.readLine();
            while (line != null) {
                content.append(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return content;
    }

    @Autowired
    public void setUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setBlogRepository(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }
}
