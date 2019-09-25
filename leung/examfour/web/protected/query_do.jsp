<%--
  Created by IntelliJ IDEA.
  User: chuling
  Date: 2019/9/23
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="com.shengxi.leung.entity.User,java.util.List" %>
<html>
<head>
    <title>query_do.jsp</title>
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    if (user != null && user.getName().equals("admin")) {
        request.setCharacterEncoding("utf-8");
        String queryName = (String) request.getParameter("queryName");
        if (queryName == null) {
            queryName = "";
        }
        request.setAttribute("queryName", queryName);
        List all = user.listAllByName(queryName);
        request.setAttribute("all", all);
        request.getRequestDispatcher("listUsers.jsp").forward(request, response);
    } else {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
%>
</body>
</html>
