package com.shengxi.carblog.repository;

import com.shengxi.carblog.pojo.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
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

}
