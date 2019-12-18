package com.shengxi.carblog.service.blog.impl;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.BooleanUtil;
import com.shengxi.carblog.pojo.Blog;
import com.shengxi.carblog.repository.IBlogRepository;
import com.shengxi.carblog.repository.IUserRepository;
import com.shengxi.carblog.service.blog.IBlogService;
import com.shengxi.compent.constant.StatusConstant;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Map;
import java.util.TimeZone;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public ResponseBody addBlog(Map data, HttpServletRequest request) throws IOException {
        Blog blog = new Blog();
        blog.setId(UUID.randomUUID(true).toString());
        String fileName = UUID.randomUUID(true).toString().replace("-", "").concat(SUFFIX);
        this.saveFile(fileName);
        blog.setBlogUrl(SQL_PATH_PREFIX + fileName);
        blog.setStatus(StatusConstant.BLOG_CONFIG_STATUS);
        blog.setUserId();
        return null;
    }


    @Autowired
    public void setUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setBlogRepository(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }


    private void saveFile(String fileName) {
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
    }
}
