package com.shengxi.carblog.controller.main;

import org.apache.catalina.connector.Response;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: matthew
 * @ClassName RestErrorController
 * @Date: 2019-09-22 18:13
 * @Version: 1.0.0
 * @description: 统一错误页面跳转
 */
@Controller
public class RestErrorController implements ErrorController {

    private static final String ERROR_PATH = "/common";

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @RequestMapping("/error/404")
    public String handleError(HttpServletRequest request) {
        return ERROR_PATH.concat("/404");
    }

}
