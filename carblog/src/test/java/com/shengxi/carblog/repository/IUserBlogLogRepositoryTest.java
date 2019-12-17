package com.shengxi.carblog.repository;

import com.shengxi.carblog.CarblogApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarblogApplication.class)
public class IUserBlogLogRepositoryTest {

    @Autowired
    private IUserBlogLogRepository commonRepository;

    @Test
    public void selectAllUserBlogLog() {
        System.out.println(commonRepository.selectAllUserBlogLog());
    }
}