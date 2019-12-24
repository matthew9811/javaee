package com.shengxi.carblog.service.blog.impl;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.ObjectUtil;
import com.shengxi.carblog.pojo.Draw;
import com.shengxi.carblog.pojo.User;
import com.shengxi.carblog.pojo.weak.ResponsePojo;
import com.shengxi.carblog.repository.IDrawRepository;
import com.shengxi.carblog.repository.IUserRepository;
import com.shengxi.carblog.service.blog.IPhotoService;
import com.shengxi.compent.constant.StatusConstant;
import com.shengxi.compent.constant.UploadConstant;
import com.shengxi.compent.utils.FileUtils;
import com.shengxi.compent.utils.ResponseStatus;
import com.shengxi.compent.utils.UserUtil;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 相册服务层
 *
 * @author yan
 * @version 1.0.1
 * @date 2019-12-22 17:07:38
 * @see com.shengxi.carblog.service.blog.IPhotoService
 */
@Service("photoService")
public class PhotoServiceImpl implements IPhotoService {

    /**
     * 后缀
     */
    private final String SUFFIX = ".json";


    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IDrawRepository drawRepository;
    @Override
    public ResponsePojo addPhoto(Map data) throws IOException {
        Draw draw = new Draw();
        ArrayList<String> photoArr = (ArrayList) data.get("photoArr");
        User byName = userRepository.findByName(UserUtil.getUserName());
        String fileName = UUID.randomUUID(true).toString().replace("-", "").concat(SUFFIX);
        /* 初始化审核人为自己 */
        draw.setReviewer(byName.getId());
        draw.setStatus(StatusConstant.BLOG_CONFIG_STATUS);
        draw.setRecommend(StatusConstant.BLOG_CONFIG_STATUS);
        draw.setUploadTime(LocalDateTime.now());
        draw.setTitle((String) data.get("title"));
        draw.setContentUrl(UploadConstant.SQL_PATH_PREFIX + FileUtils.saveFile(fileName, data).concat("/") + fileName);
        draw.setUser(byName);
        Draw save = drawRepository.save(draw);
        if (ObjectUtil.isNotEmpty(save)){
            ResponsePojo pojo = new ResponsePojo(ResponseStatus.SUCCESS, "发表成功!");
            pojo.put("id", save.getId());
            return pojo;
        }
        return null;
    }
}
