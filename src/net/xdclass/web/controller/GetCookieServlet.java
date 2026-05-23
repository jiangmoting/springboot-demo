package net.xdclass.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "cookieServlet",urlPatterns = {"/get_cookie_test"})
public class GetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取所有 Cookie
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            System.out.println("cookieName=" + cookie.getName());
            System.out.println("cookieValue=" + cookie.getValue());
            System.out.println("cookieMaxAge=" + cookie.getMaxAge());
            System.out.println("cookiePath=" + cookie.getPath());
            cookie.getDomain();

        }
    }
}
