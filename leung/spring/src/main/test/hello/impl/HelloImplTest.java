package hello.impl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @Author: matthew
 * @ClassName HelloImplTest
 * @Date: 2019-10-02 15:14
 * @Version: 1.0.0
 * @description: 实例7-1
 */
public class HelloImplTest {

    @Test
    public void hello() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloImpl hello = (HelloImpl) ctx.getBean("hellospring");
        hello.hello();
    }
}