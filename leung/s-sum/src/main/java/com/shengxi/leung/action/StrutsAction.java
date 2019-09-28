package com.shengxi.leung.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @Author: matthew
 * @ClassName StrutsAction
 * @Date: 2019-09-28 16:26
 * @Version: 1.0.0
 * @description: 登录action
 */
@Data
@NoArgsConstructor
public class StrutsAction extends ActionSupport {
    private String name;

    @Override
    public String execute() throws Exception {
        if (!this.getName().equals("helloWorld")) {
            System.out.println("This request is SUCCESS！！！！");
            Map request = (Map) ActionContext.getContext().get("request");
            request.put("name", this.getName());
            return SUCCESS;
        }

        return ERROR;
    }
}
