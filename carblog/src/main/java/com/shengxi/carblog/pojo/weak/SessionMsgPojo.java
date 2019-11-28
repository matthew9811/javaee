package com.shengxi.carblog.pojo.weak;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author yan
 * session相信实体类
 */
@Data
@AllArgsConstructor
public class SessionMsgPojo implements Serializable {
    private LocalDateTime localDateTime;
    private String msg;
}
