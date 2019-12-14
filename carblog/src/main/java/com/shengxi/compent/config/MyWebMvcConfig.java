package com.shengxi.compent.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 静态资源访问配置
 *
 * @author yan
 * @date 2019-12-10 20:13:11
 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport
 */
@Configuration
public class MyWebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 当访问/file下的资源时，会到/root/myFile/下去找
        // 例如访问：http://localhost:8080/file/1.png时会去找/root/myFile/1.png
        registry.addResourceHandler("/file/**").
                addResourceLocations("file:/root/javaee/");
        super.addResourceHandlers(registry);
    }
}
