package com.shengxi.carblog.pojo.weak;

import com.shengxi.compent.utils.ResponseStatus;

/**
 * 响应实体
 *
 * @author yan
 * @date 2019-11-14 23:06:10
 */
public class ResponsePojo {
    /**
     * 状态
     */
    private ResponseStatus status;
    /**
     * 信息
     */
    private String msg;

    public ResponsePojo() {
    }

    public ResponsePojo(ResponseStatus status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResponsePojo{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                '}';
    }
}