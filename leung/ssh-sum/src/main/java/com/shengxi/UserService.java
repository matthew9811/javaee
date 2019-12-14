package com.shengxi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务层
 *
 * @author yan
 * @date 2019-12-15 01:24:43
 */
@Service("userService")
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 查找数据库是否有对应数据
     *
     * @param name     name
     * @param password pwd
     * @return msg
     */
    public String checkUser(String name, String password) {
        boolean flag = userDao.checkUser(name, password);
        if (flag == false) {
            return "ERROR";
        }
        return "SUCCESS";
    }


    /**
     * @param user pojo
     * @return int status
     */
    public int addUser(User user){
        return userDao.addUser(user);
    }
}
