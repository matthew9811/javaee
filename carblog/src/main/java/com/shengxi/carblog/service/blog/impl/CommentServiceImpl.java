package com.shengxi.carblog.service.blog.impl;

import cn.hutool.core.util.ObjectUtil;
import com.shengxi.carblog.pojo.Comment;
import com.shengxi.carblog.pojo.weak.ResponsePojo;
import com.shengxi.carblog.repository.ICommentRepository;
import com.shengxi.carblog.repository.IUserRepository;
import com.shengxi.carblog.service.blog.ICommentService;
import com.shengxi.compent.utils.ResponseStatus;
import com.shengxi.compent.utils.UserUtil;
import java.time.LocalDateTime;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 评论服务层实现
 *
 * @author yan
 * @version 1.1.0
 * @date 2019-12-23 23:20:12
 */
@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private ICommentRepository commentRepository;

    @Autowired
    private IUserRepository userRepository;


    @Override
    public ResponsePojo addNewComment(Map data) {
        Comment comment = new Comment();
        comment.setBlogId((String) data.get("blogId"));
        comment.setContent((String) data.get("content"));
        comment.setBlogUserId(Integer.valueOf((String) data.get("userId")));
        comment.setUser(userRepository.findByName(UserUtil.getUserName()));
        comment.setCreateTime(LocalDateTime.now());
        Comment save = commentRepository.save(comment);
        if(ObjectUtil.isNotEmpty(save)){
            ResponsePojo pojo = new ResponsePojo(ResponseStatus.SUCCESS, "评论成功!");
            return pojo;
        }
        return null;
    }
}
