package com.shengxi.carblog.repository;

import com.shengxi.carblog.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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
     * @param pwd  pwd
     * @return 查找到的记录数
     */
//    @Query("select count(t) from user AS t where name = :name and pwd = :pwd")
    Long countByNameAndPwd(@Param("name") String name, @Param("pwd") String pwd);

    User findByNameAndPwd(String name, String pwd);
}
