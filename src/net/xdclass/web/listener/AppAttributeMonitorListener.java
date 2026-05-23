package net.xdclass.web.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import java.time.LocalDateTime;

//@WebListener
public class AppAttributeMonitorListener implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        System.out.println("[应用属性监控] 添加属性");
        System.out.println("  名称: " + event.getName());
        System.out.println("  值: " + event.getValue());
        System.out.println("  时间: " + LocalDateTime.now());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        System.out.println("[应用属性监控] 删除属性");
        System.out.println("  名称: " + event.getName());
        System.out.println("  值: " + event.getValue());
        System.out.println("  时间: " + LocalDateTime.now());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        System.out.println("[应用属性监控] 修改属性");
        System.out.println("  名称: " + event.getName());
        System.out.println("  旧值: " + event.getValue());
        System.out.println("  时间: " + LocalDateTime.now());
    }
}