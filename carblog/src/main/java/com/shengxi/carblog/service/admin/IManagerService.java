package com.shengxi.carblog.service.admin;

import com.shengxi.carblog.pojo.weak.ResponsePojo;
import com.shengxi.carblog.pojo.weak.bigTable.UserBlogLog;
import java.util.List;
import java.util.Map;

/**
 * manager模块服务层接口
 *
 * @author yan
 * @version 1.0.0
 * @date 2019-12-10 15:19:37
 */
public interface IManagerService {


    /**
     * 获取对应的主页信息
     *
     * @return pojo
     */
    Map<String, Object> initManagerPageData();


    /**
     * 获取所有用户管理需要的信息
     *
     * @return list
     */
    List<UserBlogLog> findAllUser();

    /**
     * 获取管理员信息
     *
     * @return list
     */
    List<UserBlogLog> findAdmin();

    /**
     * 修改文章状态
     *
     * @param blogId         blog id :String
     * @param blogPassStatus 要修改的状态
     * @return status and msg
     */
    ResponsePojo updateStatus(String blogId, String blogPassStatus);

    /**
     * 修改文章状态(推荐状态）
     *
     * @param blogId         blog id :String
     * @param recommendStatus 要修改的状态
     * @return status and msg
     */
    ResponsePojo updateRecommend(String blogId, String recommendStatus);

    /**
     * 修改用户状态(禁用状态）
     *
     * @param id         blog id :String
     * @param status 要修改的状态
     * @return status and msg
     */
    ResponsePojo userStatus(Integer id, String status);
}
