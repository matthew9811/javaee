package com.shengxi.carblog.service.admin.impl;

import com.shengxi.carblog.pojo.User;
import com.shengxi.carblog.pojo.weak.ResponsePojo;
import com.shengxi.carblog.repository.IUserRepository;
import com.shengxi.carblog.service.admin.IUserService;
import com.shengxi.compent.utils.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yan
 * @version 1.0.0
 * @date 2019-11-14 00:14:05
 * 用户服务层实现
 */
@Service
public class UserServiceImpl implements IUserService {

    private IUserRepository userRepository;

    /**
     *
     * @param loginUser userBean
     * @return ResponsePojo
     */
    @Override
    public ResponsePojo loginVerify(User loginUser) {
        Integer count = userRepository.countIntegerByNameAndPwd(loginUser.getName(), loginUser.getPwd());
        System.out.println(count);
        return new ResponsePojo(ResponseStatus.FAIL, "SUCCESS");
    }

    @Autowired
    public void setUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
