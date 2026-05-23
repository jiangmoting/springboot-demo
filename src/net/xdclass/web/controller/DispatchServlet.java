package net.xdclass.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author shuting
 */
//@WebServlet("/dispatch")
public class DispatchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Config config = (Config) getServletContext().getAttribute("config");
        //System.out.println(config.getTopic());

        String url = getServletContext().getInitParameter("url");
        String topic = getServletContext().getInitParameter("topic");

        System.out.println("应用URL: " + url);
        System.out.println("应用主题: " + topic);



        //req.getRequestDispatcher("/index.jsp").forward(req,resp);
        resp.sendRedirect(req.getContextPath() + "/index.jsp");

    }
}

