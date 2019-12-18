package com.shengxi.carblog.service.blog;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 博客模块服务层
 *
 * @author yan
 * @version 1.0.0
 * <p>
 * @date 2019-12-17 20:41:59
 */
public interface IBlogService {

    ResponseBody addBlog(Map data, HttpServletRequest request) throws IOException;
}
