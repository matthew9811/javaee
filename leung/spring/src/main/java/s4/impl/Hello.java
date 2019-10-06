package s4.impl;

import s4.IHello;

/**
 * @Author: matthew
 * @ClassName Hello
 * @Date: 2019-10-02 15:36
 * @Version: 1.0.0
 * @description:
 */
public class Hello implements IHello {


    @Override
    public void sayHello(String name) {
        System.out.println("hello: " + name);
    }

    @Override
    public void sayBey(String name) {
        System.out.println(name + " GoodBey!");
    }
}
