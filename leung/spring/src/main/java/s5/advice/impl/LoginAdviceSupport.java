package s5.advice.impl;

import org.aopalliance.intercept.MethodInvocation;
import s5.advice.BaseLoginAdvice;

import java.lang.reflect.Method;

/**
 * @Author: matthew
 * @ClassName LoginAdviceSupport
 * @Date: 2019-10-06 20:16
 * @Version: 1.0.0
 * @description:
 */
public class LoginAdviceSupport extends BaseLoginAdvice {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        System.out.println("---------程序正在执行类型 class LoginAdviceSupport 方法名：invoke----------------");
        String user = methodInvocation.getArguments()[0].toString();
        String pwd = methodInvocation.getArguments()[1].toString();

        return methodInvocation.proceed();
    }

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("---------程序正在执行类型 class LoginAdviceSupport 方法名：afterReturning----------------");
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("---------程序正在执行类型 class LoginAdviceSupport 方法名：before----------------");
        String user = (String) objects[0];
        String pwd = (String) objects[1];
        //执行数据操作
    }
}
