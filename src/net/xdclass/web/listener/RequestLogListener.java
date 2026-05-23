package net.xdclass.web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//@WebListener
public class RequestLogListener implements ServletRequestListener {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();

        String ip = getClientIP(request);
        String uri = request.getRequestURI();
        String method = request.getMethod();
        String queryString = request.getQueryString();
        String timestamp = LocalDateTime.now().format(FORMATTER);

        System.out.println("========== 请求开始 ==========");
        System.out.println("时间: " + timestamp);
        System.out.println("IP: " + ip);
        System.out.println("方法: " + method);
        System.out.println("URI: " + uri);
        if (queryString != null && !queryString.isEmpty()) {
            System.out.println("参数: " + queryString);
        }

        request.setAttribute("requestStartTime", System.currentTimeMillis());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();

        Long startTime = (Long) request.getAttribute("requestStartTime");
        if (startTime != null) {
            long duration = System.currentTimeMillis() - startTime;
            System.out.println("处理耗时: " + duration + "ms");
        }
        System.out.println("========== 请求结束 ==========\n");
    }

    private String getClientIP(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}