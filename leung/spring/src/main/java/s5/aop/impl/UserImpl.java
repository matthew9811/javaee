package s5.aop.impl;

import s5.aop.IUser;

/**
 * @Author: matthew
 * @ClassName UserImpl
 * @Date: 2019-10-06 20:10
 * @Version: 1.0.0
 * @description:
 */
public class UserImpl implements IUser {



    @Override
    public void Login(String name, String pwd) {
        System.out.println("程序正在执行 类名： UserImpl 方法名： Login.....");
    }
}
