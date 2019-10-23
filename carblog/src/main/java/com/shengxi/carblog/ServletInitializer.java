package com.shengxi.carblog;

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

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CarblogApplication.class);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("BUILD SUCCESS!");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
        .addResourceLocations("classpath:/resources/");
    }
}
