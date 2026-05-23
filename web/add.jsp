<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2026/4/13
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><html>
<head>
    <title>⼩滴课堂javaweb统计在线⼈数</title>
</head>
<body>
<hr>
近30分钟在线⼈数: ${applicationScope.onlineNum}
<hr>
应⽤服务器启动后总访问次数：${totalVisit}
</body>
</html>