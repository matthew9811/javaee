package com.shengxi.muliang;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * @author chuling
 */
public class StrutsAction extends ActionSupport {
    private String name;

    public StrutsAction() {
        System.out.println("================实例化");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String execute() {
        if (!name.equals("HelloWorld")) {
            Map req = (Map) ActionContext.getContext().get("request");
            req.put("name",getName());
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            return "success";
        }
        return "error";
    }
}
