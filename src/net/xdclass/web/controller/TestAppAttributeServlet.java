//package net.xdclass.web.controller;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
////@WebServlet("/test-app-attribute")
//public class TestAppAttributeServlet extends HttpServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//
//        String action = req.getParameter("action");
//        String attrName = req.getParameter("attrName");
//        String attrValue = req.getParameter("attrValue");
//
//        if ("add".equals(action)) {
//            getServletContext().setAttribute(attrName, attrValue);
//            System.out.println("✅ 已添加应用属性: " + attrName + " = " + attrValue);
//        } else if ("update".equals(action)) {
//            getServletContext().setAttribute(attrName, attrValue);
//            System.out.println("✅ 已更新应用属性: " + attrName + " = " + attrValue);
//        } else if ("delete".equals(action)) {
//            getServletContext().removeAttribute(attrName);
//            System.out.println("✅ 已删除应用属性: " + attrName);
//        }
//
//        resp.sendRedirect(req.getContextPath() + "/test-app-attribute.jsp");
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.sendRedirect(req.getContextPath() + "/test-app-attribute.jsp");
//    }
//}
