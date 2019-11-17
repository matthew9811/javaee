package com.shengxi.carblog.repository;

import com.shengxi.carblog.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 用户表持久层接口
 *
 * @author yan
 */
@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    /**
     * 根据用户名和密码查找记录是否存在
     *
     * @param name username
     * @param pwd pwd
     * @return 查找到的记录数
     */
    @Query
    Integer countByNameAndPwd(String name, String pwd);
}
