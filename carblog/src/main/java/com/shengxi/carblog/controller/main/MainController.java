package com.shengxi.carblog.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: matthew
 * @ClassName MainController
 * @Date: 2019-09-18 22:35
 * @Version: 1.0.0
 * @description:
 */
@Controller
public class MainController {

    private String prefix = "";


    @GetMapping("")
    public String login(){
        return "/login";
    }
}
