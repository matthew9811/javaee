<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/28
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme().concat("//".concat(request.getServerName().
            concat(":".concat(String.valueOf(request.getServerPort()).concat(path).concat("/")))));
%>
<html>
<head>
    <title>My JSP 'index.jsp' starting page</title>
    <meta>
</head>
<body>
<form action="login.action" method="post">
    name:
    <input type="text" name="user.un"><br>
    pwd <input type="text" name="user.pwd">
    <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
