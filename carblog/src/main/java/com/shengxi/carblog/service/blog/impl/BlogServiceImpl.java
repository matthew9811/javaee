package com.shengxi.carblog.service.blog.impl;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.shengxi.carblog.pojo.Blog;
import com.shengxi.carblog.pojo.weak.ResponsePojo;
import com.shengxi.carblog.repository.IBlogRepository;
import com.shengxi.carblog.repository.IUserRepository;
import com.shengxi.carblog.service.blog.IBlogService;
import com.shengxi.compent.constant.RegularConstant;
import com.shengxi.compent.constant.StatusConstant;
import com.shengxi.compent.constant.UploadConstant;
import com.shengxi.compent.utils.FileUtils;
import com.shengxi.compent.utils.ResponseStatus;
import com.shengxi.compent.utils.UserUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        blog.setBlogUrl(UploadConstant.SQL_PATH_PREFIX + FileUtils.saveFile(fileName, data).concat("/") + fileName);
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
        StringBuffer stringBuffer = FileUtils.readHtml(blog.getBlogUrl());
        data.put("blog", blog);
        data.put("content", stringBuffer);
        data.put("imageUrl", FileUtils.getImgUrl(stringBuffer));
        data.putAll(findNewBlog());
        return data;
    }

    @Override
    public HashMap<String, Object> findNewBlog() {
        HashMap<String, Object> data = new HashMap<>(1);

        List<Object> blogLatestSeven = blogRepository.findBlogLatestSeven();
        List<Blog> blogList = new ArrayList<>();
        for (int i = 0; i < blogLatestSeven.size(); i++) {
            Object[] obj = (Object[]) blogLatestSeven.get(i);
            Blog blog = new Blog(obj[0].toString(), obj[1].toString(), ((Timestamp) obj[2]).toLocalDateTime());
            blog.setImgUrl(FileUtils.getImgUrl(FileUtils.readHtml(blog.getBlogUrl())));
            blogList.add(blog);
        }
        data.put("latestList", blogList);
        return data;
    }

    @Override
    public List<Blog> findPassBlogAll() {
        return blogRepository.findAll();
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
