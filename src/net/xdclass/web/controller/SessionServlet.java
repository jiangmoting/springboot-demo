package net.xdclass.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet("/session_servlet")
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        //获取session 的 Id
        System.out.println("sessionId =" + session.getId());

        //获取session 的创建时间戳，单位毫秒
        System.out.println("session创建时间 =" + session.getCreationTime());

        //获取session 是否是新创建的，记得清空浏览器的session，否则会返回false
        System.out.println("session is New? =" + session.isNew());

        //往session里存储数据
        session.setAttribute("name","小滴课堂xdclass");

        System.out.println("session最后访问时间 =" + session.getLastAccessedTime());
        System.out.println("session最大不活动间隔 =" + session.getMaxInactiveInterval());
        System.out.println("session是否是新的 =" + session.isNew());
        System.out.println("session最大不活动间隔 =" + session.getMaxInactiveInterval());

        session.invalidate();

    }
}
