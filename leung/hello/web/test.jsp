<%--
  Created by IntelliJ IDEA.
  User: matthew
  Date: 2019/9/11
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>The first application</title>
  </head>
  <body>
  以下内容是包含的动态文件hello.jsp的内容：
  <br>
  <% request.setCharacterEncoding("UTF-8");%>
  <jsp:include page="hello.jsp">
    <jsp:param name="name" value="Java EE环境设计"/>
  </jsp:include>
  </body>
</html>
