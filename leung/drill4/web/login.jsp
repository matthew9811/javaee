<%--
  Created by IntelliJ IDEA.
  User: chuling
  Date: 2019/9/18
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP JavaBean用户登录</title>
</head>
<body>
<center>
    <form action="login_do.jsp" method="post">
        <h2>
            login<br>
            name:<input type="text" name="name"><br>
            password:<input type="password"><br>
            <input type="submit" value="登录">
        </h2>
        <h3>尚未注册，请<a href="register.jsp"> 马上注册</a></h3>
    </form>
</center>
</body>
</html>
