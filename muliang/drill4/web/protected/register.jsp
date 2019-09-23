<%--
  Created by IntelliJ IDEA.
  User: chuling
  Date: 2019/9/23
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册JSP</title>
</head>
<body>
<center>
    <form action="register_do.jsp" method="post">
        用户注册<br>
        用户名：<input type="text" name="name"><br>
        密码：<input type="password" name="password"><br>
        年龄：<input type="text" name="age"><br>
        <input type="submit" value="注册">
        <input type="reset" value="重写">
    </form>
</center>
</body>
</html>
