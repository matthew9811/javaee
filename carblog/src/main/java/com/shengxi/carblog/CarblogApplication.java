package com.shengxi.carblog;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author matthew
 * @date 2019年9月16日 09:14:43
 * 项目启动类
 */
@EnableTransactionManagement
@EnableWebMvc
@SpringBootApplication
public class CarblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarblogApplication.class, args);
    }


}
