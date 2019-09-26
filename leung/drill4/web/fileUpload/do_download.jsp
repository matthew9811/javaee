<%@ page contentType="text/html,charset=utf-8" import="com.jspsmart.upload.*"%>
  <% 
   //新建一个SmartUpload对象
   SmartUpload su=new SmartUpload();
   //初始化
   su.initialize(pageContext);
   //设定contentDisposition为null以禁止浏览器自动打开文件,保证单击链接后是下载文件.
   //若不设定,则下载文件的扩展名是.doc时,浏览器将自动用word打开它.
   su.setContentDisposition(null);
   //下载文件，修改下面路径文件为本地有效文件！
   su.downloadFile("D:/uploadfiles/test.jpg");
  %>