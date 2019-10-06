package s4.impl;

import org.junit.Test;
import s4.IHello;

import static org.junit.Assert.*;

/**
 * @Author: matthew
 * @ClassName DynaProxyHelloTest
 * @Date: 2019-10-03 11:37
 * @Version: 1.0.0
 * @description:
 */
public class DynaProxyHelloTest {

    @Test
    public void test(){
        IHello hello = (IHello) new DynaProxyHello().bind(new Hello());
        hello.sayHello("SpringAOP!");
        hello.sayBey("springAOP!");
    }

}