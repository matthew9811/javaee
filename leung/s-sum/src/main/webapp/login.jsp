<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/28
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>实例5-3：实现在jsp页面中的中英文切换</title>
</head>
<body>
<h1><s:text name="welcome"/></h1>
<s:i18n name="messageResource">
    <s:form action="login" method="POST">
        <s:textfield name="user.ucnName" key="username" size="20"></s:textfield>
        <s:password name="user.upsw" key="password" size="21"></s:password>
        <s:submit value="%{getText('login')}"/>
    </s:form>
</s:i18n>
</body>
</html>
