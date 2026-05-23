package net.xdclass.web.controller;

import net.xdclass.web.domain.User;
import net.xdclass.web.service.UserService;
import net.xdclass.web.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet(name="userServlet",urlPatterns = {"/user"})
public class UserServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method =req.getParameter("method");
        if ("findById".equals(method)) {
            int userId = Integer.parseInt(req.getParameter("id"));
            User user = userService.findById(userId);
            System.out.println("用户信息：" + user.toString());
        }

        if ("list".equals(method)) {
            List<User> list = userService.list();
            System.out.println("用户信息：" + list.toString());
        }

        if ("findByIdWithMap".equals(method)) {
            int userId = Integer.parseInt(req.getParameter("id"));
            Map<String, Object> map = userService.findByIdWithMap(userId);
            System.out.println("用户信息：" + map.toString());
        }

        if ("listWithMap".equals(method)) {
            List<Map<String, Object>> list = userService.listWithMap();
            System.out.println("用户信息：" + list.toString());
        }

        if("countUser".equals(method)){
            int count = userService.countUser();
            System.out.println("用户数量：" + count);
        }

        if("saveUser".equals(method)){

            User user = new User();
            user.setPhone("150651234");
            user.setImg("baidu.com");
            user.setPwd("pwd");
            user.setRole(1);
            user.setSex(1);
            user.setCreateTime(new Date());
            user.setUsername("小D");
            user.setWechat("shuting");

            int row = userService.saveUser(user);

            System.out.println("row="+row);
            if(row==1){
                System.out.println("插入成功");
            }else {
                System.out.println("插入失败");
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String username = req.getParameter("username");
        String pwd = req.getParameter("password");

        if (username == null || pwd == null) {
            resp.getWriter().write("参数错误");
            return;
        }

        if ("xdclass".equals(username) && "123".equals(pwd)) {
            resp.getWriter().write("登录成功");
        } else {
            resp.getWriter().write("账号密码错误");
        }
    }
}


