package com.shengxi.carblog.service.blog;

import com.shengxi.carblog.pojo.weak.ResponsePojo;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.PageRequest;

/**
 * 图片服务层
 * @author yan
 * @version 1.2.3
 * @date 2019-12-23 17:05:00
 */
public interface IPhotoService {
    /**
     * @param data
     * @return
     */
    ResponsePojo addPhoto(Map data) throws IOException;

    List<? extends Object> findDrawOfPagination(PageRequest pagination);
}
