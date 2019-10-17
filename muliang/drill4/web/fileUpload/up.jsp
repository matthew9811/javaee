<%--
  Created by IntelliJ IDEA.
  User: chuling
  Date: 2019/10/8
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*,com.jspsmart.upload.*, java.io.File"
         pageEncoding="utf-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>上传处理页面</title>
</head>

<body>
<%
    //    String path = "/pic/";
    //之所以要放到异常抛出结构里面，是为了避免直接访问此页报错
    try {
        //指定动作
        SmartUpload smart = new SmartUpload();
        smart.initialize(pageContext);
        smart.upload();
        String uploadPath = "F:\\Class\\javaee\\muliang\\drill4\\web\\pic";
        //把文件保存到同目录的pic文件夹
//        File file = new File(application.getRealPath("/") + path);
        File file = new File(uploadPath);
        if (!file.exists()){
            file.mkdirs();
        }
        smart.save(uploadPath);
        out.print("上传成功");
    } catch (Exception e) {
        out.print(e.toString());
        e.printStackTrace();
    }
%>
<a href="doUpload.jsp">返回</a>
</body>
</html>
