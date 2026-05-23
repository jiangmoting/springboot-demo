package net.xdclass.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter(servletNames = {"cookieServlet"}, urlPatterns = {"/user/*"})
public class CustomFilter implements Filter {

    private FilterConfig filterConfig;

    private String encoding;

    private String loginPage;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        this.filterConfig = filterConfig;
        System.out.println("CustomFilter init");

        String filterName = filterConfig.getFilterName();
        System.out.println("过滤器名称：" + filterName);

        this.encoding = filterConfig.getInitParameter("encoding");
        this.loginPage = filterConfig.getInitParameter("loginPage");
    }

    // 过滤器逻辑
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String uri = httpRequest.getRequestURI();

        // 跳过静态资源
        if (uri.endsWith(".ico") || uri.endsWith(".css") ||
                uri.endsWith(".js") || uri.endsWith(".png") ||
                uri.endsWith(".jpg") || uri.endsWith(".gif")) {
            chain.doFilter(request, response);
            return;
        }

//        System.out.println("\n========================================");
//        System.out.println("=== CustomFilter 开始执行 ===");
//        System.out.println("请求类型: " + httpRequest.getMethod());
//        System.out.println("请求URI: " + httpRequest.getRequestURI());
//        System.out.println("查询字符串: " + httpRequest.getQueryString());
//        System.out.println("Referer: " + httpRequest.getHeader("Referer"));
//        System.out.println("User-Agent: " + httpRequest.getHeader("User-Agent"));
//        System.out.println("设置编码: " + encoding);
//        System.out.println("时间戳: " + System.currentTimeMillis());
//        System.out.println("========================================\n");

        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("CustomFilter doFilter - 放行前");
        chain.doFilter(request, response);
        System.out.println("=== CustomFilter 执行完毕 ===");


    }
    @Override
    public void destroy() {

        System.out.println("CustomFilter destroy");
    }


}
