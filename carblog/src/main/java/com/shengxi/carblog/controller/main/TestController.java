package com.shengxi.carblog.controller.main;

import com.shengxi.carblog.pojo.User;
import com.shengxi.carblog.service.admin.IUserService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yan
 */
@RestController
public class TestController {

    @Autowired
    private IUserService userService;

    @GetMapping("/findAll")
    public void findAll() {
//        List<User> users = userService.listAll();
//        users.forEach(k-> System.out.println(k.toString()));
    }


    /**
     * 接收上传的文件，并且将上传的文件存储在指定路径下
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/upload")
    public String upload(HttpServletRequest request) {

        ServletInputStream sis = null;
        FileOutputStream fos = null;
        try {
            // 文件名
            String filename = request.getHeader("fileName");
            // 文件类型，例如：jpg、png、pdf...
            String fileType = request.getHeader("fileType");
            // 存储路径
            String filePath = request.getHeader("filePath");

            File file = new File(filePath + filename + "." + fileType);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }

            sis = request.getInputStream();
            fos = new FileOutputStream(file);
            byte[] content = new byte[1024];
            int len = 0;
            while ((len = sis.read(content)) > -1) {
                fos.write(content, 0, len);
            }
            fos.flush();

            return "success";
        } catch (Exception ex) {
            ex.printStackTrace();

            return "fail";
        } finally {
            try {
                if (sis != null) {
                    sis.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
