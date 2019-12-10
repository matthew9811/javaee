package com.shengxi.carblog.service.admin.impl;

import com.shengxi.carblog.repository.IBlogRepository;
import com.shengxi.carblog.repository.IManagerRepository;
import com.shengxi.carblog.repository.IUserRepository;
import com.shengxi.carblog.service.admin.IManagerService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yan
 */
@Service("manager")
public class ManagerServiceImpl implements IManagerService {

    private IManagerRepository managerRepository;

    private IUserRepository userRepository;

    private IBlogRepository blogRepository;


    @Override
    public Map<String, Object> initManagerPageData() {
        Map<String, Object> map = new HashMap(4);
        map.put("userNum", userRepository.count());
        map.put("blogNum", blogRepository.count());
        return map;
    }

    @Autowired
    public void setManagerRepository(IManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Autowired
    public void setUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setBlogRepository(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }
}
