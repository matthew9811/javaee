<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: chuling
  Date: 2019/9/16
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>实例4-4：我的第一个JSP程序</title>
</head>
<body>
<center style="font-family: 微软雅黑">现在时间是：<%Date date=new Date();%>
    <%=date%></br>
</center>
</body>
</html>
