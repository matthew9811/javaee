<%--
  Created by IntelliJ IDEA.
  User: chuling
  Date: 2019/9/23
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
import="com.shengxi.entity.User" %>
<html>
<head>
    <title>updateUser_do.jsp</title>
</head>
<body>
<%
    User user = (User)session.getAttribute("user");
    if(user != null) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        user.setName(name);
        user.setPassword(password);
        user.update();
        request.getRequestDispatcher("user.jsp").forward(request,response);
    }
%>
</body>
</html>
