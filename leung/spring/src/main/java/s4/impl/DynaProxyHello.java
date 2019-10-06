package s4.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: matthew
 * @ClassName DynaProxyHello
 * @Date: 2019-10-03 11:33
 * @Version: 1.0.0
 * @description:
 */
public class DynaProxyHello implements InvocationHandler {

    private Object delegate;

    public Object bind(Object delegate) {
        this.delegate = delegate;
        return Proxy.newProxyInstance(this.delegate.getClass().getClassLoader(), this.delegate.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            System.out.println(method.getName() + "Method end!");
            return method.invoke(this.delegate, args);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
