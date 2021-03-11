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

}
