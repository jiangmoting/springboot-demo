package net.xdclass.web.service;

import net.xdclass.web.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    /**
     * 根据ID查询用户
     */
    User findById(int id);
    List<User> list();

    Map<String,Object> findByIdWithMap(int id);

    List<Map<String, Object>> listWithMap();

    int countUser();

    int saveUser(User user);
}
