package com.shengxi;

import com.jspsmart.upload.SmartUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @Author: matthew
 * @ClassName ${NAME}
 * @Date: 2019-10-07 0:32
 * @Version: 1.0.0
 * @description:
 */
@WebServlet(name = "UpLoadServlet", urlPatterns = "/upload")
public class UpLoadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //指定动作
//        SmartUpload smart = new SmartUpload();
//        smart.initialize(pageContext);
//        smart.upload();
//        //把文件保存到同目录的pic文件夹
//        smart.save("pic");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
