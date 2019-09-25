<%--
  Created by IntelliJ IDEA.
  User: chuling
  Date: 2019/9/23
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
import="com.shengxi.leung.entity.User" %>
<html>
<head>
    <title>deleteUser_do.jsp</title>
</head>
<body>
<%
    User user = (User)session.getAttribute("user");
    if (user != null && user.getName().equals("admin")) {
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        user.delete(id);
        request.getRequestDispatcher("listUser_do.jsp").forward(request,response);
    }
%>
</body>
</html>
