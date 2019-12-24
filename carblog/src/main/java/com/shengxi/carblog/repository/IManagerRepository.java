package com.shengxi.carblog.repository;

import com.shengxi.carblog.pojo.Manager;
import com.shengxi.carblog.pojo.weak.bigTable.UserBlogLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chuling
 * @date 16点33分
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
@Repository
public interface IManagerRepository extends JpaRepository<Manager, Integer> {
    /**
     * 获取所有的
     * @return list
     */
    @Query(value = "SELECT " +
            "m.id AS id, " +
            "m.`name` AS `name`, " +
            "m.status AS status, " +
            "m.`create_time` AS `create_time`," +
            "count( b.id ) AS blog_count " +
            "FROM " +
            "`manager` AS m " +
            "LEFT JOIN blog AS b ON u.id = b.user_id GROUP BY u.id;", nativeQuery = true)
    List<UserBlogLog> selectAllUserBlogLog();
}
