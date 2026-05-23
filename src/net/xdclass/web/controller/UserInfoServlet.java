//package net.xdclass.web.controller;
//
//import net.xdclass.web.domain.User;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.io.PrintWriter;
//
///**
// * 用户信息 Servlet
// *
// * 知识点：
// * 1. 从 Session 中获取用户信息
// * 2. 展示用户数据和访问统计
// * 3. 演示 Session 的使用
// */
////@WebServlet("/userInfo")
//public class UserInfoServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//
//        System.out.println("\n👤 UserInfoServlet 获取用户信息");
//
//        // 1. 从 Session 中获取用户
//        HttpSession session = req.getSession(false);
//        User user = (User) (session != null ? session.getAttribute("loginUser") : null);
//
//        if (user == null) {
//            // 未登录，跳转到登录页
//            resp.sendRedirect(req.getContextPath() + "/login.jsp");
//            return;
//        }
//
//        // 2. 设置响应格式
//        resp.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = resp.getWriter();
//
//        // 3. 生成 HTML 页面
//        out.println("<!DOCTYPE html>");
//        out.println("<html>");
//        out.println("<head><title>用户信息</title>");
//        out.println("<style>");
//        out.println("body { font-family: Arial; padding: 20px; background: #f5f5f5; }");
//        out.println(".info-box { background: white; padding: 20px; border-radius: 8px; max-width: 600px; margin: 20px auto; box-shadow: 0 2px 4px rgba(0,0,0,0.1); }");
//        out.println("h1 { color: #333; }");
//        out.println(".item { margin: 10px 0; padding: 10px; background: #f9f9f9; border-left: 4px solid #667eea; }");
//        out.println("a { color: #667eea; text-decoration: none; }");
//        out.println("</style></head>");
//        out.println("<body>");
//        out.println("<div class='info-box'>");
//        out.println("<h1>👤 用户信息</h1>");
//        out.println("<hr/>");
//        out.println("<div class='item'><strong>用户ID：</strong>" + user.getId() + "</div>");
//        out.println("<div class='item'><strong>用户名：</strong>" + user.getUsername() + "</div>");
//        out.println("<div class='item'><strong>邮  箱：</strong>" + user.getEmail() + "</div>");
//        out.println("<div class='item'><strong>访问次数：</strong>" + user.getVisitCount() + " 次</div>");
//        out.println("<div class='item'><strong>Session ID：</strong>" + session.getId() + "</div>");
//        out.println("<hr/>");
//        out.println("<a href='" + req.getContextPath() + "/user/index.jsp'>返回首页</a> | ");
//        out.println("<a href='" + req.getContextPath() + "/logout'>退出登录</a>");
//        out.println("</div>");
//        out.println("</body>");
//        out.println("</html>");
//
//        System.out.println("✅ 用户信息已展示");
//        System.out.println("   用户名: " + user.getUsername());
//        System.out.println("   访问次数: " + user.getVisitCount());
//    }
//}
