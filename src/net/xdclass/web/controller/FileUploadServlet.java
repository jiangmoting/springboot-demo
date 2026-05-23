
package net.xdclass.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * 文件上传 Servlet
 * 处理用户上传文件的请求，将文件保存到服务器指定目录
 */
//@WebServlet("/fileUpload")
// @MultipartConfig: 标识该 Servlet 支持 multipart/form-data 格式的文件上传
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

    /**
     * 处理 POST 请求的文件上传
     * @param request HTTP 请求对象，包含上传的文件和表单数据
     * @param response HTTP 响应对象
     * @throws ServletException Servlet 异常
     * @throws IOException IO 异常
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取普通表单字段（如用户名）
        String username = request.getParameter("username");
        System.out.println("username=" + username);

        // 2. 获取上传的文件部分（对应表单中 name="img" 的文件输入框）
        Part part = request.getPart("img");

        // 3. 从请求头中解析原始文件名
        // Content-Disposition 头的格式: form-data; name="img"; filename="example.jpg"
        String header = part.getHeader("content-disposition");

        // 提取 filename 后面的实际文件名
        String realFileName = header.substring(header.indexOf("filename=") + 10, header.length() - 1);
        System.out.println("realFileName=" + realFileName);

        // 4. 获取上传文件的输入流，用于读取文件内容
        InputStream fis = part.getInputStream();

        // 5. 确定文件保存的目录路径
        // getRealPath("/file") 获取 web 应用下 /file 目录的实际文件系统路径
        // 注意：原代码中的 "/WEB-INF/file" 被注释掉了，因为 WEB-INF 目录外界无法直接访问
        // 如果文件机密性强，建议存放在 WEB-INF 目录下
        String dir = this.getServletContext().getRealPath("/file");
        File dirFile = new File(dir);

        // 6. 如果目标目录不存在，则创建目录（包括所有必需的父目录）
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }

        // 7. 生成唯一文件名，避免文件名冲突
        // 使用 UUID 确保每个文件名都是唯一的，防止覆盖已有文件
        String uniqueName = UUID.randomUUID() + realFileName;

        // 8. 创建目标文件对象
        File file = new File(dir, uniqueName);

        // 9. 创建文件输出流，准备写入文件
        FileOutputStream out = new FileOutputStream(file);

        // 10. 通过缓冲区将输入流的数据复制到输出流（文件拷贝）
        /*
         *创建一个大小为 1024 字节（1KB） 的字节数组作为缓冲区
         *作用：避免一次性读取整个文件到内存，节省内存空间
         *为什么用缓冲区？
             *❌ 不用缓冲区：每次只读/写 1 个字节，效率极低（频繁 IO 操作）
             *✅ 用缓冲区：每次读/写 1024 字节，减少 IO 次数，提高效率
         */
        byte[] buf = new byte[1024];  // 1KB 缓冲区
        int len;
        //is.read(buf)
        //从输入流读取最多 1024 字节到 buf，返回实际读取的字节数
        while ((len = fis.read(buf)) != -1) {
            out.write(buf, 0, len);  // 写入实际读取的字节数
        }

        // 11. 关闭流资源，释放系统资源
        out.close();
        fis.close();

        // 12. 转发请求到文件访问路径，让用户可以查看上传的文件
        request.getRequestDispatcher("/file/" + uniqueName).forward(request, response);
    }
}