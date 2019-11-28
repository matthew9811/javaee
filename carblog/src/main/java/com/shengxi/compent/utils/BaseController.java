package com.shengxi.compent.utils;

import com.shengxi.carblog.pojo.weak.ResponsePojo;

/**
 * @author yan
 * @version 1.0.0
 * @date 2019-11-27 23:37:10
 * 公用基础控制器模块
 */
public class BaseController {
    protected ResponsePojo responsePojo;

    public BaseController() {
    }

    public BaseController(ResponsePojo responsePojo) {
        this.responsePojo = responsePojo;
    }

    public ResponsePojo getResponsePojo() {
        return responsePojo;
    }

    public void setResponsePojo(ResponsePojo responsePojo) {
        this.responsePojo = responsePojo;
    }
}
