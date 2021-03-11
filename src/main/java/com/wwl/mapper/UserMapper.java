package com.wwl.mapper;

import com.wwl.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserMapper {
    //查询所有
    ArrayList<User> findAllUser();

    //查询id
    User findById(@Param("ids") Integer ids);

    //添加
    void saveUser(User user);

    //修改
    Integer updateUser(User user);
    //删除
    Integer removeUser(Integer id);
}
