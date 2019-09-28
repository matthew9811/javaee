package com.shengxi.leung.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author: matthew
 * @ClassName StuUsers
 * @Date: 2019-09-28 17:45
 * @Version: 1.0.0
 * @description:
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StuUsers implements Serializable {

    private Integer uid;
    private String uname;
    private String upsw;
    private String ucnName;

}
