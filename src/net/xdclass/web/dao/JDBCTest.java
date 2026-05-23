package net.xdclass.web.dao;

import java.sql.*;

public class JDBCTest {

    public static void main(String [] args){
        try {
            //testInjectSql();
            //testAdd();
            //testDelete();
            testTransaction();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void testInjectSql() throws Exception{
        //加载JDBC驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //建⽴数据库连接Connection
        String username = "root";
        String password = "root";

        //协议:⼦协议://ip:端⼝/数据库名称?参数1=值1&参数2=值2
        String url = "jdbc:mysql://192.168.174.100:3306/xd_web?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
        Connection connection = DriverManager.getConnection(url,username,password);
        //创建执⾏SQL的语句Statement
        //Statement statement = connection.prepareStatement();

        //预编译字符串
        String name = "Jack";
        String pwd = "666";
        String sql = "select * from user where username=? and pwd=?";

        //处理执⾏结果ResultSet
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,pwd);
        System.out.println("执行查询 - 用户名：" + name + "，密码： " + pwd);


        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println("⽤户名称 name="+ resultSet.getString("username") + " 联系⽅式 wechat="+ resultSet.getString("wechat"));
        }
        //释放连接资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

    private static void testAdd() throws Exception{
        //加载JDBC驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //建⽴数据库连接Connection
        String username = "root";
        String password = "root";

        //协议:⼦协议://ip:端⼝/数据库名称?参数1=值1&参数2=值2
        String url = "jdbc:mysql://192.168.174.100:3306/xd_web?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
        Connection connection = DriverManager.getConnection(url,username,password);

        PreparedStatement preparedStatement =connection.prepareStatement("insert into user(username,pwd,sex,role,create_time) values(?,?,?,?,?)");
        preparedStatement.setString(1,"JDBCTest");
        preparedStatement.setString(2,"123456");
        preparedStatement.setInt(3,1);
        preparedStatement.setInt(4,1);
        preparedStatement.setTimestamp(5,new Timestamp(System.currentTimeMillis()));

        //处理执行
        preparedStatement.execute();

        //释放连接资源
        preparedStatement.close();
        connection.close();
    }

    private static void testDelete() throws Exception{
        //加载JDBC驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //建⽴数据库连接Connection
        String username = "root";
        String password = "root";

        //协议:⼦协议://ip:端⼝/数据库名称?参数1=值1&参数2=值2
        String url = "jdbc:mysql://192.168.174.100:3306/xd_web?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
        Connection connection = DriverManager.getConnection(url,username,password);

        PreparedStatement preparedStatement =connection.prepareStatement("delete from user where username=?");
        preparedStatement.setString(1,"JDBCTest");

        //处理执行
        preparedStatement.execute();

        //释放连接资源
        preparedStatement.close();
        connection.close();
    }

    private static void testTransaction() throws Exception{
        //加载JDBC驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //建⽴数据库连接Connection
        String username = "root";
        String password = "root";

        //协议:⼦协议://ip:端⼝/数据库名称?参数1=值1&参数2=值2
        String url = "jdbc:mysql://192.168.174.100:3306/xd_web?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";

        Connection connection = DriverManager.getConnection(url,username,password);

        //设置JDBC事务不要自动提交
        connection.setAutoCommit(false);


        try{
            PreparedStatement ps1 =connection.prepareStatement("insert into user(username,pwd,sex,role,create_time) values(?,?,?,?,?)");
            ps1.setString(1,"111transc 1");
            ps1.setString(2,"123456");
            ps1.setInt(3,1);
            ps1.setInt(4,1);
            ps1.setTimestamp(5,new Timestamp(System.currentTimeMillis()));

            PreparedStatement ps2 =connection.prepareStatement("insert into user(username,pwd,sex,role,create_time) values(?,?,?,?,?)");
            ps2.setString(1,"222transc 2");
            ps2.setString(2,"654321");
            ps2.setInt(3,2);
            ps2.setInt(4,2);
            ps2.setTimestamp(5,new Timestamp(System.currentTimeMillis()));

            ps1.execute();
            ps2.execute();

        } catch (Exception e) {
            e.printStackTrace();
            //事务回滚
            connection.rollback();
        } finally {
            //事务提交
            connection.commit();
            connection.close();
        }
    }
}
