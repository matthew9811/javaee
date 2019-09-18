package com.shengxi.carblog.repository;

import com.shengxi.carblog.pojo.TestUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: matthew
 * @ClassName TestUserRepository
 * @Date: 2019-09-17 19:35
 * @Version: 1.0.0
 * @description: 测试模板持久层
 */
@Repository
public interface TestUserRepository extends JpaRepository<TestUser, Long> {

    /**
     * 在自定义方法查询中，
     * 我们要使用new一个对象来封装实例
     * 然后用对应的实体类来替代表
     * 所以我们的实体类需要去绑定表
     * 注意：在new的使用，实体类中要有对应的构造器
     * @param name userName
     * @return TestUser
     */
    @Query("select new com.shengxi.carblog.pojo.TestUser(id, name, age) from TestUser where name = :name")
    TestUser findUserByName(@Param("name") String name);
}
