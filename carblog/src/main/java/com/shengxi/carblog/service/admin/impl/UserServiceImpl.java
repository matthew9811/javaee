package com.shengxi.carblog.service.admin.impl;

import com.shengxi.carblog.pojo.User;
import com.shengxi.carblog.pojo.weak.ResponsePojo;
import com.shengxi.carblog.repository.IUserRepository;
import com.shengxi.carblog.service.admin.IUserService;
import com.shengxi.compent.utils.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yan
 * @version 1.0.0
 * @date 2019-11-14 00:14:05
 * 用户服务层实现
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    /**
     *
     * @param loginUser userBean
     * @return ResponsePojo
     */
    @Override
    @Transactional(readOnly = true)
    public ResponsePojo loginVerify(User loginUser) {
        Integer count = userRepository.countByNameAndPwd(loginUser.getName(), loginUser.getPwd());
        System.out.println(count);
        return new ResponsePojo(ResponseStatus.FAIL, "SUCCESS");
    }

}
