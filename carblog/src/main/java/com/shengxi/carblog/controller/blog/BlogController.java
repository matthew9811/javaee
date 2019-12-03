package com.shengxi.carblog.controller.blog;

import com.shengxi.compent.utils.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * blog模块控制器
 * @author yan
 * @date 2019-11-18 21:01:46
 */
@Controller
@RequestMapping("/blog")
public class BlogController extends BaseController {

    private String prefix = "/blog";

    @GetMapping("/add")
    public String add() {
        return prefix + "/add_blog";
    }
}
