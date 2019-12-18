package com.shengxi.carblog.service.blog.impl;

import cn.hutool.core.lang.UUID;
import com.shengxi.carblog.pojo.Blog;
import com.shengxi.carblog.repository.IBlogRepository;
import com.shengxi.carblog.repository.IUserRepository;
import com.shengxi.carblog.service.blog.IBlogService;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;
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

    private IBlogRepository blogRepository;

    private IUserRepository userRepository;

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = false)
    public ResponseBody addBlog(Map data, HttpServletRequest request) throws FileNotFoundException {
        Blog blog = new Blog();
        blog.setId(UUID.randomUUID(true).toString());
        String dirPath = new File(ResourceUtils.getURL("classpath:static").getPath().
                replace("%20"," ").replace('/', '\\')).getAbsolutePath();
        System.out.println(dirPath);
        System.out.println(request.getServletContext().getContextPath());
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
}
