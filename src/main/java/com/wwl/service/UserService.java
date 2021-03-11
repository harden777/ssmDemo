package com.wwl.service;

import com.wwl.entity.User;

import java.util.ArrayList;

public interface UserService {
    public ArrayList<User> findAllUser();

    //查询id
    public User findById(Integer ids);

    //添加
    public void saveUser(User user);

    //修改
    public Integer updateUser(User user);
    //删除
    public Integer removeUser(Integer id);
}
