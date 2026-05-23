package net.xdclass.web.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.time.LocalDateTime;

//@WebListener
public class SessionAttributeMonitorListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("[会话属性监控] 添加属性");
        System.out.println("  SessionID: " + event.getSession().getId());
        System.out.println("  名称: " + event.getName());
        System.out.println("  值: " + event.getValue());
        System.out.println("  时间: " + LocalDateTime.now());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("[会话属性监控] 删除属性");
        System.out.println("  SessionID: " + event.getSession().getId());
        System.out.println("  名称: " + event.getName());
        System.out.println("  值: " + event.getValue());
        System.out.println("  时间: " + LocalDateTime.now());
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("[会话属性监控] 修改属性");
        System.out.println("  SessionID: " + event.getSession().getId());
        System.out.println("  名称: " + event.getName());
        System.out.println("  旧值: " + event.getValue());
        System.out.println("  时间: " + LocalDateTime.now());
    }
}