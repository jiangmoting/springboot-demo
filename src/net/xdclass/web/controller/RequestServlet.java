package net.xdclass.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

//@WebServlet("/request")
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

    //客户端请求信息
        System.out.println("应⽤上下⽂路径getContextPath="+request.getContextPath()) ;
        System.out.println("客户端发出请求时的完整URL getRequestURL="+request.getRequestURL()) ;
        System.out.println("请求⾏中的资源名部分 getRequestURI="+request.getRequestURI()) ;
        System.out.println("请求⾏中的参数部分 getQueryString="+request.getQueryString()) ;
        System.out.println("发出请求的客户机的IP地址 getRemoteAddr="+request.getRemoteAddr()) ;
        System.out.println("客户机发请求使⽤的⽹络端⼝号 getRemotePort="+request.getRemotePort()) ;

    //获取请求头
        System.out.println("获取请求头 getHeader(Accept)="+request.getHeader("Accept")) ;

    //获取请求参数
        System.out.println("客户端请求参数 getParameter="+request.getParameter("userName"));
        String[] sport = request.getParameterValues("sport");
        System.out.println("客户端请求参数列表,多个值getParameterValues="+sport.toString());
        Map<String,String[]> map = request.getParameterMap();
        System.out.println("客户端请求参数封装成的map类型 getParameterMap="+map.toString());
    }
}
