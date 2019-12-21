package com.shengxi.carblog.controller.blog;

import com.alibaba.fastjson.JSONObject;
import com.shengxi.carblog.pojo.weak.ResponsePojo;
import com.shengxi.carblog.service.blog.IBlogService;
import com.shengxi.compent.aop.annotation.LoginStatus;
import com.shengxi.compent.utils.BaseController;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * blog模块控制器
 *
 * @author yan
 * @date 2019-11-18 21:01:46
 */
@Controller
@RequestMapping("/blog")
public class BlogController extends BaseController {

    private String prefix = "/blog";

    private IBlogService blogService;

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

    /**
     * 通过id获取博客详情
     *
     * @param id
     * @return
     */
    @GetMapping("/blog/{id}")
    public String blog(@PathVariable("id") String id, Model model) {
        model.addAttribute("blog", blogService.findBlogById(id));
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

    /**
     * 新增博客
     *
     * @param data 博客参数
     * @return 响应tips
     */
    @LoginStatus(value = true)
    @PostMapping("/addBlog")
    @ResponseBody
    public ResponsePojo addBlog(@RequestBody Map data) throws IOException {
        return blogService.addBlog(data);
    }

    @Autowired
    public void setBlogService(IBlogService blogService) {
        this.blogService = blogService;
    }
}
