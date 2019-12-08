package com.shengxi.carblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author matthew
 * @date 2019年9月16日 09:14:43
 * 项目启动类
 * EnableJpaRepositories注解给系统描述dao层的位置
 * EnableScheduling开启对应task的支持
 */
@EnableAsync
@EnableTransactionManagement
@EnableWebMvc
@SpringBootApplication
@EnableScheduling
public class CarblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarblogApplication.class, args);
    }


}
