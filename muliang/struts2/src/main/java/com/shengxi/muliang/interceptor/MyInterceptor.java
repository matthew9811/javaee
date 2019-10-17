package com.shengxi.muliang.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.shengxi.muliang.StrutsAction;

/**
 * @author chuling
 *
 */
public class MyInterceptor extends AbstractInterceptor {


    public final static String HELLO = "hello";

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        StrutsAction action = (StrutsAction) actionInvocation.getAction();

        if (action.getName().equals(HELLO)) {
            return Action.ERROR;
        }

        return actionInvocation.invoke();
    }
}
