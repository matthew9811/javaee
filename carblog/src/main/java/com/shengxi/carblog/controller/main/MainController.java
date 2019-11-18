package com.shengxi.carblog.controller.main;

import com.shengxi.carblog.pojo.User;
import com.shengxi.carblog.pojo.weak.ResponsePojo;
import com.shengxi.carblog.service.admin.IUserService;
import com.shengxi.compent.utils.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author: matthew
 * @ClassName MainController
 * @Date: 2019-09-18 22:35
 * @Version: 1.0.0
 * @description: 系统基础功能控制器
 */
@Controller
public class MainController {

    private IUserService userService;
    private String prefix = "";

    @GetMapping("/register")
    public String register(){
        return prefix + "/register";
    }

    /**
     * 进入前台login
     * @return login.html
     */
    @GetMapping("/login")
    public String login() {
        return prefix + "/blog/blog-login";
    }

    @GetMapping("/")
    public String pageHome() {
        return prefix + "/pageHome";
    }

    /**
     * 登录验证
     * 失败返回登录页面并返回提示信息。
     * <p>
     * 成功返回首页。
     * 进入首页时进行一个欢迎提示，
     *
     * @return
     */
    @PostMapping("/login")
    public String login(User loginUser, ModelMap modelMap) {
        ResponsePojo responsePojo = userService.loginVerify(loginUser);
        if (ResponseStatus.FAIL.equals(responsePojo.getStatus())) {
            modelMap.put("msg", "登录信息不正确!");
            return prefix + "/pageHome";
        }
        modelMap.put("msg", "欢迎登录博客家!");

        return prefix + "/pageHome";
    }

    @GetMapping("/adminLogin")
    public String adminLogin(){
        return prefix + "/admin/admin-login";
    }

    @Autowired
    public void setIUserService(IUserService userService) {
        this.userService = userService;
    }
}
