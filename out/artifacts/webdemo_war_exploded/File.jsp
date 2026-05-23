<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2026/4/14
  Time: 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>⼩滴课堂⽂件上传样例</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/fileUpload" method="post" enctype="multipart/form-data">
    ⽤户名:<input type="text" name="username"/>
    头像:<input type="file" name="img">
    <input type="submit" value="提交">
</form>
</body>
</html>