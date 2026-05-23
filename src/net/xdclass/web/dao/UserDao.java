package net.xdclass.web.dao;

import net.xdclass.web.domain.User;
import net.xdclass.web.util.DataSourceUtil;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.*;

import java.util.List;
import java.util.Map;

public class UserDao {

    /**
     * 小滴课堂JDBC实战
     * 根据id查询用户
     * @param id
     * @return
     */
    private QueryRunner queryRunner = new QueryRunner(DataSourceUtil.getDataSource());

    //开启驼峰映射
    private BeanProcessor bean = new GenerousBeanProcessor();
    private RowProcessor processor = new BasicRowProcessor( bean);

    public int save(User user){

        String sql = "insert into user (phone,pwd,sex,img,create_time,role,username,wechat) values(?,?,?,?,?,?,?,?)";

        Object [] params = {
                user.getPhone(),
                user.getPwd(),
                user.getSex(),
                user.getImg(),
                user.getCreateTime(),
                user.getRole(),
                user.getUsername(),
                user.getWechat(),
        };

        int i = 0;

        try{
            i = queryRunner.update(sql,params);
        }catch (Exception e){
            e.printStackTrace();
        }

        return i;
    }

    public User findById(int id){
        String sql = "select * from user where id = ?";
        User user = null;
        try {
            user =queryRunner.query(sql, new BeanHandler<User>(User.class), id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> list(){
        String sql = "select * from user";
        List<User> list = null;
        try {
            list =queryRunner.query(sql, new BeanListHandler<User>(User.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 小滴课堂JDBC实战
     * 根据id查询用户,MapHandler
     * @param id
     * @return
     */
    public Map<String,Object> findByIdWithMap(int id){
        String sql = "select * from user where id = ?";
        Map<String,Object> map = null;
        try {
            map =queryRunner.query(sql, new MapHandler(), id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 小滴课堂JDBC实战
     * 查询全部用户,MapListHandler
     * @param
     * @return
     */
    public List<Map<String, Object>> listWithMap(){
        String sql = "select * from user";
        List<Map<String, Object>> list = null;
        try {
            list =queryRunner.query(sql, new MapListHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int countUser(){
        String sql = "select count(*) from user";

        Long count = null;

        try{
            count = queryRunner.query(sql,new ScalarHandler<>());
        }catch (Exception e){
            e.printStackTrace();
        }


        return count.intValue();

    }

}
