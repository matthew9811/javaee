package s2.impl;

import s2.Person;

/**
 * @Author: matthew
 * @ClassName American
 * @Date: 2019-10-02 15:21
 * @Version: 1.0.0
 * @description:
 */
public class American implements Person {
    @Override
    public void sayHello() {
        System.out.println("hello");
    }

    @Override
    public void sayBey() {
        System.out.println("bey");
    }
}
