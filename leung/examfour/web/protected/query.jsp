<%--
  Created by IntelliJ IDEA.
  User: chuling
  Date: 2019/9/23
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="com.shengxi.leung.entity.User" %>
<html>
<head>
    <title>管理员用户查询query.jsp</title>
</head>
<body>
<center>
    <%
        User user = (User) session.getAttribute("user");
        if (user != null && user.getName().equals("admin")) {
    %>
    用户名模糊查询<br>
    <form action="query_do.jsp" method="post">
        <%
            String queryName = (String) request.getAttribute("queryName");
            if (queryName == null) {
                queryName = "";
            }
        %>
        用户名：<input type="text" name="queryName" value="<%=queryName%>">
        <input type="submit" value="查询">
    </form>
    <a href="listUsers_do.jsp">信息系统用户管理</a>
    <%
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    %>
</center>
</body>
</html>
