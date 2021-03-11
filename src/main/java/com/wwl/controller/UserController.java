package com.wwl.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wwl.service.UserService;
import com.wwl.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/findAll/{pageNo}/{pageSize}")
    public String finaAllUser(@PathVariable(value = "pageNo") Integer pageNo,@PathVariable(value = "pageSize")Integer pagesize ){
        PageHelper.startPage(pageNo,pagesize);
        ArrayList<User> userList=userService.findAllUser();
        for (User user : userList) {
            System.out.println(user);
        }
        PageInfo<User> pageInfo=new PageInfo<User>(userList);
        System.out.println("list"+pageInfo.getList());
        System.out.println("total"+pageInfo.getTotal());
        System.out.println( "size"+pageInfo.getSize());
        String userJson= JSON.toJSONString(pageInfo);
        System.out.println(userJson);
        return userJson;
    }

    @GetMapping("/findByid/{ids}")
    public String findById(@PathVariable(value = "ids") Integer ids) {

        User user =userService.findById(ids);
        System.out.println(user);
        String usr=JSON.toJSONString(user);
        return usr;
    }

   // @GetMapping("/findByid/{id}/{name}/{age}")
    @GetMapping("/saveUser/{name}/{age}")
    public void saveUser(@PathVariable(value = "name") String name ,@PathVariable(value = "age") Integer age) {
       User user=new User();
       user.setName(name);
       user.setAge(age);
        userService.saveUser(user);
    }
    @GetMapping("/updateUser/{id}/{name}")

    public String updateUser(Model model, @PathVariable(value = "id") Integer id, @PathVariable(value = "name") String name) {
        User user =new User();
        user.setId(id);
        user.setName(name);
        Integer integer = userService.updateUser(user);
        model.addAttribute("id",integer);
        System.out.println(integer);
        return "aaaa";
    }

    @GetMapping("/removeUser/{id}")
    public String removeUser(Model model,@PathVariable(value = "id") Integer id) {

        Integer integer = userService.removeUser(id);
        model.addAttribute("id",integer);
        return "redirect:/index.jsp";
    }

    @RequestMapping("/remove")
    public String remove(){

        return "bbb";
    }

}
