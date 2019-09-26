<%--
  Created by IntelliJ IDEA.
  User: chuling
  Date: 2019/9/23
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册处理页面</title>
</head>
<body>
<h1>使用脚本段代码接收注册信息<br></h1>
<%
    request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="user" class="com.shengxi.entity.User"/>
<jsp:setProperty name="user" property="*"/>
<%
    boolean b = user.register();
    if (b) {
        session.setAttribute("user",user);
        request.getRequestDispatcher("registerSuccess.jsp").forward(request,response);
    }else {
        session.removeAttribute("user");
        request.getRequestDispatcher("registerFail.jsp").forward(request,response);
    }
%>
</body>
</html>
