package com.shengxi.carblog.service.admin;

import com.shengxi.carblog.pojo.User;
import com.shengxi.carblog.pojo.weak.ResponsePojo;

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

    /**
     * 进行注册用户
     *
     * @param register userBean
     * @return status and msg
     */
    ResponsePojo register(User register);

    /**
     * 查看用户名是否已经被占用
     * 存在返回false，
     * 不存在返回true
     *
     * @param username nameString
     * @return bool
     */
    Boolean userNameVerify(String username);

    Boolean loginManagerVerify(User loginUser);
}
