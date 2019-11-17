package com.shengxi.carblog.service.admin.impl;

import com.shengxi.carblog.CarblogApplication;
import com.shengxi.carblog.pojo.User;
import com.shengxi.carblog.pojo.weak.ResponsePojo;
import com.shengxi.carblog.service.admin.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarblogApplication.class)
public class UserServiceImplTest {

    @Autowired
    IUserService userService;

    @Test
    public void loginVerify() {
        User user = new User();
        user.setName("admin");
        user.setPwd("admin");
        ResponsePojo responsePojo = userService.loginVerify(user);
        System.out.println(responsePojo.toString());
    }
}