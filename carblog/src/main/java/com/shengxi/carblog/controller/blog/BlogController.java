package com.shengxi.carblog.controller.blog;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.db.Page;
import com.alibaba.fastjson.JSONObject;
import com.shengxi.carblog.pojo.weak.ResponsePojo;
import com.shengxi.carblog.service.blog.IBlogService;
import com.shengxi.carblog.service.blog.ICommentService;
import com.shengxi.carblog.service.blog.IPhotoService;
import com.shengxi.compent.aop.annotation.LoginStatus;
import com.shengxi.compent.utils.BaseController;
import com.shengxi.compent.utils.ResponseStatus;
import com.shengxi.compent.utils.UserUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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

    private IPhotoService photoService;

    private ICommentService commentService;

    @GetMapping("/about")
    public String about() {
        return prefix + "/about";
    }

    @GetMapping("/addBlog")
    public String addBlog() {
        if (ObjectUtil.isEmpty(UserUtil.getUserName())) {
            return "/blog/blog_login";
        }
        return prefix + "/add_blog";
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


    @GetMapping("/addPhoto")
    public String addPhoto() {
        if (ObjectUtil.isEmpty(UserUtil.getUserName())) {
            return "/blog/blog_login";
        }
        return prefix + "/add_photo";
    }

    @PostMapping("/addPhoto")
    @ResponseBody
    public ResponsePojo addPhoto(@RequestBody Map data) throws IOException {
        return photoService.addPhoto(data);
    }

    /**
     * 通过id获取博客详情
     *
     * @param id
     * @return
     */
    @GetMapping("/blog/{id}")
    public String blog(@PathVariable("id") String id, Model model) {
        model.addAllAttributes(blogService.findBlogById(id));
        return prefix + "/blog";
    }

    @GetMapping("/blogIndex")
    public String blogIndex(Model model) {
        model.addAllAttributes(blogService.findNewBlog());
        model.addAllAttributes(photoService.findPhotoList());
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
    public String photoIndex(Model model) {
        model.addAllAttributes(blogService.findNewBlog());
        model.addAllAttributes(photoService.findPhotoList());
        return prefix + "/photo_index";
    }

    @GetMapping("/photo/{id}")
    public String photo(@PathVariable("id") Integer id, Model model) {
        model.addAllAttributes(photoService.findPhotoDetail(id));
        return prefix + "/photo";
    }

    @PostMapping("/addComment")
    @ResponseBody
    public ResponsePojo addComment(@RequestBody Map params) {
        ResponsePojo pojo = commentService.addNewComment(params);
        return ObjectUtil.isNull(pojo) ? new ResponsePojo(ResponseStatus.FAIL, "评论失败，请稍后再试!") : pojo;
    }

    @GetMapping("/initData")
    @ResponseBody
    public ResponsePojo initData() {
        return blogService.findLastestBlog();
    }


    @Autowired
    public void setBlogService(IBlogService blogService) {
        this.blogService = blogService;
    }

    @Autowired
    public void setPhotoService(IPhotoService photoService) {
        this.photoService = photoService;
    }

    @Autowired
    public void setCommentService(ICommentService commentService) {
        this.commentService = commentService;
    }
}
