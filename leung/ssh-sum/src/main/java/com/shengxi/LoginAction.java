package com.shengxi;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 登录操作
 * @author yan
 * @date 2019-12-15 00:10:34
 */

public class LoginAction extends ActionSupport {

    @Autowired
    private UserService userService;

    public String login() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        return "success";
    }
}
