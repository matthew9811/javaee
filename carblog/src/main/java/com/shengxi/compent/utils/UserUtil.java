package com.shengxi.compent.utils;

import cn.hutool.core.util.ObjectUtil;
import com.shengxi.carblog.pojo.weak.SessionMsgPojo;
import java.io.IOException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 用户
 * @author yan
 */
@Service("userUtil")
public class UserUtil {

    /**
     * 从session中获取用户名
     *
     * @return userName :String
     */
    public static String getUserName() {
        /* 获取请求 */
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        Cookie[] cookies = request.getCookies();
        HttpSession session = request.getSession();
        if (ObjectUtil.isNotEmpty(cookies) && ObjectUtil.isNotEmpty(session)) {
            for (Cookie cookie : cookies) {
                SessionMsgPojo pojo = (SessionMsgPojo) session.getAttribute(cookie.getValue());
                if (ObjectUtil.isNotEmpty(pojo)) {
                    return pojo.getMsg();
                }
            }
        }
        return null;
    }
}
