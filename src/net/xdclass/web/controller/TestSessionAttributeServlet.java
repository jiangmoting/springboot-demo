//
//package net.xdclass.web.controller;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
////@WebServlet("/test-session-attribute")
//public class TestSessionAttributeServlet extends HttpServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//
//        String action = req.getParameter("action");
//        HttpSession session = req.getSession();
//
//        if ("add".equals(action) || "update".equals(action)) {
//            String attrName = req.getParameter("attrName");
//            String attrValue = req.getParameter("attrValue");
//            session.setAttribute(attrName, attrValue);
//            System.out.println("✅ 已" + ("add".equals(action) ? "添加" : "更新") + " Session属性: " + attrName + " = " + attrValue);
//        } else if ("delete".equals(action)) {
//            String attrName = req.getParameter("attrName");
//            session.removeAttribute(attrName);
//            System.out.println("✅ 已删除 Session属性: " + attrName);
//        } else if ("invalidate".equals(action)) {
//            System.out.println("💥 即将销毁 Session: " + session.getId());
//            session.invalidate();
//            resp.sendRedirect(req.getContextPath() + "/index.jsp");
//            return;
//        }
//
//        resp.sendRedirect(req.getContextPath() + "/test-session-attribute.jsp");
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.sendRedirect(req.getContextPath() + "/test-session-attribute.jsp");
//    }
//}