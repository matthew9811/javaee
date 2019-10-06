package s5.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Author: matthew
 * @ClassName BaseLoginAdvice
 * @Date: 2019-10-06 20:12
 * @Version: 1.0.0
 * @description:
 */
public abstract class BaseLoginAdvice implements MethodBeforeAdvice, MethodInterceptor, AfterReturningAdvice {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        throw new UnsupportedOperationException("abstract class BaseLoginAdvice not implement this method");
    }

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        throw new UnsupportedOperationException("abstract class BaseLoginAdvice not implement this method");
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        throw new UnsupportedOperationException("abstract class BaseLoginAdvice not implement this method");
    }
}
