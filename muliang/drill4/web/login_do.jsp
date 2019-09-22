<%--
  Created by IntelliJ IDEA.
  User: chuling
  Date: 2019/9/18
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录处理页面</title>
</head>
<jsp:useBean id="user" class="com.shengxi.entity.User"/>
<jsp:setProperty name="user" property="*"/>
<%
    user = user.login();
    if (user != null) {
        session.setAttribute("user", user);
        if (user.getName().equals("admin")) {
%>
<jsp:forward page="admin.jsp"/>
<%
} else {
%>
<jsp:forward page="user.jsp"/>
<%
    }
} else {
%>
<jsp:forward page="login.jsp"/>
<%
    }
%>
<body>

</body>
</html>
