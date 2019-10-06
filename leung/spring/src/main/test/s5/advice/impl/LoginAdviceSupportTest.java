package s5.advice.impl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import s5.aop.IUser;

import static org.junit.Assert.*;

/**
 * @Author: matthew
 * @ClassName LoginAdviceSupportTest
 * @Date: 2019-10-06 20:26
 * @Version: 1.0.0
 * @description:
 */
public class LoginAdviceSupportTest {

    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUser user = (IUser) ctx.getBean("user");
        user.Login("username", "03241654");
    }
}