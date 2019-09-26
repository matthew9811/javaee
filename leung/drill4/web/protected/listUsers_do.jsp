<%--
  Created by IntelliJ IDEA.
  User: chuling
  Date: 2019/9/23
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
import="com.shengxi.entity.User,java.util.List" %>
<html>
<head>
    <title>listUsers_do.jsp</title>
</head>
<body>
<%
    User user = (User)session.getAttribute("user");
    if (user != null && user.getName().equals("admin")) {
        List all = user.listAll();
        request.setAttribute("all",all);
        request.getRequestDispatcher("listUsers.jsp").forward(request,response);
    }
%>
</body>
</html>
