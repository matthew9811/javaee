package com.shengxi.leung.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.shengxi.leung.StrutsAction;

/**
 * @Author: matthew
 * @ClassName MyInterceptor
 * @Date: 2019-09-28 16:35
 * @Version: 1.0.0
 * @description: 自定义拦截器
 * <p>
 * AbstractInterceptor书本源码错误
 */
public class MyInterceptor extends AbstractInterceptor {

    public final static String HELLO = "hello";

    @Override
    public String intercept(ActionInvocation act) throws Exception {
        StrutsAction action = (StrutsAction) act.getAction();
//        如果action中的name是hello
        if (action.getName().equals(HELLO)) {
            return Action.ERROR;
        }
        //执行过滤链
        return act.invoke();
    }
}
