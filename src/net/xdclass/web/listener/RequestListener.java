package net.xdclass.web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

//@WebListener
public class RequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        Integer totalVisit = (Integer) sre.getServletContext().getAttribute("totalVisit");

        if (totalVisit == null) {
            totalVisit = 0;
        }

        totalVisit++;
        sre.getServletContext().setAttribute("totalVisit", totalVisit);

        System.out.println("总访问次数：" + totalVisit);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        // 请求销毁时的处理逻辑（可选）
    }
}
