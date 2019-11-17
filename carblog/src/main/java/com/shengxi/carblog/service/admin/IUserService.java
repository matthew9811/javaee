package com.shengxi.carblog.service.admin;

import com.shengxi.carblog.pojo.User;
import com.shengxi.carblog.pojo.weak.ResponsePojo;
import java.util.List;

/**
 * @author yan
 * @date 2019-11-14 00:06:20
 * 用户服务层
 */
public interface IUserService {
    /**
     * 验证登录信息是否有效
     *
     * @param loginUser userBean
     * @return status and msg
     */
    ResponsePojo loginVerify(User loginUser);

    List<User> listAll();

    Integer save(User newUser);

    User findByNameAndPwd(String name, String pwd);
}
