<%@ page import="net.xdclass.web.controller.RequestServlet" %>
<%@ page import="net.xdclass.web.domain.Config" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>系统监控面板</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            font-family: 'Microsoft YaHei', Arial, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 20px;
        }
        .container {
            max-width: 900px;
            margin: 0 auto;
        }
        h1 {
            color: white;
            text-align: center;
            margin-bottom: 30px;
            text-shadow: 2px 2px 4px rgba(0,0,0,0.3);
        }
        .card {
            background: white;
            border-radius: 10px;
            padding: 25px;
            margin-bottom: 20px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.2);
        }
        .card h2 {
            color: #667eea;
            margin-bottom: 20px;
            border-bottom: 2px solid #667eea;
            padding-bottom: 10px;
        }
        .stat-row {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 15px;
            margin-bottom: 10px;
            background: #f8f9fa;
            border-radius: 5px;
            transition: all 0.3s;
        }
        .stat-row:hover {
            background: #e9ecef;
            transform: translateX(5px);
        }
        .stat-label {
            font-weight: bold;
            color: #495057;
            font-size: 16px;
        }
        .stat-value {
            color: #667eea;
            font-size: 20px;
            font-weight: bold;
        }
        .online-badge {
            background: #28a745;
            color: white;
            padding: 5px 15px;
            border-radius: 20px;
            font-size: 18px;
        }
        .btn-group {
            text-align: center;
            margin-top: 20px;
        }
        .btn {
            display: inline-block;
            padding: 12px 30px;
            margin: 5px;
            background: #667eea;
            color: white;
            text-decoration: none;
            border-radius: 25px;
            transition: all 0.3s;
        }
        .btn:hover {
            background: #764ba2;
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(0,0,0,0.2);
        }
    </style>
</head>
<body>
<div class="container">
    <h1>🎯 系统监控面板</h1>

    <div class="card">
        <h2>📊 实时统计</h2>
        <div class="stat-row">
            <span class="stat-label">当前在线人数:</span>
            <span class="stat-value online-badge">
                <%= application.getAttribute("onlineNum") != null ? application.getAttribute("onlineNum") : 0 %>
            </span>
        </div>
        <div class="stat-row">
            <span class="stat-label">访问总次数:</span>
            <span class="stat-value online-badge">
                <%= application. getAttribute("totalVisit") != null ? application.getAttribute("totalVisit") : 0 %>
            </span>
        </div>
    </div>

    <div class="card">
        <h2>⚙️ 应用配置</h2>
        <%
            Config appConfig = (Config) application.getAttribute("config");
            if (appConfig != null) {
        %>
        <div class="stat-row">
            <span class="stat-label">应用URL:</span>
            <span class="stat-value"><%= appConfig.getUrl() %></span>
        </div>
        <div class="stat-row">
            <span class="stat-label">应用主题:</span>
            <span class="stat-value"><%= appConfig.getTopic() %></span>
        </div>
        <%
        } else {
        %>
        <div class="stat-row">
            <span class="stat-label">配置信息:</span>
            <span class="stat-value" style="color: red;">未初始化</span>
        </div>
        <%
            }
        %>
    </div>

    <div class="card">
        <h2>🔗 快速导航</h2>
        <div class="btn-group">
            <a href="index.jsp" class="btn">🏠 返回首页</a>
            <a href="login.jsp" class="btn">🔐 用户登录</a>
            <a href="user/user.jsp" class="btn">👤 用户中心</a>
        </div>
    </div>
</div>
</body>
</html>
