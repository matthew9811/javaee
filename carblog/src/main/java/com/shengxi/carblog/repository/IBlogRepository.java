package com.shengxi.carblog.repository;

import com.shengxi.carblog.pojo.Blog;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
     *
     * @return list<blog>
     */
    @Query(value = "select id,  blog_url AS blogUrl, title, create_time AS createTime from " +
            "blog where status = '1' order by createTime desc limit 0, 7", nativeQuery = true)
    List<Object> findBlogLatestSeven();


    /**
     * 更新博客的状态
     *
     * @param blogId 博客id
     * @param status 修改后的状态
     * @param userId 修改人id
     * @return 修改的条数
     */
    @Modifying(clearAutomatically = true)
    @Query(value = "update blog set status = :status, reviewer = :userId where id = :blogId ;", nativeQuery = true)
    int passBlog(@Param("blogId") String blogId, @Param("status") String status, @Param("userId") Integer userId);

    /**
     * 更新博客的状态
     *
     * @param blogId    博客id
     * @param recommend 修改后的状态
     * @param userId    修改人id
     * @return 修改的条数
     */
    @Modifying(clearAutomatically = true)
    @Query(value = "update blog set recommend = :recommend, reviewer = :userId where id = :blogId ;", nativeQuery = true)
    int recommendBlog(@Param("blogId") String blogId, @Param("recommend") String recommend, @Param("userId") Integer userId);

    /**
     * 获取一条通过审核，发表时间最新的数据
     *
     * @return 一条数据
     */
    @Query(value = "SELECT " +
            " *  " +
            "FROM " +
            " `blog`  " +
            "WHERE " +
            " `status` = 1  " +
            "ORDER BY " +
            " create_time DESC  " +
            " LIMIT 1", nativeQuery = true)
    Blog findLastOnePass();
}
