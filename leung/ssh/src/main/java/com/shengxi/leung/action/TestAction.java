package com.shengxi.leung.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @Author: matthew
 * @ClassName TestAction
 * @Date: 2019-09-28 15:49
 * @Version: 1.0.0
 * @description:
 */
@Data
@NoArgsConstructor
public class TestAction extends ActionSupport {
    private String name;
    private Integer age;

    @Override
    public String execute() throws Exception {
        if (!this.getName().equals("hello")) {
            Map request = (Map) ActionContext.getContext().get("request");
            request.put("name", this.getName());
            return SUCCESS;
        }

        return ERROR;
    }
}
