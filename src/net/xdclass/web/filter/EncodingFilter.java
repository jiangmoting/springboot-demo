package net.xdclass.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 编码过滤器
 *
 * 知识点：
 * 1. Filter 是过滤器，可以在请求到达 Servlet 之前进行预处理
 * 2. 统一设置字符编码，防止中文乱码
 * 3. 可以过滤所有请求（/*）
 *
 * 执行顺序：
 * 浏览器请求 → EncodingFilter → LoginFilter → Servlet → JSP
 */
//@WebFilter(filterName = "EncodingFilter", urlPatterns = {"/*"})
public class EncodingFilter implements Filter {

    private String encoding = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("【过滤器初始化】EncodingFilter 启动");

        // 从 web.xml 或注解中获取编码配置
        String enc = filterConfig.getInitParameter("encoding");
        if (enc != null && !enc.isEmpty()) {
            this.encoding = enc;
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String uri = httpRequest.getRequestURI();

        // 跳过静态资源（提高性能）
        if (uri.endsWith(".ico") || uri.endsWith(".css") ||
                uri.endsWith(".js") || uri.endsWith(".png") ||
                uri.endsWith(".jpg") || uri.endsWith(".gif")) {
            chain.doFilter(request, response);
            return;
        }

//        System.out.println("\n" + "==================================================");
//        System.out.println("🔤 EncodingFilter 处理请求");
//        System.out.println("URL: " + uri);
//        System.out.println("方法: " + httpRequest.getMethod());
//        System.out.println("===================================================");

        // ⚠️ 关键：必须在获取参数之前设置编码
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        response.setContentType("text/html;charset=UTF-8");

        // 放行，进入下一个过滤器或 Servlet
        chain.doFilter(request, response);

//        System.out.println("✅ EncodingFilter 处理完成\n");
    }

    @Override
    public void destroy() {
        System.out.println("【过滤器销毁】EncodingFilter 关闭");
    }
}
