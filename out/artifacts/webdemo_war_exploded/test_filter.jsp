<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2026/4/13
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>过滤器测试</title>
</head>
<body>
<h2>CustomFilter 测试结果</h2>
<hr/>

<h3>1. 编码测试</h3>
<p>中文显示：${testMessage}</p>
<p>当前请求编码：<%= request.getCharacterEncoding() %></p>
<p>当前响应内容类型：<%= response.getContentType() %></p>

<h3>2. 请求信息</h3>
<ul>
    <li>请求方法：<%= request.getMethod() %></li>
    <li>请求URI：<%= request.getRequestURI() %></li>
    <li>查询字符串：<%= request.getQueryString() %></li>
</ul>

<h3>3. 测试链接</h3>
<ul>
    <li><a href="<%= request.getContextPath() %>/dispatch">测试 DispatchServlet（FORWARD）</a></li>
    <li><a href="<%= request.getContextPath() %>/login.jsp">测试登录页面（REQUEST）</a></li>
</ul>

<hr/>
<p style="color: blue;">查看控制台输出，确认是否有 "CustomFilter doFilter" 日志</p>
</body>
</html>
