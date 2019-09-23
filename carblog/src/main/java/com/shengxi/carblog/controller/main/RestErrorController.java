package com.shengxi.carblog.controller.main;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
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

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == Response.SC_UNAUTHORIZED) {
            return ERROR_PATH.concat("/401");
        } else if (statusCode == Response.SC_NOT_FOUND) {
            return ERROR_PATH.concat("/404");
        } else if (statusCode == Response.SC_FORBIDDEN) {
            return ERROR_PATH.concat("/403");
        } else {
            return ERROR_PATH.concat("/500");
        }

    }

}
