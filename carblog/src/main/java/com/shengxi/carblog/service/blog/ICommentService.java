package com.shengxi.carblog.service.blog;

import com.shengxi.carblog.pojo.weak.ResponsePojo;
import java.util.Map;

/**
 * 评论服务层接口
 *
 * @author yan
 * @version 1.1.0
 * @date 2019-12-23 23:20:12
 */
public interface ICommentService {

    /**
     * 增加一条评论
     *
     * @param data Map<String, Obj>
     * @return status and msg
     */
    ResponsePojo addNewComment(Map data);
}
