package com.shengxi.compent.utils.filter;

import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.shengxi.carblog.pojo.weak.SessionMsgPojo;
import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 自动更新登录有效期
 * @author yan
 * @version 1.0.0
 * @date 2019-11-27 23:47:09
 * @see javax.servlet.Filter
 */
@WebFilter(filterName = "LoginTimeFilter")
public class LoginTimeFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        /*获取cookies*/
        Cookie[] cookies = ((HttpServletRequest) req).getCookies();
        HttpSession session = ((HttpServletRequest) req).getSession();
        for (Cookie cookie : cookies) {
            String value = cookie.getValue();
            SessionMsgPojo attribute = (SessionMsgPojo) session.getAttribute(value);
            if (ObjectUtil.isNotNull(attribute)) {
                attribute.setLocalDateTime(LocalDateTime.now());
            }
        }


        chain.doFilter(req, resp);
    }


}
