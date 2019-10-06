package s2.impl;

import s2.Person;

/**
 * @Author: matthew
 * @ClassName Chinese
 * @Date: 2019-10-02 15:19
 * @Version: 1.0.0
 * @description:
 */
public class Chinese implements Person {
    @Override
    public void sayHello() {
        System.out.println("你好");
    }

    @Override
    public void sayBey() {
        System.out.println("再见");
    }
}
