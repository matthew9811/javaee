package com.shengxi.carblog.controller.main;

import cn.hutool.core.util.BooleanUtil;
import cn.hutool.crypto.SecureUtil;
import com.shengxi.carblog.pojo.User;
import com.shengxi.carblog.pojo.weak.ResponsePojo;
import com.shengxi.carblog.pojo.weak.SessionMsgPojo;
import com.shengxi.carblog.service.admin.IUserService;
import com.shengxi.carblog.service.blog.IBlogService;
import com.shengxi.compent.utils.BaseController;
import com.shengxi.compent.utils.ResponseStatus;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: matthew
 * @ClassName MainController
 * @Date: 2019-09-18 22:35
 * @Version: 1.0.0
 * @description: 系统基础功能控制器
 */
@Controller
public class MainController extends BaseController {

    private IUserService userService;
    private String prefix = "";
    private IBlogService blogService;

    /**
     * 进入注册页面
     *
     * @return url
     */
    @GetMapping("/register")
    public String register() {
        return prefix + "/register";
    }


    /**
     * 实现注册信息保存
     *
     * @param register userBean
     * @param map      map
     * @return url
     */
    @PostMapping("/register")
    public String register(User register, ModelMap map) {
        ResponsePojo responsePojo = userService.register(register);
        if (ResponseStatus.SUCCESS.equals(responsePojo.getStatus())) {
            map.addAttribute("msg", responsePojo.getMsg());
            return prefix + "/index";
        }
        map.addAttribute("msg", responsePojo.getMsg());
        return prefix + "/register";
    }

    /**
     * 进入前台login
     *
     * @return login.html
     */
    @GetMapping("/login")
    public String login() {
        return prefix + "/blog/blog_login";
    }

    /**
     * 进入系统主页
     *
     * @return url
     */
    @GetMapping("/")
    public String index(Model model) {
        model.addAllAttributes(blogService.findNewBlog());
        return prefix + "/index";
    }

    /**
     * 登录验证
     * 失败返回登录页面并返回提示信息。
     * <p>
     * 成功返回首页。
     * 进入首页时进行一个欢迎提示，
     *
     * @return url
     */
    @PostMapping("/login")
    public String login(User loginUser, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
        ResponsePojo responsePojo = userService.loginVerify(loginUser);
        if (ResponseStatus.FAIL.equals(responsePojo.getStatus())) {
            modelMap.put("msg", "登录信息不正确!");
            return prefix + "/blog/blog_login";
        }
        /**保存登录验证*/
        Cookie cookie = saveToSessionAndCookies(request, loginUser);
        response.addCookie(cookie);
        modelMap.put("msg", "欢迎登录博客家!");

        modelMap.addAllAttributes(blogService.findNewBlog());
        return prefix + "/index";
    }

    /**
     * 进入管理员登录页面
     *
     * @return url
     */
    @GetMapping("/adminLogin")
    public String adminLogin() {
        return prefix + "/admin/admin_login";
    }

    @PostMapping("/adminLogin")
    public String adminLogin(User loginUser, ModelMap map) {
        Boolean aBoolean = userService.loginManagerVerify(loginUser);
        if (aBoolean) {
            return prefix + "/admin/index";
        }
        map.addAttribute("msg", "口令不准确！");
        return prefix + "/admin/admin_login";
    }

    @GetMapping("/logout")
    public String logout(ModelMap modelMap, HttpServletRequest request) {
        this.deleteSession(request);
        modelMap.addAllAttributes(blogService.findNewBlog());
        return prefix + "/index";
    }

    @GetMapping("/adminOut")
    public String adminOut(ModelMap modelMap, HttpServletRequest request) {
        this.deleteSession(request);
        return prefix + "/admin/admin_login";
    }

    /**
     * 注册用户验证（尚未完成）
     *
     * @param username name
     * @return ResponsePojo 返回消息实体
     */
    @GetMapping("/checkUserName/{username}")
    @ResponseBody
    public ResponsePojo checkUserName(@PathVariable(name = "username") String username) {
        Boolean nameVerify = userService.userNameVerify(username);
        String msg;
        ResponseStatus status;
        /*存在的时候返回false*/
        if (BooleanUtil.isFalse(nameVerify)) {
            status = ResponseStatus.FAIL;
            msg = "用户名已被占用";
        } else {
            status = ResponseStatus.SUCCESS;
            msg = "用户名有效";
        }
        return getResponsePojo(status, msg);
    }

    @Autowired
    public void setIUserService(IUserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setBlogService(IBlogService blogService) {
        this.blogService = blogService;
    }

    /**
     * 将用户名保存在session中
     *
     * @param request   请求
     * @param loginUser 登录用户
     */
    private Cookie saveToSessionAndCookies(HttpServletRequest request, User loginUser) {
        /* 将信息保存在session中，避免登录有效被篡改和私密信息被截取。 */
        String sha1 = SecureUtil.sha1(loginUser.getName());
        HttpSession session = request.getSession();
        session.setAttribute(sha1, new SessionMsgPojo(LocalDateTime.now(), loginUser.getName()));
        /*cookies只保留用户名的sha1值*/
        return new Cookie("user", sha1);
    }

    /**
     * 删除session中对应登录记录值
     *
     * @param request
     */
    private void deleteSession(HttpServletRequest request) {
        String user = Arrays.asList(request.getCookies()).stream().
                collect(Collectors.toMap(Cookie::getName, Cookie::getName)).get("user");
        request.getSession().removeAttribute(user);
    }
}
