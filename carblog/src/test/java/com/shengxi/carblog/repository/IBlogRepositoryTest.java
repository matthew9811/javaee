package com.shengxi.carblog.repository;

import com.shengxi.carblog.CarblogApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarblogApplication.class)
public class IBlogRepositoryTest {

    @Autowired
    private IBlogRepository blogRepository;

    @Test
    public void findBlogById() {
        System.out.println(blogRepository.findBlogById("4028e4816f2262e0016f227ff30f0000"));
    }
}