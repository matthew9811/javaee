package com.shengxi.carblog.service.blog;

import com.shengxi.carblog.pojo.Blog;
import com.shengxi.carblog.pojo.weak.ResponsePojo;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 博客模块服务层
 *
 * @author yan
 * @version 1.0.0
 * <p>
 * @date 2019-12-17 20:41:59
 */
public interface IBlogService {

    /**
     * @param data map
     * @return statu :enum and msg :String
     * @throws IOException
     */
    ResponsePojo addBlog(Map data) throws IOException;

    /**
     * 通过blog的id获取对应的blog信息
     *
     * @param id blogId :String
     * @return blog :Obj
     */
    Blog findBlogById(String id);

    /**
     * 查找所有通过审核的文章
     *
     * @return list: List<Blog>
     */
    List<Blog> findPassBlogAll();
}
