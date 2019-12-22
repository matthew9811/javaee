package com.shengxi.carblog.repository;

import com.shengxi.carblog.pojo.Blog;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
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
public interface IBlogRepository extends JpaRepository<Blog, String> {

    /**
     * 通过博客id获取对应的博客详情
     *
     * @param id id :String
     * @return blog
     */
    Blog findBlogById(@Param("id") String id);

    /**
     * 获取最新的四条数据
     *
     * @param id userId:int
     * @return list<Blog> :List->Blog
     */
    @Query(value = "SELECT " +
            "  b.id as id, " +
            "  b.title as title, " +
            "  b.create_time  as create_time " +
            "FROM " +
            "  blog AS b " +
            "  LEFT JOIN `user` AS u ON u.id = b.user_id  " +
            "WHERE " +
            "  u.id = 1  " +
            "  LIMIT 0, " +
            "  7", nativeQuery = true)
    List<Blog> findBlogLatestFour(@Param("id") Integer id);
}
