package com.shengxi.carblog.service.admin.impl;

import cn.hutool.core.util.ObjectUtil;
import com.shengxi.carblog.pojo.Manager;
import com.shengxi.carblog.pojo.weak.ResponsePojo;
import com.shengxi.carblog.pojo.weak.bigTable.UserBlogLog;
import com.shengxi.carblog.repository.IBlogRepository;
import com.shengxi.carblog.repository.ICommentRepository;
import com.shengxi.carblog.repository.IDrawRepository;
import com.shengxi.carblog.repository.IManagerRepository;
import com.shengxi.carblog.repository.IUserBlogLogRepository;
import com.shengxi.carblog.repository.IUserRepository;
import com.shengxi.carblog.service.admin.IManagerService;
import com.shengxi.compent.constant.StatusConstant;
import com.shengxi.compent.utils.ResponseStatus;
import com.shengxi.compent.utils.UserUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yan
 */
@Service("manager")
public class ManagerServiceImpl implements IManagerService {

    private IManagerRepository managerRepository;

    private IUserRepository userRepository;

    private IBlogRepository blogRepository;

    private ICommentRepository commentRepository;

    private IUserBlogLogRepository userBlogLogRepository;

    private IDrawRepository drawRepository;


    @Override
    public Map<String, Object> initManagerPageData() {
        Map<String, Object> map = new HashMap(4);
        map.put("userNum", userRepository.count());
        map.put("blogNum", blogRepository.count());
        map.put("commentNum", commentRepository.count());
        map.put("drawTitleNum", drawRepository.count());
        return map;
    }


    @Override
    public List<UserBlogLog> findAllUser() {
        return userBlogLogRepository.selectAllUserBlogLog();
    }

    @Override
    public List<Manager> findAdmin() {
        List<Manager> managerList = managerRepository.findAll();
        return managerList;
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ResponsePojo updateStatus(String blogId, String blogPassStatus) {
        int count = blogRepository.passBlog(blogId, blogPassStatus, userRepository.findByName(UserUtil.getUserName()).getId());
        if (count == 1) {
            return new ResponsePojo(ResponseStatus.SUCCESS, "审核成功!");
        }
        return new ResponsePojo(ResponseStatus.FAIL, "审核失败!");
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ResponsePojo updateRecommend(String blogId, String recommendStatus) {
        int count = blogRepository.recommendBlog(blogId, recommendStatus, userRepository.findByName(UserUtil.getUserName()).getId());
        if (count == 1) {
            return new ResponsePojo(ResponseStatus.SUCCESS, "推荐成功!");
        }
        return new ResponsePojo(ResponseStatus.FAIL, "推荐失败!");
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ResponsePojo userStatus(Integer id, String status){
        int count = userRepository.updateStatus(id, status);
        if (count == 1) {
            return new ResponsePojo(ResponseStatus.SUCCESS, "操作成功!");
        }
        return new ResponsePojo(ResponseStatus.FAIL, "操作失败!");
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ResponsePojo adminStatus(Integer id, String status){
        int count = managerRepository.updateStatus(id, status);
        if (count == 1) {
            return new ResponsePojo(ResponseStatus.SUCCESS, "操作成功!");
        }
        return new ResponsePojo(ResponseStatus.FAIL, "操作失败!");
    }

    @Override
    public ResponsePojo addAdmin(Integer id) {
        Manager manager = new Manager();
        manager.setMakeUp(userRepository.findByName(UserUtil.getUserName()));
        manager.setStatus(StatusConstant.USER_CONFIG_STATUS);
        manager.setUser(userRepository.findById(id).get());
        Manager save = managerRepository.save(manager);
        if (ObjectUtil.isNotEmpty(save)) {
            ResponsePojo pojo = new ResponsePojo(ResponseStatus.SUCCESS, "操作成功!");
            return pojo;
        }
        return new ResponsePojo(ResponseStatus.FAIL, "服务器错误，请稍后再试!");
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

    @Autowired
    public void setCommentRepository(ICommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Autowired
    public void setUserBlogLogRepository(IUserBlogLogRepository userBlogLogRepository) {
        this.userBlogLogRepository = userBlogLogRepository;
    }

    @Autowired
    public void setDrawRepository(IDrawRepository drawRepository) {
        this.drawRepository = drawRepository;
    }
}
