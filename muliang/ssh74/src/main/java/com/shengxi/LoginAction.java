package com.shengxi;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;


/**
 * @author chuling
 */
public class LoginAction extends ActionSupport {

    @Autowired
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
}

