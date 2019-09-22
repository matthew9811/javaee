package com.shengxi.carblog.service.admin.test.impl;

import com.shengxi.carblog.pojo.TestUser;
import com.shengxi.carblog.repository.TestUserRepository;
import com.shengxi.carblog.service.admin.test.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: matthew
 * @ClassName TestUserServiceImpl
 * @Date: 2019-09-22 17:43
 * @Version: 1.0.0
 * @description:
 */
@Primary
@Service("testUser")
public class TestUserServiceImpl implements TestUserService {


    private TestUserRepository userRepository;

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public TestUser findByName(String name) {
        return userRepository.findUserByName(name);
    }

    @Autowired
    public void setUserRepository(TestUserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
