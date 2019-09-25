<%--
  Created by IntelliJ IDEA.
  User: chuling
  Date: 2019/9/23
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
import="com.shengxi.leung.entity.User" %>
<html>
<head>
    <title>getUser_do</title>
</head>
<body>
<%
    User user = (User)session.getAttribute("user");
    if(user != null) {
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        user = user.get(id);
        request.getRequestDispatcher("updateUserInfo.jsp").forward(request,response);
    }
%>
</body>
</html>
