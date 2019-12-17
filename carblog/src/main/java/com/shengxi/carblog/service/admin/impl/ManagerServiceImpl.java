package com.shengxi.carblog.service.admin.impl;

import com.shengxi.carblog.pojo.weak.bigTable.UserBlogLog;
import com.shengxi.carblog.repository.IBlogRepository;
import com.shengxi.carblog.repository.ICommentRepository;
import com.shengxi.carblog.repository.IDrawTitleRepository;
import com.shengxi.carblog.repository.IManagerRepository;
import com.shengxi.carblog.repository.IUserBlogLogRepository;
import com.shengxi.carblog.repository.IUserRepository;
import com.shengxi.carblog.service.admin.IManagerService;
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

    private IDrawTitleRepository drawTitleRepository;

    private IUserBlogLogRepository userBlogLogRepository;


    @Override
    public Map<String, Object> initManagerPageData() {
        Map<String, Object> map = new HashMap(4);
        map.put("userNum", userRepository.count());
        map.put("blogNum", blogRepository.count());
        map.put("commentNum", commentRepository.count());
        map.put("drawTitleNum", drawTitleRepository.count());
        return map;
    }


    @Override
    public List<UserBlogLog> findAllUser() {
        return userBlogLogRepository.selectAllUserBlogLog();
    }

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = false)
    public boolean editUser(Integer id) {
        int i = userRepository.updateStatus("1", id);
        if (1 == i){
            return true;
        }
        return false;
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
    public void setDrawTitleRepository(IDrawTitleRepository drawTitleRepository) {
        this.drawTitleRepository = drawTitleRepository;
    }

    @Autowired
    public void setUserBlogLogRepository(IUserBlogLogRepository userBlogLogRepository) {
        this.userBlogLogRepository = userBlogLogRepository;
    }
}
