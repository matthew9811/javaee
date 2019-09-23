<%--
  Created by IntelliJ IDEA.
  User: chuling
  Date: 2019/9/23
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
import="com.shengxi.entity.User" %>
<html>
<head>
    <title>registerSuccess.jsp</title>
</head>
<body>
<%
    User user = (User)session.getAttribute("user");
    if (user != null){
%>
<center>
    <h1>
        欢迎你，<%=user.getName()%>，注册成功！<br>
        <a href="user.jsp">进入普通用户内容页面</a>
    </h1>
    <%}else{
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
    %>
</center>
</body>
</html>
