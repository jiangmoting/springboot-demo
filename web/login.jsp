<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="net.xdclass.web.util.CookieUtil" %>
<%
    // 从 Cookie 中读取用户名（如果之前勾选了"记住我"）
    String rememberedUsername = CookieUtil.getCookie(request, "rememberUsername");
    if (rememberedUsername == null) {
        rememberedUsername = "";
    }

    // 获取错误消息
    String msg = (String) request.getAttribute("msg");
    if (msg == null) {
        msg = "";
    }

    // 回显用户名
    String username = (String) request.getAttribute("username");
    if (username == null) {
        username = rememberedUsername;
    }
%>
<html>
<head>
    <title>用户登录</title>
    <link rel="icon" href="data:;base64,=">
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body {
            font-family: 'Microsoft YaHei', Arial, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .login-container {
            background: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 400px;
        }
        .login-title {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
            font-size: 28px;
        }
        .form-group { margin-bottom: 20px; }
        .form-group label {
            display: block;
            margin-bottom: 8px;
            color: #555;
            font-weight: 500;
        }
        .form-group input[type="text"],
        .form-group input[type="password"] {
            width: 100%;
            padding: 12px;
            border: 2px solid #e1e1e1;
            border-radius: 5px;
            font-size: 14px;
        }
        .form-group input:focus {
            outline: none;
            border-color: #667eea;
        }
        .remember-me {
            margin: 15px 0;
            display: flex;
            align-items: center;
        }
        .remember-me input { margin-right: 8px; }
        .submit-btn {
            width: 100%;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            border: none;
            padding: 12px;
            border-radius: 5px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
        }
        .submit-btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(102, 126, 234, 0.4);
        }
        .message {
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 5px;
            text-align: center;
            background: #fee;
            color: #c33;
        }
        .hint {
            margin-top: 20px;
            padding: 10px;
            background: #f0f0f0;
            border-radius: 5px;
            font-size: 12px;
            color: #666;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h1 class="login-title">🔐 用户登录</h1>

    <%-- 显示错误消息 --%>
    <% if (!msg.isEmpty()) { %>
    <div class="message"><%= msg %></div>
    <% } %>

    <form action="<%= request.getContextPath() %>/login" method="post">
        <div class="form-group">
            <label for="username">用户名:</label>
            <input type="text" id="username" name="username"
                   value="<%= username %>"
                   placeholder="请输入用户名" required>
        </div>

        <div class="form-group">
            <label for="password">密码:</label>
            <input type="password" id="password" name="password"
                   placeholder="请输入密码" required>
        </div>

        <div class="remember-me">
            <input type="checkbox" id="rememberMe" name="rememberMe"
                <%= !rememberedUsername.isEmpty() ? "checked" : "" %>>
            <label for="rememberMe">记住我（7天内自动登录）</label>
        </div>

        <div class="form-group">
            <input type="submit" value="登 录" class="submit-btn">
        </div>
    </form>

    <div class="hint">
        <strong>💡 测试账号：</strong><br/>
        用户名：admin<br/>
        密  码：123456
    </div>
</div>
</body>
</html>
