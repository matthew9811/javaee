package com.shengxi.carblog.repository;


import com.shengxi.carblog.CarblogApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * user orm测试
 * @author yan
 * @date 2019-11-17 14:55:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarblogApplication.class)
public class IUserRepositoryTest {

    @Autowired
    private IUserRepository userRepository;

    @Test
    public void findAllTest(){
        System.out.println(userRepository.findAll());
    }
}