package com.shengxi.carblog;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author yan
 * 快速启动
 * 增加启动提示
 */
@Configuration
public class ServletInitializer extends SpringBootServletInitializer implements WebMvcConfigurer, ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CarblogApplication.class);
    }

    /**
     * 配置启动成功后提示
     *
     * @param args 环境变量
     */
    @Override
    public void run(ApplicationArguments args) {
        logger.info("\n BUILD SUCCESS! {}", LocalDateTime.now());
    }

    /**
     * 增加资源控制器
     *
     * @param registry 注册列表
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/resources/");
    }


}
