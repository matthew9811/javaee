package com.shengxi.carblog.service.blog;

import com.shengxi.carblog.pojo.weak.ResponsePojo;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public interface IPhotoService {
    /**
     * 插入图片
     *
     * @param data data
     * @return status
     * @throws IOException io流异常
     */
    ResponsePojo addPhoto(Map data) throws IOException;

    /**
     * 获取对应的相册详情
     *
     * @param id id
     * @return map is has detail photo
     */
    HashMap<String, Object> findPhotoDetail(Integer id);

    /**
     * 获取最新的图片信息
     * @return map is has photo list :Obj
     */
    Map<String, Object> findPhotoList();
}
