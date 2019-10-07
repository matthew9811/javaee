<!-- 注意页首两个包是怎么引用的 -->
<%@ page language="java" import="java.util.*,com.jspsmart.upload.*, java.io.File"
         pageEncoding="utf-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>上传处理页面</title>
</head>

<body>
<%
    String path = "/pic/";
    //之所以要放到异常抛出结构里面，是为了避免直接访问此页报错
    try {
        //指定动作
        SmartUpload smart = new SmartUpload();
        smart.initialize(pageContext);
        smart.upload();
        //把文件保存到同目录的pic文件夹
        File file = new File(application.getRealPath("/") + path);
        if (!file.exists()){
            file.mkdirs();
        }
        smart.save(application.getRealPath("/") + path);
        out.print("上传成功");
    } catch (Exception e) {
        out.print(e.toString());
        e.printStackTrace();
    }
%>
<a href="fileUpload/doUpload.jsp">返回</a>
</body>
</html>