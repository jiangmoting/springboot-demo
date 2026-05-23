package net.xdclass.web.controller;

import net.xdclass.web.util.CustomDBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//@WebServlet("/jdbc_test")
public class TestJDBCServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idStr = req.getParameter("id");
        int id = Integer.parseInt(idStr);

        try {

            Connection conn = CustomDBUtil.getConnection();
            PreparedStatement ps =conn.prepareStatement("select * from user where id=?");

            //设置参数
            ps.setInt(1,id);

            //执行查询
            ResultSet rs = ps.executeQuery();

            //处理结果
            while(rs.next()){
                System.out.println("用户名称： "+ rs.getString("username") +"，联系方式wechat:"+ rs.getString("wechat"));
            }

            //释放资源
            CustomDBUtil.closeConnection(rs,ps,conn);

        } catch (NumberFormatException e) {
            resp.getWriter().write("错误：id 参数格式不正确");
        } catch (Exception e) {  // ✅ 可以捕获 getConnection() 抛出的 Exception
            e.printStackTrace();
            resp.getWriter().write("系统错误：" + e.getMessage());
        }



    }
}
