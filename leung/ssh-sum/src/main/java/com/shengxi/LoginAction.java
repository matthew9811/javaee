package com.shengxi;

import com.opensymphony.xwork2.ActionSupport;
import com.shengxi.sql.UserService;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

/**
 * 登录操作
 *
 * @author yan
 * @date 2019-12-15 00:10:34
 */

public class LoginAction extends ActionSupport {

    private UserService userService;

    /**
     * 进行登录校验
     *
     * @return 页面
     * @throws Exception
     */
    public String login() throws Exception {
        ModelMap modelMap = new ModelMap();
        HttpServletRequest request = ServletActionContext.getRequest();
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String s = userService.checkUser(name, password);
        modelMap.addAttribute("msg", s);
        if ("ERROR".equals(s)) {
            return "error";
        }
        return "success";
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
