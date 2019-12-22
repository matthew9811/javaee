package com.shengxi.carblog.service.blog.impl;

import com.shengxi.carblog.pojo.weak.ResponsePojo;
import com.shengxi.carblog.service.blog.IPhotoService;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 相册服务层
 *
 * @author yan
 * @version 1.0.1
 * @date 2019-12-22 17:07:38
 * @see com.shengxi.carblog.service.blog.IPhotoService
 */
@Service()
public class PhotoServiceImpl implements IPhotoService {
    @Override
    public ResponsePojo addPhoto(Map data) {
        System.out.println(data);
        return null;
    }
}
