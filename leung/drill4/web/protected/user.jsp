<%--
  Created by IntelliJ IDEA.
  User: chuling
  Date: 2019/9/23
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
import="com.shengxi.entity.User" %>
<html>
<head>
    <title>user.jsp</title>
</head>
<body>
<center>
    <%
        User user = (User)session.getAttribute("user");
        if (user != null){
    %>
    欢迎你<%=user.getName()%>，登录成功<br>
    登录后显示的内容：<br>
    网站新闻1<br>
    网站新闻2<br>
    <a href="getUser_do.jsp?id=<%=user.getId()%>">
        个人信息修改
    </a>
    <%
        }else {
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    %>
</center>
</body>
</html>
