package com.shengxi.carblog.controller.main;

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

    private String prefix = "";


    @GetMapping("/login")
    public String login() {
        return prefix + "/blog/login";
    }

    @GetMapping("/")
    public String pageHome() {
        return prefix + "/pageHome";
    }

    /**
     * 登录验证，成功返回首页。失败返回信息。
     * 进入首页时进行一个欢迎提示，
     *
     * @return
     */
    @PostMapping("/login")
    public String login(ModelMap modelMap) {

        return prefix + "/blog/blogIndex";
    }
}
