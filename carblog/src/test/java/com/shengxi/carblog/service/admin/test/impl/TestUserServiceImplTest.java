package com.shengxi.carblog.service.admin.test.impl;

import com.shengxi.carblog.CarblogApplication;
import com.shengxi.carblog.service.admin.test.TestUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: matthew
 * @ClassName TestUserServiceImplTest
 * @Date: 2019-09-22 17:51
 * @Version: 1.0.0
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarblogApplication.class)
public class TestUserServiceImplTest {

    @Autowired
    private TestUserService testUserService;

    @Test
    public void findByName() {
        System.out.println(testUserService.findByName("lyh"));
    }
}