package com.shengxi.leung;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * @Author: matthew
 * @ClassName StrutsAction
 * @Date: 2019-09-25 11:11
 * @Version: 1.0.0
 * @description: 普通动作类
 */
public class StrutsAction extends ActionSupport {
    private String name;

    public StrutsAction() {
        System.out.println("》》》》》》》》》》》》》》》实例化");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("？？？？？？？？？赋值");
        this.name = name;
    }

    @Override
    public String execute() {
        if (!name.equals("HelloWorld")) {

            System.out.println("..............SUCCESS");
            Map req = (Map) ActionContext.getContext().get("request");
            req.put("name", getName());
            return SUCCESS;
        }
        System.out.println("++++++++++++++++++++ERROR");
        return ERROR;
    }
}
