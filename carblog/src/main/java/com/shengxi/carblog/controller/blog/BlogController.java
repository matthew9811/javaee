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

    @GetMapping("/addBlog")
    public String addBlog() {
        return prefix + "/add_blog";
    }

    @GetMapping("/addPhoto")
    public String addPhoto() {
        return prefix + "/add_photo";
    }

    @GetMapping("/photo")
    public String photo() {
        return prefix + "/photo_index";
    }
}
