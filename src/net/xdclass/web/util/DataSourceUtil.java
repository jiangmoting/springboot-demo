package net.xdclass.web.util;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * 数据连接工具类
 */
public class DataSourceUtil {

    private static DataSource dataSource;

    static{

        try{
            //1.通过类加载器加载资源文件
            InputStream in =DataSourceUtil.class.getClassLoader().getResourceAsStream("databases.properties");
            Properties p = new Properties();
            //读取资源文件
            p.load(in);

            //2.使用工厂模式数据源对象
            dataSource = BasicDataSourceFactory.createDataSource(p);

        }catch (Exception e){
            e.printStackTrace();
            throw new ExceptionInInitializerError("初始化DBPC失败");
        }

    }

    /**
     * 获取数据连接池
     * @return
     */
    public static DataSource getDataSource(){

        return dataSource;

    }
}
