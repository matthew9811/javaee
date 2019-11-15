package com.shengxi.carblog.repository;

import com.shengxi.carblog.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户表持久层接口
 *
 * @author yan
 */
public interface IUserRepository extends JpaRepository<Integer, User> {

    /**
     * 根据用户名和密码查找记录是否存在
     *
     * @param name username
     * @param pwd pwd
     * @return 查找到的记录数
     */
    Integer countIntegerByNameAndPwd(String name, String pwd);
}
