package com.shengxi.carblog.service.admin;

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


    List<UserBlogLog> findAllUser();
}
