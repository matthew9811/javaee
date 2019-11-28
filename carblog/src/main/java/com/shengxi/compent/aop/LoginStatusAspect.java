package com.shengxi.compent.aop;

import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.ObjectUtil;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author yan
 * @version 1.0.0
 * @date 2019-11-26 17:00:23
 */
@Aspect
@Component
public class LoginStatusAspect {
    private final Logger logger = LoggerFactory.getLogger(LoginStatusAspect.class);

    @Pointcut()
    public void login() {
    }


    /**
     * 围绕注解进行切面编程
     *
     * @param joinPoint join point
     * @return
     * @throws Exception ex
     */
    @Around("@annotation(com.shengxi.compent.aop.annotation.LoginStatus)")
    public Object aroundManager(ProceedingJoinPoint joinPoint) throws Throwable {
        boolean flag =false;
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Cookie[] cookies = request.getCookies();
        HttpSession session = request.getSession();
        if (ObjectUtil.isNotEmpty(cookies) && ObjectUtil.isNotEmpty(session)) {

            for (Cookie cookie : cookies) {
                if (ObjectUtil.isNotEmpty(session.getAttribute(cookie.getValue()))) {
                    flag = !flag;
                }
            }
        }
        if (BooleanUtil.isFalse(flag)){
            return new ModelAndView("/login");
        }
        return joinPoint.proceed();
    }
}
