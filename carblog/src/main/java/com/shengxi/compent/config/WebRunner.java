package com.shengxi.compent.config;

import java.util.Date;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * 启动完成提示
 * @author yan
 */
@Configuration
public class WebRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Buliding SUCCESS!  " + new Date(System.currentTimeMillis()));
    }
}
