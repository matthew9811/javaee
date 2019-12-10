package com.shengxi.compent.utils;

import com.shengxi.carblog.pojo.weak.ResponsePojo;
import java.util.Map;

/**
 * @author yan
 * @version 1.0.0
 * @date 2019-11-27 23:37:10
 * 公用基础控制器模块
 */
public class BaseController {


    /**
     * 生成一个响应实体对象，并返回到前端
     * @param status status
     * @param msg msg
     * @return pojo
     */
    public ResponsePojo getResponsePojo(ResponseStatus status, String msg) {
        ResponsePojo pojo = new ResponsePojo(status, msg);
        return pojo;
    }

    /**
     * 生成一个多信息实体，并返回
     * @param map
     * @return
     */
    public ResponsePojo getResponsePojo(Map<String, Object> map){
        return new ResponsePojo(map, ResponseStatus.SUCCESS);
    }
}
