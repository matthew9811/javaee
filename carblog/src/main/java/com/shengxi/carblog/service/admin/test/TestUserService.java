package com.shengxi.carblog.service.admin.test;

import com.shengxi.carblog.pojo.TestUser;

/**
 * @Author: matthew
 * @ClassName TestUserService
 * @Date: 2019-09-22 17:40
 * @Version: 1.0.0
 * @description:
 */
public interface TestUserService {

    TestUser findByName(String name);
}
