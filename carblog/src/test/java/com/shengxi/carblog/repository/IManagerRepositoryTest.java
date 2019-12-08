package com.shengxi.carblog.repository;


import com.shengxi.carblog.CarblogApplication;
import com.shengxi.carblog.pojo.Manager;
import com.shengxi.carblog.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarblogApplication.class)
public class IManagerRepositoryTest {

    @Autowired
    private IManagerRepository managerRepository;

    @Test
    public void findManagerByUserTest(){
        User user = new User();
        user.setName("admin");
        user.setPwd("admin");
        Manager managerByUser = managerRepository.findManagerByUser(user);
        System.out.println(managerByUser);
    }
}