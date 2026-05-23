package net.xdclass.web.service.impl;

import net.xdclass.web.dao.UserDao;
import net.xdclass.web.domain.User;
import net.xdclass.web.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private UserDao userDao= new UserDao();

    @Override
    public User findById(int id) {

        return userDao.findById(id);
    }

    @Override
    public List<User> list() {

        return userDao.list();
    }

    @Override
    public Map<String, Object> findByIdWithMap(int id) {
        return userDao.findByIdWithMap(id);
    }

    @Override
    public List<Map<String, Object>> listWithMap() {
        return userDao.listWithMap();
    }

    @Override
    public int countUser() {
        return userDao.countUser();
    }

    @Override
    public int saveUser(User user) {
        return userDao.save(user);
    }
}
