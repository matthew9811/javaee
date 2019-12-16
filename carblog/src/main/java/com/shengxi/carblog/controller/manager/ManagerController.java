package com.shengxi.carblog.controller.manager;

import com.shengxi.carblog.pojo.weak.ResponsePojo;
import com.shengxi.carblog.service.admin.IManagerService;
import com.shengxi.compent.utils.BaseController;
import com.shengxi.compent.utils.ResponseStatus;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    private IManagerService managerService;

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

    @GetMapping("/manageAdmin")
    public String manageAdmin() {
        return prefix + "/manage_admin";
    }

    @GetMapping("/log")
    public String log() {
        return prefix + "/login_log";
    }

    @GetMapping("/add")
    public String add() {
        return prefix + "/add_article";
    }

    @GetMapping("/initData")
    @ResponseBody
    public ResponsePojo initData(){
        return getResponsePojo(managerService.initManagerPageData());
    }




    @Autowired
    public void setManagerService(IManagerService managerService) {
        this.managerService = managerService;
    }
}
