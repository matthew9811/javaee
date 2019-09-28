<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/28
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>实例5-3：实现在jsp页面中的中英文切换</title>
</head>
<body>
<h2>
    <s:property value="%{getText('username')}"/>
    <br>
    <s:textfield name="name"></s:textfield>
    <br>
    <s:property value="%{getText('password')}"></s:property>
    <br>
    <s:textfield name="password"></s:textfield>
</h2>

</body>
</html>
