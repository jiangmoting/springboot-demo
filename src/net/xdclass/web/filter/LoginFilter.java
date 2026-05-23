//package net.xdclass.web.filter;
//
//import net.xdclass.web.domain.User;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * 登录验证过滤器
// *
// * 知识点：
// * 1. 检查用户是否已登录（通过 Session 判断）
// * 2. 未登录用户自动跳转到登录页
// * 3. 排除不需要登录的页面（如登录页本身、静态资源）
// *
// * 工作流程：
// * 用户访问受保护页面 → 检查 Session → 已登录则放行，未登录则跳转
// */
////@WebFilter(filterName = "LoginFilter", urlPatterns = {"/user/*", "/userInfo", "/index.jsp"})
//public class LoginFilter implements Filter {
//
//    private String loginPage = "/login.jsp";
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
////        System.out.println("【过滤器初始化】LoginFilter 启动");
//
//        String page = filterConfig.getInitParameter("loginPage");
//        if (page != null && !page.isEmpty()) {
//            this.loginPage = page;
//        }
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//
//        String uri = httpRequest.getRequestURI();
////        System.out.println("\n🔒 LoginFilter 检查权限: " + uri);
//
//        // 1. 从 Session 中获取登录用户
//        User loginUser = (User) httpRequest.getSession().getAttribute("loginUser");
//
//        if (loginUser != null) {
//            // ✅ 已登录，放行
//            System.out.println("✅ 用户已登录: " + loginUser.getUsername());
//
//            // 增加访问次数
//            loginUser.incrementVisitCount();
//
//            chain.doFilter(request, response);
//
//        } else {
//            // ❌ 未登录，跳转到登录页
////            System.out.println("❌ 用户未登录，跳转到登录页");
//
//            // 保存用户原本想访问的 URL，登录后可以跳回去
//            String redirectUrl = httpRequest.getRequestURL().toString();
//            String queryString = httpRequest.getQueryString();
//            if (queryString != null) {
//                redirectUrl += "?" + queryString;
//            }
//            httpRequest.getSession().setAttribute("redirectUrl", redirectUrl);
//
//            // 设置提示信息
//            httpRequest.setAttribute("msg", "⚠️ 请先登录");
//
//            // 转发到登录页（注意：这里是 FORWARD，不是重定向）
//            httpRequest.getRequestDispatcher(loginPage).forward(httpRequest, httpResponse);
//        }
//    }
//
//    @Override
//    public void destroy() {
//        System.out.println("【过滤器销毁】LoginFilter 关闭");
//    }
//}
