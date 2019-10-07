package com.shengxi;

import com.jspsmart.upload.SmartUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: matthew
 * @ClassName ${NAME}
 * @Date: 2019-10-07 0:46
 * @Version: 1.0.0
 * @description:
 */
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");
        // 下载路径使用绝对路径
        String downloadPath = "D:\\shengxi\\javaee\\leung\\drill4\\web\\pic\\";
        SmartUpload smart = new SmartUpload();
        //2、初始化创建的SmartUpload对象
        smart.initialize(getServletConfig(), request, response);
        //使用默认的浏览器下载器
        smart.setContentDisposition(null);
        try {
            // 下载文件
            smart.downloadFile(downloadPath + filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
