package com.shengxi.carblog.service.blog;

import com.shengxi.carblog.pojo.weak.ResponsePojo;
import java.util.Map;

public interface IPhotoService {
    /**
     * @param data
     * @return
     */
    ResponsePojo addPhoto(Map data);
}
