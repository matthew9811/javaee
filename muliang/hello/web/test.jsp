<%--
  Created by IntelliJ IDEA.
  User: chuling
  Date: 2019/9/16
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>第一个程序</title>
</head>
<body>
以下内容是包含的动态文件hello.jsp的内容：
<hr>
<% request.setCharacterEncoding("UTF-8");%>
<jsp:include page="hello.jsp">
    <jsp:param name="name" value="Java EE环境测试！"/>
</jsp:include>
</body>
</html>
