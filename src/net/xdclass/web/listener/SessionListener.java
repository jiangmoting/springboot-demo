package net.xdclass.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.time.LocalDateTime;

@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("[Session创建] SessionID: " + se.getSession().getId());
        System.out.println("[Session创建] 创建时间: " + LocalDateTime.now());

        ServletContext servletContext = se.getSession().getServletContext();
        Integer onlineNum = (Integer) servletContext.getAttribute("onlineNum");

        if (onlineNum == null) {
            onlineNum = 0;
        }

        onlineNum++;
        servletContext.setAttribute("onlineNum", onlineNum);

        System.out.println("[Session创建] 当前在线人数: " + onlineNum);
        System.out.println("----------------------------------------");
    }

    //@Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("[Session销毁] SessionID: " + se.getSession().getId());
        System.out.println("[Session销毁] 销毁时间: " + LocalDateTime.now());

        ServletContext servletContext = se.getSession().getServletContext();
        Integer onlineNum = (Integer) servletContext.getAttribute("onlineNum");

        if (onlineNum == null || onlineNum <= 0) {
            onlineNum = 0;
        } else {
            onlineNum--;
        }

        servletContext.setAttribute("onlineNum", onlineNum);

        System.out.println("[Session销毁] 当前在线人数: " + onlineNum);
        System.out.println("----------------------------------------");
    }
}