package com.shengxi;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author chuling
 */
@Repository
public class UserDao {

    //    @Resource(name="hibernateTemplate")
    @Autowired
    private HibernateTemplate hibernate;

    public boolean checkUser(String name, String pwd) {
        List<User> list = (List<User>) hibernate.find("from User where name = ? and password = ? ", name, pwd);
        if (list.isEmpty()) {
            return false;
        }
        return true;
    }

    public int addUser(User user) {
        try {
            hibernate.save(user);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}