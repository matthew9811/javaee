package s4.impl;

import s4.IHello;

/**
 * @Author: matthew
 * @ClassName HelloProxy
 * @Date: 2019-10-03 11:23
 * @Version: 1.0.0
 * @description:
 */
public class HelloProxy implements IHello {

    private IHello hello;

    public HelloProxy(IHello hello) {
        this.hello = hello;
    }

    @Override
    public void sayHello(String name) {
        System.out.println("sayHello method start");
        hello.sayHello(name);
        System.out.println("sayHello method end");
    }

    @Override
    public void sayBey(String name) {

    }
}
