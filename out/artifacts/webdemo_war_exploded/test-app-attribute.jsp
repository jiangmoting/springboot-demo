<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>应用属性测试</title>
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
      max-width: 1000px;
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
    .form-group {
      margin-bottom: 15px;
    }
    .form-group label {
      display: block;
      margin-bottom: 5px;
      color: #495057;
      font-weight: bold;
    }
    .form-group input {
      width: 100%;
      padding: 10px;
      border: 2px solid #ddd;
      border-radius: 5px;
      font-size: 14px;
    }
    .form-group input:focus {
      outline: none;
      border-color: #667eea;
    }
    .btn {
      padding: 12px 25px;
      margin: 5px;
      border: none;
      border-radius: 25px;
      cursor: pointer;
      font-size: 14px;
      transition: all 0.3s;
      color: white;
    }
    .btn-add {
      background: #28a745;
    }
    .btn-add:hover {
      background: #218838;
      transform: translateY(-2px);
    }
    .btn-update {
      background: #ffc107;
      color: #333;
    }
    .btn-update:hover {
      background: #e0a800;
      transform: translateY(-2px);
    }
    .btn-delete {
      background: #dc3545;
    }
    .btn-delete:hover {
      background: #c82333;
      transform: translateY(-2px);
    }
    .btn-back {
      background: #6c757d;
      text-decoration: none;
      display: inline-block;
    }
    .btn-back:hover {
      background: #5a6268;
      transform: translateY(-2px);
    }
    .attribute-list {
      background: #f8f9fa;
      padding: 15px;
      border-radius: 5px;
      margin-top: 15px;
    }
    .attribute-item {
      padding: 10px;
      margin-bottom: 8px;
      background: white;
      border-left: 4px solid #667eea;
      border-radius: 3px;
    }
    .info-box {
      background: #d1ecf1;
      border-left: 4px solid #17a2b8;
      padding: 15px;
      margin-bottom: 20px;
      border-radius: 5px;
    }
    .info-box strong {
      color: #0c5460;
    }
  </style>
</head>
<body>
<div class="container">
  <h1>🔧 应用属性测试（ServletContext）</h1>

  <div class="card">
    <h2>📋 说明</h2>
    <div class="info-box">
      <strong>监听器：</strong>AppAttributeMonitorListener<br>
      <strong>作用域：</strong>整个Web应用共享（所有用户可见）<br>
      <strong>生命周期：</strong>从应用启动到关闭<br>
      <strong>监控内容：</strong>属性的添加、修改、删除操作
    </div>
    <p style="color: #666;">
      💡 提示：操作后请查看<strong>控制台日志</strong>，监听器会输出详细信息。
    </p>
  </div>

  <div class="card">
    <h2>➕ 添加/修改属性</h2>
    <form method="post" action="test-app-attribute">
      <div class="form-group">
        <label for="attrName">属性名称：</label>
        <input type="text" id="attrName" name="attrName" placeholder="例如：myKey" required>
      </div>
      <div class="form-group">
        <label for="attrValue">属性值：</label>
        <input type="text" id="attrValue" name="attrValue" placeholder="例如：myValue" required>
      </div>
      <button type="submit" name="action" value="add" class="btn btn-add">➕ 添加属性</button>
      <button type="submit" name="action" value="update" class="btn btn-update">✏️ 修改属性</button>
      <button type="submit" name="action" value="delete" class="btn btn-delete">🗑️ 删除属性</button>
    </form>
  </div>

  <div class="card">
    <h2>📊 当前应用属性列表</h2>
    <div class="attribute-list">
      <%
        java.util.Enumeration<String> attrNames = application.getAttributeNames();
        boolean hasAttributes = false;
        while (attrNames.hasMoreElements()) {
          hasAttributes = true;
          String name = attrNames.nextElement();
          Object value = application.getAttribute(name);
      %>
      <div class="attribute-item">
        <strong><%= name %></strong> = <%= value %>
      </div>
      <%
        }
        if (!hasAttributes) {
      %>
      <p style="color: #999; text-align: center;">暂无属性</p>
      <%
        }
      %>
    </div>
  </div>

  <div class="card">
    <h2>🔗 快速导航</h2>
    <a href="monitor.jsp" class="btn btn-back">📊 系统监控</a>
    <a href="test-session-attribute.jsp" class="btn btn-back">👤 Session测试</a>
    <a href="index.jsp" class="btn btn-back">🏠 返回首页</a>
  </div>
</div>
</body>
</html>
