package com.shengxi.carblog.service.blog;

import com.shengxi.carblog.pojo.Blog;
import com.shengxi.carblog.pojo.weak.ResponsePojo;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Page;

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
     * 保存一点博客数据
     *
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
    HashMap<String, Object> findBlogById(String id);


    HashMap<String, Object> findNewBlog();

    /**
     * 查找所有通过审核的文章
     *
     * @return list: List<Blog>
     */
    List<Blog> findPassBlogAll();

    /**
     * 通过分页查询获取数据
     *
     * @param params 分页查询
     * @return list Blog
     */
    Page<Blog> findAllByPage(Map<String, Object> params);

    /**
     * 获取对应的推荐页数据
     *
     * @param params paramMap
     * @return list Blog
     */
    Page<Blog> findPassByPage(Map<String, Object> params);

    /**
     * 获取最新的数据
     * 初始化数据
     *
     * @return map
     */
    ResponsePojo findLastestBlog();
}
