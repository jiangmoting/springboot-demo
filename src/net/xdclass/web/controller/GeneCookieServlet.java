package net.xdclass.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/gene_cookie_test")
public class GeneCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //生成Cookie
        Cookie cookie = new Cookie("username","xdclass");

        //设置Cookie的有效时间20秒
        cookie.setMaxAge(20);

        response.addCookie(cookie);
    }
}
