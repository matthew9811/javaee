package hello.impl;

import hello.Hello;

/**
 * @Author: matthew
 * @ClassName HelloImpl
 * @Date: 2019-10-02 15:09
 * @Version: 1.0.0
 * @description:
 */

public class HelloImpl implements Hello {

    private String name;

    @Override
    public void hello() {
        System.out.println("hello: " + this.name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
