package com.shengxi.carblog.repository;

import com.shengxi.carblog.pojo.TestUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: matthew
 * @ClassName TestUserRepository
 * @Date: 2019-09-17 19:35
 * @Version: 1.0.0
 * @description:
 */
@Repository
public interface TestUserRepository extends JpaRepository<TestUser, Long> {
}
