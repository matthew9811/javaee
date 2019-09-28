
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="java.util.*" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName()
            + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>实例5-1 : strut2应用 </title>
</head>
<body>
<form action="test.action" method="post">
    name: <input type="text" name="name">
    <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
