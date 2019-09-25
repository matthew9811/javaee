<%--
  Created by IntelliJ IDEA.
  User: chuling
  Date: 2019/9/23
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="com.shengxi.leung.entity.User,java.util.List" %>
<html>
<head>
    <title>listUsers.jsp</title>
</head>
<body>
<center>
    <%
        User user = (User) session.getAttribute("user");
        if (user != null && user.getName().equals("admin")) {
    %>
    管理员用户管理<br>
    管理员姓名：<%=user.getName()%><br>
    <table align="center" border="1">
        <tr>
            <td colspan="3" align="center">用户列表</td>
        </tr>
        <tr>
            <td width="40px">id</td>
            <td width="160px">姓名</td>
            <td width="40px">操作</td>
        </tr>
        <%
            List all = (List) request.getAttribute("all");
            if (all.size() > 0) {
                for (int i = 0; i < all.size(); i++) {
                    User u = (User) all.get(i);
        %>
        <tr>
            <td><%=u.getId()%>
            </td>
            <td><%=u.getName()%>
            </td>
            <td>
                <a href="deleteUser_do.jsp?id=<%=u.getId()%>">删除</a>
            </td>
        </tr>
        <%
            }
        %>
        <%
        } else {
        %>
        <tr>
            <td colspan="3">没有任何记录</td>
        </tr>
        <%
                }
            }
        %>
    </table>
    <br>
    <a href="admin.jsp">返回到登录成功页面</a>
    <br><br>
    <jsp:include page="query.jsp"/>
</center>
</body>
</html>
