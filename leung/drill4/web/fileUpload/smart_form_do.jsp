<%@ page import="com.jspsmart.upload.*"%>
 <title>用jspSmartUpload组件处理表单</title>
  <body>
    <h1 align="center">用jspSmartUpload组件处理表单</h1>
    <hr width="90%">
    <%
       //新建一个SmartUpload对象
       SmartUpload su= new SmartUpload();
       //上传初始化
       su.initialize(pageContext);
       //设定允许上传的文件(通过扩展名限制)，仅允许jpg,bmp,gif文件.
       su.setAllowedFilesList("jpg,bmp,gif");
       //上传文件
       su.upload();
       //将上传文件全部保存到指定目录
       su.save("D:/uploadfiles");
  %>
  <div align="center">
  <table CELLSPACING="0" CELLPADDING="3" BORDER="1" WIDTH="80%">
    <tr>
    <td>姓名:</td>
    <td><%=su.getRequest().getParameter("UserName")%>
    </td>
    </tr>
    <tr>
    <td>照片:</td>
    <td><img src="<%="D:/uploadfiles/"+su.getFiles().getFile(0).getFileName()%>"></td>
    </tr>
    <tr>
    <td>性别:</td>
    <td><%=su.getRequest().getParameter("Sex") %></td>
    </tr>
    <tr>
    <td>所在地:</td>
    <td><%=su.getRequest().getParameter("Province") %></td>
    </tr>
    </table>
    </div>
  </body>

