package com.shengxi.compent.utils;

import com.shengxi.carblog.pojo.weak.SessionMsgPojo;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Enumeration;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 *
 * @author yan
 * @version 1.0.0
 * @date 2019-12-04 16:32:56
 */
@Component
public class TaskWork {

    private final Long TIME_DIFFERENCE = 2L;
    private static final Logger log = LoggerFactory.getLogger(TaskWork.class);

    /**
     * 进行servlet中的session获取
     */
    @Autowired
    private HttpSession session;

    /**
     * 每半个小时进行一次定时任务，避免出现session保留时间过长，浪费资源的现象
     * 利用HTTPSession自动注入，获取服务器中session的所有数据
     * getAttributeNames获取所有参数名
     * 遍历查看对应的时间是否已经过期
     */
    @Scheduled(cron = "0 */30 * * * ?")
    public void clearSession() {
        log.info("start clean session!");
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String thisName = attributeNames.nextElement();
            SessionMsgPojo attribute = (SessionMsgPojo) session.getAttribute(thisName);
            Duration duration = Duration.between(LocalDateTime.now(), attribute.getLocalDateTime());
            long timeDiffercence = duration.toHours();
            if (TIME_DIFFERENCE <= timeDiffercence) {
                log.info("clean attribute name is {} and value is {}", thisName, session.getAttribute(thisName).toString());
                session.removeAttribute(thisName);
            }
        }
    }

}
