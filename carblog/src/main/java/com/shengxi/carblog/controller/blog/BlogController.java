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

    @GetMapping("/about")
    public String about() {
        return prefix + "/about";
    }

    @GetMapping("/addBlog")
    public String addBlog() {
        return prefix + "/add_blog";
    }

    @GetMapping("/addPhoto")
    public String addPhoto() {
        return prefix + "/add_photo";
    }

    @GetMapping("/blog")
    public String blog() {
        return prefix + "/blog";
    }

    @GetMapping("/blogIndex")
    public String blogIndex() {
        return prefix + "/blog_index";
    }

    @GetMapping("/contact")
    public String contact() {
        return prefix + "/contact";
    }

    @GetMapping("/person")
    public String person() {
        return prefix + "/person";
    }

    @GetMapping("/photoIndex")
    public String photo() {
        return prefix + "/photo_index";
    }

}
