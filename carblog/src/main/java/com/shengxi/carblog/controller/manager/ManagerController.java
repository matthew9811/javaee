package com.shengxi.carblog.controller.manager;

import com.shengxi.compent.utils.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台控制器
 * @author yan
 * @version 1.0.1
 * @date 2019-11-20 11:26:21
 */
@Controller
@RequestMapping("/manager")
public class ManagerController extends BaseController {

    private String prefix = "/admin";

    @GetMapping("/index")
    public String index() {
        return prefix + "/index";
    }

    @GetMapping("/article")
    public String article() {
        return prefix + "/article";
    }

    @GetMapping("/notice")
    public String notice() {
        return prefix + "/notice";
    }

    @GetMapping("/comment")
    public String comment() {
        return prefix + "/comment";
    }

    @GetMapping("/manage")
    public String manage() {
        return prefix + "/manage_user";
    }

    @GetMapping("/log")
    public String log() {
        return prefix + "/login_log";
    }
}
