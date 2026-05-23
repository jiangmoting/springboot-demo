package net.xdclass.web.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name="testUserServlet",urlPatterns = {"/test"})
public class TestUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //实战响应内容
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out =resp.getWriter();

        out.write("<div> TestdoGet 小滴课堂 xdclass.net 你好，让技术不再难学 </div>");

        //获取ServletContext对象，获取初始化参数
        ServletContext servletContext = req.getServletContext();

        String appInfo = (String) servletContext.getAttribute("appInfo");
        System.out.println("TestUserServlet appInfo=" + appInfo);
    }

}

