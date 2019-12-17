package com.shengxi.carblog.repository;

import com.shengxi.carblog.pojo.weak.bigTable.UserBlogLog;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * IUserBlogLogRepository通用仓库，实现自定义sql
 * 可以选用所有的实体类进行数据获取
 *
 * @author yan
 * @version 1.0.0
 * @date 2019-12-16 20:55:54
 * @see org.springframework.data.repository.Repository
 * @see org.springframework.data.repository.query.QueryByExampleExecutor
 * @see org.springframework.data.repository.PagingAndSortingRepository
 * @see org.springframework.data.repository.CrudRepository
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
public interface IUserBlogLogRepository extends JpaRepository<UserBlogLog, Integer> {

    /**
     * 获取所有的
     * @return list
     */
    @Query(value = "SELECT " +
            "u.id AS id, " +
            "u.`name` AS `name`, " +
            "u.status AS status, " +
            "count( b.id ) AS blog_count " +
            "FROM " +
            "`user` AS u " +
            "LEFT JOIN blog AS b ON u.id = b.user_id; ", nativeQuery = true)
    List<UserBlogLog> selectAllUserBlogLog();
}
