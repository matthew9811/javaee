package com.shengxi.carblog.repository;

import com.shengxi.carblog.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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
    Long countByNameAndPwd(@Param("name") String name, @Param("pwd") String pwd);

    /**
     * 根据用户名查看是否存在用户信息
     *
     * @param name name
     * @return bool
     */
    Boolean existsByName(@Param("name") String name);

    /**
     * 根据id修改状态
     *
     * @param id     要修改的id
     * @param status 要修改的状态值
     * @return 修改的条数
     */
    @Modifying
    @Query(value = "UPDATE `user` SET `status` = :status WHERE id = :id", nativeQuery = true)
    int updateStatus(@Param("id") Integer id,@Param("status") String status);

    /**
     * 通过名字获取对应的用户
     * @param userName name :String
     * @return User :Obj
     */
    User findByName(String userName);
}
