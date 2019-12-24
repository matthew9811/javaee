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
     * 获取所以用户管理需要的信息
     *
     * @return list
     */
    List<UserBlogLog> findAllUser();

    /**
     * @param id
     * @return 禁用用户
     */
    boolean editUser(Integer id);

    /**
     * 修改文章状态
     *
     * @param blogId         blog id :String
     * @param blogPassStatus 要修改的状态
     * @return status and msg
     */
    ResponsePojo updateStatus(String blogId, String blogPassStatus);
}
