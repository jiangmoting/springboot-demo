//package net.xdclass.web.controller;
//
//import net.xdclass.web.domain.User;
//import net.xdclass.web.util.CookieUtil;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
///**
// * 登录处理 Servlet
// *
// * 知识点：
// * 1. 接收表单提交的 POST 请求
// * 2. 验证用户名密码
// * 3. 登录成功后将用户信息存入 Session
// * 4. 如果勾选"记住我"，则创建 Cookie
// *
// * Session vs Cookie：
// * - Session：存储在服务器端，安全，适合存敏感信息
// * - Cookie：存储在浏览器端，适合存非敏感的持久化数据
// */
////@WebServlet("/login")
//public class LoginServlet extends HttpServlet {
//
//    // 模拟数据库中的用户数据（实际应该查数据库）
//    private static final String VALID_USERNAME = "admin";
//    private static final String VALID_PASSWORD = "123456";
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        // GET 请求直接显示登录页
//        req.getRequestDispatcher("/login.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//
//        // 1. 获取表单参数
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        // "on" 表示勾选
//        String rememberMe = req.getParameter("rememberMe");
//
//        System.out.println("📥 接收到参数：");
//        System.out.println("   用户名: " + username);
//        System.out.println("   密  码: " + password);
//        System.out.println("   记住我: " + rememberMe);
//
//        // 2. 参数验证
//        if (username == null || username.trim().isEmpty() ||
//                password == null || password.trim().isEmpty()) {
//
//            System.out.println("❌ 验证失败：参数为空");
//            req.setAttribute("msg", "⚠️ 用户名和密码不能为空");
//            req.getRequestDispatcher("/login.jsp").forward(req, resp);
//            return;
//        }
//
//        // 3. 验证账号密码（实际应该查询数据库）
//        if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
//
//            System.out.println("✅ 登录成功！");
//
//            // 4. 创建用户对象
//            //User user = new User(1, username, username + "@example.com");
//
//            // 5. 将用户信息存入 Session（会话级别）
//            HttpSession session = req.getSession();
//            session.setAttribute("loginUser", user);
//
//            // 设置 Session 超时时间（30分钟）
//            session.setMaxInactiveInterval(30 * 60);
//
//            System.out.println("📦 用户信息已存入 Session");
//            System.out.println("   Session ID: " + session.getId());
//
//            // 6. 如果勾选了"记住我"，创建 Cookie
//            if ("on".equals(rememberMe)) {
//                System.out.println("💾 创建记住我的 Cookie");
//
//                // 保存用户名到 Cookie，有效期 7 天
//                CookieUtil.addCookie(resp, "rememberUsername", username, 7 * 24 * 60 * 60);
//
//                // 保存登录标记，有效期 7 天
//                CookieUtil.addCookie(resp, "autoLogin", "true", 7 * 24 * 60 * 60);
//
//            } else {
//                // 没勾选，删除之前的 Cookie
//                CookieUtil.deleteCookie(resp, "rememberUsername");
//                CookieUtil.deleteCookie(resp, "autoLogin");
//            }
//
//            // 7. 检查是否有原本想访问的 URL
//            String redirectUrl = (String) session.getAttribute("redirectUrl");
//            if (redirectUrl != null) {
//                session.removeAttribute("redirectUrl");
//                System.out.println("🔀 重定向到原页面: " + redirectUrl);
//                resp.sendRedirect(redirectUrl);
//            } else {
//                // 默认跳转到首页
//                System.out.println("🔀 重定向到首页");
//                resp.sendRedirect(req.getContextPath() + "/user/index.jsp");
//            }
//
//        } else {
//            // 8. 登录失败
//            System.out.println("❌ 登录失败：账号或密码错误");
//
//            req.setAttribute("msg", "❌ 账号或密码错误，请重试");
//            req.setAttribute("username", username);  // 回显用户名
//
//            req.getRequestDispatcher("/login.jsp").forward(req, resp);
//        }
//
//    }
//}
