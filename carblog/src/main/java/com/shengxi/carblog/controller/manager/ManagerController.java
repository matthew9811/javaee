package com.shengxi.carblog.controller.manager;

import cn.hutool.core.util.ObjectUtil;
import com.shengxi.carblog.pojo.weak.ResponsePojo;
import com.shengxi.carblog.repository.IBlogRepository;
import com.shengxi.carblog.service.admin.IManagerService;
import com.shengxi.carblog.service.blog.IBlogService;
import com.shengxi.compent.constant.StatusConstant;
import com.shengxi.compent.utils.BaseController;
import com.shengxi.compent.utils.ResponseStatus;
import com.shengxi.compent.utils.UserUtil;
import java.util.Collections;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 后台控制器
 *
 * @author yan
 * @version 1.0.1
 * @date 2019-11-20 11:26:21
 */
@Controller
@RequestMapping("/manager")
public class ManagerController extends BaseController {

    private String prefix = "/admin";

    private IManagerService managerService;

    private IBlogService blogService;

    /**
     * 进入主页
     *
     * @return url
     */
    @GetMapping("/index")
    public String index() {
        if (ObjectUtil.isEmpty(UserUtil.getUserName())) {
            return "/admin/admin_login";
        }
        return prefix + "/index";
    }

    /**
     * 进入文章
     *
     * @return url
     */
    @GetMapping("/article")
    public String article(@RequestParam Map<String, Object> params, ModelMap modelMap) {
        if (ObjectUtil.isEmpty(UserUtil.getUserName())) {
            return "/admin/admin_login";
        }
        params.put("page", Integer.valueOf((String) params.get("offset")) / Integer.valueOf((String) params.get("limit")) + 1);
        modelMap.addAttribute("pageList", blogService.findAllByPage(params).getContent());
        return prefix + "/article";
    }

    @GetMapping("/recommend")
    public String recommend(@RequestParam Map<String, Object> params, ModelMap modelMap) {
        if (ObjectUtil.isEmpty(UserUtil.getUserName())) {
            return "/admin/admin_login";
        }
        params.put("page", Integer.valueOf((String) params.get("offset")) / Integer.valueOf((String) params.get("limit")) + 1);
        modelMap.addAttribute("pageList", blogService.findPassByPage(params).getContent());
        return prefix + "/recommend";
    }

    @GetMapping("/notice")
    public String notice() {
        if (ObjectUtil.isEmpty(UserUtil.getUserName())) {
            return "/admin/admin_login";
        }
        return prefix + "/notice";
    }

    @GetMapping("/comment")
    public String comment() {
        if (ObjectUtil.isEmpty(UserUtil.getUserName())) {
            return "/admin/admin_login";
        }
        return prefix + "/comment";
    }

    @GetMapping("/manage")
    public String manage(ModelMap modelMap) {
        if (ObjectUtil.isEmpty(UserUtil.getUserName())) {
            return "/admin/admin_login";
        }
        modelMap.addAttribute("list", managerService.findAllUser());
        return prefix + "/manage_user";
    }

    @GetMapping("/manageAdmin")
    public String manageAdmin() {
        if (ObjectUtil.isEmpty(UserUtil.getUserName())) {
            return "/admin/admin_login";
        }
        return prefix + "/manage_admin";
    }

    @GetMapping("/log")
    public String log() {
        if (ObjectUtil.isEmpty(UserUtil.getUserName())) {
            return "/admin/admin_login";
        }
        return prefix + "/login_log";
    }

    @GetMapping("/add")
    public String add() {
        if (ObjectUtil.isEmpty(UserUtil.getUserName())) {
            return "/admin/admin_login";
        }
        return prefix + "/add_article";
    }

    @GetMapping("/tips")
    public String tips() {
        if (ObjectUtil.isEmpty(UserUtil.getUserName())) {
            return "/admin/admin_login";
        }
        return prefix + "/tips";
    }

    @GetMapping("/initData")
    @ResponseBody
    public ResponsePojo initData() {
        return getResponsePojo(managerService.initManagerPageData());
    }

    @GetMapping("/editUser/{id}")
    @ResponseBody
    public ResponsePojo editUser(@PathVariable("id") Integer id) {
        boolean b = managerService.editUser(id);
        if (true == b) {
            getResponsePojo(ResponseStatus.SUCCESS, "修改成功");
        }
        return getResponsePojo(ResponseStatus.FAIL, "修改失败");
    }

    @PostMapping("/blogPass")
    @ResponseBody
    public ResponsePojo blogPass(@RequestBody String blogId){
        blogId = blogId.replace("id=", "");
        return managerService.updateStatus(blogId, StatusConstant.BLOG_PASS_STATUS);
    }

    @PostMapping("/blogDelete")
    @ResponseBody
    public ResponsePojo blogDelete(@RequestBody String blogId){
        blogId = blogId.replace("id=", "");
        return managerService.updateStatus(blogId, StatusConstant.BLOG_REFUSE_STATUS);
    }

    @Autowired
    public void setManagerService(IManagerService managerService) {
        this.managerService = managerService;
    }

    @Autowired
    public void setBlogService(IBlogService blogService) {
        this.blogService = blogService;
    }
}
