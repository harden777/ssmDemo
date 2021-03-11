package com.wwl.service.impl;

import com.wwl.mapper.UserMapper;
import com.wwl.service.UserService;
import com.wwl.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ArrayList<User> findAllUser() {

        return userMapper.findAllUser();
    }

    @Override
    public User findById(Integer ids) {
        return userMapper.findById(ids);
    }

    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public Integer removeUser(Integer id) {
        return userMapper.removeUser(id);
    }

}
