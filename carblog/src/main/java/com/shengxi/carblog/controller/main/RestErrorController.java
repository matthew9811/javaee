package com.shengxi.carblog.controller.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;

/**
 * @Author: matthew
 * @ClassName RestErrorController
 * @Date: 2019-09-22 18:13
 * @Version: 1.0.0
 * @description: 统一错误页面跳转
 */
@Controller
public class RestErrorController implements ErrorController {

    private static final String ERROR_PATH_404 = "/common/404";

    @Autowired
    private ErrorAttributes errorAttributes;
    @Override
    public String getErrorPath() {
        return ERROR_PATH_404;
    }


}
