package com.shengxi.carblog.repository;

import com.shengxi.carblog.pojo.Blog;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * 博客模块持久层
 *
 * @author yan
 * @version 1.0.0
 * @date 2019-12-10 17:22:58
 */
@Repository
public interface IBlogRepository extends JpaRepository<Blog, String>, JpaSpecificationExecutor<Blog> {

    /**
     * 通过博客id获取对应的博客详情
     *
     * @param id id :String
     * @return blog
     */
    Blog findBlogById(@Param("id") String id);

    /**
     * 获取最新的7条数据
     */
    @Query(value = "select id,  blog_url AS blogUrl, title, create_time AS createTime from " +
            "blog where status = '0' order by createTime desc limit 0, 7", nativeQuery = true)
    List<Object> findBlogLatestSeven();
}
