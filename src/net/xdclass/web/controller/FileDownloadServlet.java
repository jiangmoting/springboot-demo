package net.xdclass.web.controller;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 文件下载 Servlet
 * 处理客户端的文件下载请求，将服务器上的文件发送给浏览器
 */
//@WebServlet("/fileDownload")
public class FileDownloadServlet extends HttpServlet {

    /**
     * 处理 GET 请求的文件下载
     * @param request HTTP 请求对象，包含要下载的文件名参数
     * @param response HTTP 响应对象，用于返回文件数据
     * @throws ServletException Servlet 异常
     * @throws IOException IO 异常
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1. 获取客户端传递的要下载的文件名
        String fileName = request.getParameter("file");

        // 2. 验证文件名参数
        if (fileName == null || fileName.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "文件名不能为空");
            return;
        }

        // 3. 防止路径遍历攻击（安全检查）
        // 如果文件名包含 "../" 等路径跳转符号，拒绝下载
        if (fileName.contains("..") || fileName.contains("/") || fileName.contains("\\")) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "非法的文件名");
            return;
        }

        // 4. 获取文件在服务器上的实际路径
        // getRealPath("/file/") 返回 web 应用下 /file 目录的绝对路径
        // 例如: C:\tomcat\webapps\webdemo\file\
        String directory = request.getServletContext().getRealPath("/file/");

        // 5. 拼接完整的文件路径
        File file = new File(directory, fileName);

        // 6. 检查文件是否存在且是普通文件（不是目录）
        if (!file.exists() || !file.isFile()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "文件不存在");
            return;
        }

        // 7. 设置响应的字符编码
        response.setCharacterEncoding("UTF-8");

        // 8. 设置响应内容类型为二进制流（通用类型，适用于所有文件）
        response.setContentType("application/octet-stream");

        // 9. 设置 Content-Disposition 响应头，告诉浏览器这是附件下载
        // attachment: 以附件形式下载（而不是在浏览器中打开）
        // filename: 指定下载后的文件名

        // 9.1 处理中文文件名乱码问题
        // 不同浏览器对中文文件名的处理方式不同，需要特殊处理
        String encodedFileName = encodeFileName(fileName, request);
        response.setHeader("Content-Disposition", "attachment;filename=" + encodedFileName);

        // 10. 设置文件大小（可选，浏览器可以显示下载进度）
        response.setContentLengthLong(file.length());

        // 11. 读取文件并写入响应输出流
        // 使用 try-with-resources 确保资源自动关闭
        try (FileInputStream fis = new FileInputStream(file);
             ServletOutputStream out = response.getOutputStream()) {

            // 创建缓冲区（8KB，比 1KB 效率更高）
            byte[] buffer = new byte[8192];
            int bytesRead;

            // 循环读取文件内容并写入响应流
            while ((bytesRead = fis.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            // 刷新输出流，确保所有数据都发送给客户端
            out.flush();
        }
        // try-with-resources 会自动关闭 fis 和 out
    }

    /**
     * 对文件名进行编码，解决中文文件名在不同浏览器中的乱码问题
     *
     * @param fileName 原始文件名
     * @param request HTTP 请求对象，用于获取 User-Agent 判断浏览器类型
     * @return 编码后的文件名
     * @throws UnsupportedEncodingException 不支持的编码异常
     */
    private String encodeFileName(String fileName, HttpServletRequest request) throws UnsupportedEncodingException {
        // 获取浏览器的 User-Agent 信息
        String userAgent = request.getHeader("User-Agent");

        // 判断是否为 IE 浏览器或 Edge 旧版本
        if (userAgent != null && (userAgent.contains("MSIE") || userAgent.contains("Trident"))) {
            // IE 浏览器：使用 URLEncoder 编码
            return URLEncoder.encode(fileName, "UTF-8");
        } else {
            // Chrome、Firefox、Edge 等现代浏览器
            // 使用 RFC 5987 标准的编码方式
            return URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
        }
    }
}
