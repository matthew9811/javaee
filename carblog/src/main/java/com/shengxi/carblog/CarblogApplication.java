package com.shengxi.carblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author matthew
 * @date 2019年9月16日 09:14:43
 * 项目启动类
 */
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.shengxi.carblog.repository")
@EnableWebMvc
@SpringBootApplication
public class CarblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarblogApplication.class, args);
    }


}
