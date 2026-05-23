<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2026/4/10
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
  <title>用户登录</title>
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
      font-weight: bold;
    }

    .form-group {
      margin-bottom: 20px;
    }

    .form-group label {
      display: block;
      margin-bottom: 8px;
      color: #555;
      font-size: 14px;
      font-weight: 500;
    }

    .form-group input {
      width: 100%;
      padding: 12px 15px;
      border: 2px solid #e1e1e1;
      border-radius: 5px;
      font-size: 14px;
      transition: border-color 0.3s ease;
    }

    .form-group input:focus {
      outline: none;
      border-color: #667eea;
    }

    .form-group input[type="submit"] {
      background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
      color: white;
      border: none;
      cursor: pointer;
      font-size: 16px;
      font-weight: bold;
      padding: 12px;
      margin-top: 10px;
      transition: transform 0.2s ease, box-shadow 0.2s ease;
    }

    .form-group input[type="submit"]:hover {
      transform: translateY(-2px);
      box-shadow: 0 5px 15px rgba(102, 126, 234, 0.4);
    }

    .form-group input[type="submit"]:active {
      transform: translateY(0);
    }
  </style>
</head>
<body>
<div class="login-container">
  <h1 class="login-title">用户登录</h1>
  <form action="userServlet/login" method="post">
    <div class="form-group">
      <label for="username">用户名:</label>
      <input type="text" id="username" name="username" placeholder="请输入用户名" required>
    </div>
    <div class="form-group">
      <label for="password">密码:</label>
      <input type="password" id="password" name="password" placeholder="请输入密码" required>
    </div>
    <div class="form-group">
      <input type="submit" value="登 录">
    </div>
  </form>

  <hr>
  name=${user.name}
  <hr>
  id=${user.id}
  <hr>
  host=${user.host}
</div>
</body>
</html>

