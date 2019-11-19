package com.shengxi.carblog.service.admin.impl;

import cn.hutool.core.util.ObjectUtil;
import com.shengxi.carblog.pojo.User;
import com.shengxi.carblog.pojo.weak.ResponsePojo;
import com.shengxi.carblog.repository.IUserRepository;
import com.shengxi.carblog.service.admin.IUserService;
import com.shengxi.compent.constant.StatusConstant;
import com.shengxi.compent.constant.UserConstant;
import com.shengxi.compent.utils.ResponseStatus;
import java.time.LocalDateTime;
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

    private IUserRepository userRepository;

    /**
     * @param loginUser userBean
     * @return ResponsePojo
     */
    @Override
    @Transactional(readOnly = true)
    public ResponsePojo loginVerify(User loginUser) {
        Long count = userRepository.countByNameAndPwd(loginUser.getName(), loginUser.getPwd());
        return new ResponsePojo(count != 0 ? ResponseStatus.SUCCESS : ResponseStatus.FAIL, "SUCCESS");
    }

    /**
     * 给注册信息填充默认值，然后保存。保存成功，返回tips。
     * 失败，tips。
     *
     * @param register userBean
     * @return ResponsePojo
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponsePojo register(User register) {
        ResponsePojo response = new ResponsePojo();
        register.setContent(UserConstant.DEFAULT_CONTENT);
        register.setAvatarUrl(UserConstant.DEFAULT_AVATAR_URL);
        register.setCreateTime(LocalDateTime.now());
        register.setStatus(StatusConstant.USER_CONFIG_STATUS);
        register = userRepository.save(register);
        if (ObjectUtil.isNotNull(register)) {
            response.setInstance(ResponseStatus.SUCCESS, "register successful!");
        } else {
            response.setInstance(ResponseStatus.FAIL, "register fail!");
        }
        return response;
    }


    @Autowired
    public void setUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
