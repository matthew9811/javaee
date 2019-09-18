package com.shengxi.carblog.repository;

import com.shengxi.carblog.CarblogApplication;
import com.shengxi.carblog.pojo.TestUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * @Author: matthew
 * @ClassName TestUserRepositoryTest
 * @Date: 2019-09-17 19:45
 * @Version: 1.0.0
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarblogApplication.class)
public class TestUserRepositoryTest {
    @Autowired
    private TestUserRepository userRepository;


    @Test
    public void findAll(){
        List<TestUser> users = userRepository.findAll();
        for (int i = 0; i< 100; i++ ){
            System.out.println(users.toString());
        }
    }

    @Test
    public void findUserByName() {
        TestUser lyh = userRepository.findUserByName("lyh");
        for (int i = 0; i < 500000; i++) {
            System.out.println(lyh.toString());
        }
    }
}