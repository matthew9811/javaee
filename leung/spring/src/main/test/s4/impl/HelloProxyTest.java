package s4.impl;

import org.junit.Test;
import s4.IHello;

import static org.junit.Assert.*;

/**
 * @Author: matthew
 * @ClassName HelloProxyTest
 * @Date: 2019-10-03 1:30
 * @Version: 1.0.0
 * @description:
 */
public class HelloProxyTest {

    @Test
    public void sayHello() {
        IHello hello = new Hello();
        hello.sayHello("SpringAop!");
    }
}