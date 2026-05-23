package net.xdclass.web.util;

import java.sql.*;
import java.util.Properties;

public class CustomDBUtil {

    private static String driver;

    private static String url;
    private static String password;

    private static String username;

    //静态代码块初始化信息
    static{

        try{
            Properties properties = new Properties();
            properties.load(CustomDBUtil.class.getClassLoader().getResourceAsStream("db.properties"));

            //初始化取值
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");

            //第1步：加载驱动
            Class.forName(driver);


        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取数据连接
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws  Exception{

            Connection connection = DriverManager.getConnection(url,username,password);
            return connection;

    }

    /**
     * 关闭数据资源
     * @param rs
     * @param ps
     * @param cs
     */
    public static void closeConnection(ResultSet rs, PreparedStatement ps, Connection conn) {

        try {

            if (rs != null) {
                rs.close();
            }

            if (ps != null) {
                ps.close();
            }

            if (conn != null) {
                conn.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException("数据库驱动加载失败", e);
        }
    }


}

