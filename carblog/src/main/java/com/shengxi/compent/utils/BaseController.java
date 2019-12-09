package com.shengxi.compent.utils;

import com.shengxi.carblog.pojo.weak.ResponsePojo;

/**
 * @author yan
 * @version 1.0.0
 * @date 2019-11-27 23:37:10
 * 公用基础控制器模块
 */
public class BaseController {


    public ResponsePojo getResponsePojo(ResponseStatus status, String msg) {
        ResponsePojo pojo = new ResponsePojo(status, msg);
        return pojo;
    }
}
