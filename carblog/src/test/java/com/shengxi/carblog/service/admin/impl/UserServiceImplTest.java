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

//    @Test
//    public void listAll() {
//        System.out.println(userService.listAll());
//    }
//
//    @Test
//    public void save() {
//        User user = new User();
//        user.setName("lyh");
//        user.setPwd("lyh");
//        user.setStatus("0");
//        user.setCreateTime(LocalDateTime.now());
//        user.setAvatarUrl("1324");
//        user.setContent("465798");
//        userService.save(user);
//    }
//
//    @Test
//    public void findByNameAndPwd() {
//        User byNameAndPwd = userService.findByNameAndPwd("admin", "amdin");
//        System.out.println(byNameAndPwd);
//    }


    @Test
    public void existsByNameTest(){
        userService.userNameVerify("admin");
    }
}