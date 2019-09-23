<%--
  Created by IntelliJ IDEA.
  User: chuling
  Date: 2019/9/23
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
import="com.shengxi.entity.User" %>
<html>
<head>
    <title>admin.jsp</title>
</head>
<body>
<center>
    <%
        User user = (User)session.getAttribute("user");
        if(user != null && user.getName().equals("admin")){
    %>
    欢迎你<%=user.getName()%>,登录成功！<br>
    登录后显示的内容：<br>
    用户列表<br>
    <a href="listUsers_do.jsp">信息系统用户管理</a>
    <%
        }else {
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    %>
</center>
</body>
</html>
