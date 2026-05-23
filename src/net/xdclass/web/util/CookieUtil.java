package net.xdclass.web.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Cookie 工具类
 *
 * 知识点：
 * 1. Cookie 是存储在浏览器端的小段数据
 * 2. 用于实现"记住我"、购物车等功能
 * 3. Cookie 有有效期，可以持久化存储
 */
public class CookieUtil {

    /**
     * 添加 Cookie
     *
     * @param response HTTP 响应对象
     * @param name     Cookie 名称
     * @param value    Cookie 值
     * @param maxAge   有效期（秒），-1表示会话级别，0表示删除
     */
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        try {
            // URL 编码，防止中文乱码
            String encodedValue = URLEncoder.encode(value, "UTF-8");

            Cookie cookie = new Cookie(name, encodedValue);

            // 设置有效期
            cookie.setMaxAge(maxAge);
            // 设置路径，整个应用都可访问
            cookie.setPath("/");
            // 防止 JavaScript 访问，提高安全性
            cookie.setHttpOnly(true);

            response.addCookie(cookie);

            System.out.println("✅ 添加 Cookie: " + name + "=" + value + ", 有效期: " + maxAge + "秒");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取 Cookie
     *
     * @param request HTTP 请求对象
     * @param name    Cookie 名称
     * @return Cookie 值，不存在返回 null
     */
    public static String getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    try {
                        // URL 解码
                        String value = URLDecoder.decode(cookie.getValue(), "UTF-8");
                        System.out.println("📖 读取 Cookie: " + name + "=" + value);
                        return value;
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        System.out.println("❌ 未找到 Cookie: " + name);
        return null;
    }

    /**
     * 删除 Cookie
     *
     * @param response HTTP 响应对象
     * @param name     Cookie 名称
     */
    public static void deleteCookie(HttpServletResponse response, String name) {
        Cookie cookie = new Cookie(name, null);
        cookie.setMaxAge(0);  // 设置为 0，立即过期
        cookie.setPath("/");
        response.addCookie(cookie);

        System.out.println("🗑️ 删除 Cookie: " + name);
    }
}
