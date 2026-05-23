package net.xdclass.web.domain;

import java.util.Date;

/**
 Create Table: CREATE TABLE `user` (
 `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
 `phone` varchar(32) DEFAULT NULL,
 `pwd` varchar(128) DEFAULT NULL,
 `sex` int(2) DEFAULT NULL,
 `img` varchar(128) DEFAULT NULL,
 `create_time` datetime DEFAULT NULL,
 `role` int(11) DEFAULT NULL COMMENT '1是普通⽤户，2是管理员',
 `username` varchar(128) DEFAULT NULL,
 `wechat` varchar(128) DEFAULT NULL,
 PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4
 */
public class User  {

    private int id;

    private String phone;

    private String pwd;

    private int sex;

    private String img;

    private Date createTime;

    private int role;

    private String username;

    private String wechat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sex=" + sex +
                ", img='" + img + '\'' +
                ", createTime=" + createTime +
                ", role=" + role +
                ", username='" + username + '\'' +
                ", wechat='" + wechat + '\'' +
                '}';
    }
}
