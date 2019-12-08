package com.shengxi.compent.config;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * @author yan
 * @version 1.0.0
 * @date 2019-12-05 15:02:12
 * 自定义定时任务处理池，避免懒加载
 * @see org.springframework.scheduling.annotation.SchedulingConfigurer
 */
@Configuration
public class ScheduleConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(
                new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
                        r -> new Thread()));
    }
}
