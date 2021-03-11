package com.wwl.controller;

import com.alibaba.fastjson.JSON;
import com.wwl.service.UserService;
import com.wwl.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public String finaAllUser(){
       ArrayList<User> arrayList=userService.findAllUser();
        for (User user : arrayList) {
            System.out.println(user);
        }
        String userJson= JSON.toJSONString(arrayList);
        return userJson;
    }
}
