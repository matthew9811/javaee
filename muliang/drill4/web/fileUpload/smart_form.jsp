<title>处理表单</title>
   <body>
     <h1 align="center">用jspSmartUpload组件处理表单</h1>
     <hr width="90%">
     <div align="center">
     <form method="post" action="smart_form_do.jsp" name="form1" ENCTYPE="multipart/form-data">
     <table border="1" width="80%">
     <tr>
     <td height="25">姓名:</td>
     <td height="25" align="left"><input type="text" size="19" name="UserName"></td>
     </tr>
     <tr>
     <td height="25">照片:</td>
     <td height="25" align="left"><input type="file" name="Pic"></td>
     </tr>
     <tr>
     <td height="25">性别:</td>
     <td height="25" align="left"><input type="radio" name="Sex" value="男">男&nbsp;
     <input type="radio" name="Sex" value="女">女</td>
     </tr>
     <tr>
     <td height="25">所在地:</td>
     <td height="25" align="left"><input type="text" name="Province"></td>
     </tr>
     <tr>
     <td height="40" colspan="2" align="center"><input type="Submit" value="提交"></td>
     </tr>
     </table>
     </form>
     </div>
   </body>     
