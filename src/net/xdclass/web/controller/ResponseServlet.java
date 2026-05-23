package net.xdclass.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet ("/response")
public class ResponseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rerequest, HttpServletResponse response) throws ServletException, IOException {

        //设置响应字符集
        response.setCharacterEncoding("UTF-8");
        //response.addHeader("name","java");
        //response.addHeader("xxx","Spring");
        //response.setHeader("name","Mary");
        //response.setStatus(200);

        String data = "⼩滴课堂java⾼级⼯程师成⻓系列";
        //设置响应头charset=utf-8，防止乱码
        response.setHeader("Content-Type","text/html;charset=UTF-8");

        //使用OutputStream输出流，写数据，默认是 ISO-8859-1，与getWriter()互斥
//        OutputStream outputStream =response.getOutputStream();
//        byte[] bytes = data.getBytes("UTF-8");
//        outputStream.write(bytes);

        //使用字符输出流，写数据
        response.getWriter().write(data);


    }
}
