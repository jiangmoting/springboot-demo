package net.xdclass.web.listener;

import net.xdclass.web.domain.Config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.time.LocalDateTime;

//@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("========================================");
        System.out.println("监听器启动时间: " + LocalDateTime.now());
        System.out.println("========================================");

        ServletContext servletContext = sce.getServletContext();

        String url = servletContext.getInitParameter("url");
        String topic = servletContext.getInitParameter("topic");

        Config config = new Config();
        config.setTopic(topic);
        config.setUrl(url);
        servletContext.setAttribute("config", config);

        servletContext.setAttribute("onlineNum", 0);
        //总访问次数
        servletContext.setAttribute("totalVisit",0);

        System.out.println("应用配置初始化完成");
        System.out.println("URL: " + url);
        System.out.println("Topic: " + topic);
        System.out.println("在线人数初始化为: 0");
        System.out.println("在线访问次数初始化为: 0");
        System.out.println("========================================");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("========================================");
        System.out.println("监听器销毁时间: " + LocalDateTime.now());
        System.out.println("========================================");
    }
}