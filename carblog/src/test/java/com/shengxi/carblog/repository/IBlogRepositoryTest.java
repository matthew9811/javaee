package com.shengxi.carblog.repository;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shengxi.carblog.CarblogApplication;
import com.shengxi.carblog.pojo.Blog;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Test
    public void findBlogLatestFour() {
        Pageable pageable = PageRequest.of(0, 7, Sort.by(Sort.Direction.DESC, "createTime"));
        List<Object> blogLatestSeven = blogRepository.findBlogLatestSeven();
        JSONArray jsonObject = (JSONArray) JSONObject.toJSON(blogLatestSeven);
        System.out.println(jsonObject);
    }


    @Test
    public void findBlogLatestSeven() {
        Pageable pageable = PageRequest.of(0, 7, Sort.by(Sort.Direction.DESC, "createTime"));
        List<Object> blogLatestSeven = blogRepository.findBlogLatestSeven();
        List<Blog> blogList = new ArrayList<>();
        for (int i = 0; i < blogLatestSeven.size(); i++) {
            Object[] obj = (Object[]) blogLatestSeven.get(i);
            blogList.add(new Blog(obj[0].toString(), obj[1].toString(), ((Timestamp)obj[2]).toLocalDateTime()));
        }
        blogList.forEach(v-> System.out.println(v.toString()));

    }
}