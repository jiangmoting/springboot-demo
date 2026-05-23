<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2026/4/12
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
<div>
    name = ${loginuser.name}
    <br>
    host = ${loginuser.host}
    <br>
    id = ${loginuser.id}
    <br>
    <a href="/logout">退出登录</a>
</div>
</body>
</html>
