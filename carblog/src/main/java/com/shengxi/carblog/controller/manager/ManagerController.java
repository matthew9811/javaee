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
    public String index(){
        return prefix + "/index";
    }
}
