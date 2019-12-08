package com.shengxi.carblog.repository;

import com.shengxi.carblog.pojo.Manager;
import com.shengxi.carblog.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author chuling
 * @date 16点33分
 * @see org.springframework.data.jpa.repository.JpaRepository
 */
@Repository
public interface IManagerRepository extends JpaRepository<Manager, Integer> {

    /**
     *
     * 通过用户的name 和 pwd
     * @param user user
     * @return manager
     */
    @Query("from Manager as m left join " +
            "(select name, password from User " +
            "where name = :user.name and pwd = :user.pwd)" +
            " as u in m.user_id = u.id")
    Manager findManagerByUser(@Param("user") User user);
}
