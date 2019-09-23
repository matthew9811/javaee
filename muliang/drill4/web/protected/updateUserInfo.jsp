<%--
  Created by IntelliJ IDEA.
  User: chuling
  Date: 2019/9/23
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
import="com.shengxi.entity.User" %>
<html>
<head>
    <title>updateUserInfo.jsp</title>
</head>
<%
    User user = (User)session.getAttribute("user");
%>
<body>
<form action="updateUser_do.jsp" method="post">
    <table align="center" border="1">
        <tr>
            <td colspan="2" align="center">个人信息修改</td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td>
                <input type="text" name="name" value="<%=user.getName()%>">
            </td>
        </tr>
        <tr>
            <td>密码</td>
            <td>
                <input type="text" name="password" value="<%=user.getPassword()%>">
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="修改">
                <a href="user.jsp">取消</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
