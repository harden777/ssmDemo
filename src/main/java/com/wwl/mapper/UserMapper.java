package com.wwl.mapper;

import com.wwl.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserMapper {
    //查询所有
    ArrayList<User> findAllUser();

}
