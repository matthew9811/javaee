package com.shengxi.carblog.service.blog.impl;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.ObjectUtil;
import com.shengxi.carblog.pojo.Draw;
import com.shengxi.carblog.pojo.User;
import com.shengxi.carblog.pojo.weak.ResponsePojo;
import com.shengxi.carblog.pojo.weak.bigTable.DrawWeak;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public ResponsePojo addPhoto(Map data) throws IOException {
        Draw draw = new Draw();
        StringBuffer text = new StringBuffer();
        ArrayList<String> photoArr = (ArrayList) data.get("photoArr");
        User byName = userRepository.findByName(UserUtil.getUserName());
        String fileName = UUID.randomUUID(true).toString().replace("-", "").concat(SUFFIX);
        /* 初始化审核人为自己 */
        draw.setReviewer(byName.getId());
        draw.setStatus(StatusConstant.BLOG_CONFIG_STATUS);
        draw.setRecommend(StatusConstant.RECOMMEND_CONFIG_STATUS);
        draw.setUploadTime(LocalDateTime.now());
        draw.setTitle((String) data.get("title"));
        photoArr.forEach(v -> text.append(v));
        draw.setContentUrl(UploadConstant.SQL_PATH_PREFIX + FileUtils.saveFile(fileName, text.toString()).concat("/") + fileName);
        draw.setUser(byName);
        Draw save = drawRepository.save(draw);
        if (ObjectUtil.isNotEmpty(save)) {
            ResponsePojo pojo = new ResponsePojo(ResponseStatus.SUCCESS, "发表成功!");
            pojo.put("id", save.getId());
            return pojo;
        }
        return null;
    }

    @Override
    public HashMap<String, Object> findPhotoDetail(Integer id) {
        HashMap<String, Object> result = new HashMap<>(1);
        Optional<Draw> byId = drawRepository.findById(id);
        if (byId.isPresent()) {
            Draw draw = byId.get();
            StringBuffer stringBuffer = FileUtils.readHtml(draw.getContentUrl());
            //截取图片
            String[] split = stringBuffer.toString().split("data");
            for (int i = 1, splitLength = split.length; i < splitLength; i++) {
                //弥补截取后的数据
                String str = split[i];
                split[i] = "data".concat(str);
            }
            String[] con = new String[split.length - 1];
            for (int i = 1; i < split.length; i++) {
                con[i - 1] = split[i];
            }
            split = null;
            draw.setSplit(con);
            result.put("draw", draw);
            return result;
        }
        return null;
    }

    @Override
    public Map<String, Object> findPhotoList() {
        HashMap<String, Object> result = new HashMap<>(1);
        List<DrawWeak> weakList = new ArrayList<>();
        List<Draw> drawList = drawRepository.findAll(Sort.by(Sort.Direction.DESC, "uploadTime"));
        if (drawList != null) {
            for (int i = 0, drawListSize = drawList.size(); i < drawListSize; i++) {
                Draw draw = drawList.get(i);
                StringBuffer stringBuffer = FileUtils.readHtml(draw.getContentUrl());
                String[] split = stringBuffer.toString().split("data");
                //弥补截取后的数据
                String con =  "data".concat(split[1]);
                weakList.add(new DrawWeak(draw.getId(), con, draw.getTitle()));
                if (weakList.size() > 8) {
                    break;
                }
            }
            result.put("weakList", weakList);
            return result;
        }
        return null;
    }
}
