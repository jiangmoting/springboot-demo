package net.xdclass.web.controller;

import net.xdclass.web.util.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 退出登录 Servlet
 *
 * 知识点：
 * 1. 销毁 Session，清除登录状态
 * 2. 删除 Cookie，取消"记住我"
 * 3. 重定向到登录页
 */
//@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("\n🚪 LogoutServlet 处理退出登录");

        // 1. 获取 Session（不创建新的）
        HttpSession session = req.getSession(false);

        if (session != null) {
            // 2. 清除 Session 中的用户信息
            session.removeAttribute("loginUser");

            // 3. 销毁整个 Session
            session.invalidate();

            System.out.println("✅ Session 已销毁");
        }

        // 4. 删除 Cookie
        CookieUtil.deleteCookie(resp, "rememberUsername");
        CookieUtil.deleteCookie(resp, "autoLogin");

        System.out.println("✅ Cookie 已删除");

        // 5. 重定向到登录页
        resp.sendRedirect(req.getContextPath() + "/login.jsp");

        System.out.println("🔀 已重定向到登录页\n");
    }
}
