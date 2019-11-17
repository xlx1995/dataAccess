package com.xlx.controller;

import com.alibaba.fastjson.JSON;
import com.xlx.db.pojo.Role;
import com.xlx.db.pojo.User;
import com.xlx.mapper.miaosha.UserMapper;
import com.xlx.mapper.slavel.RoleMapper;
import com.xlx.service.RoleService;
import com.xlx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xlx
 */
@RestController
public class DataController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @GetMapping("/test")
    public String getTest(){
        User userById = userService.findUserById("1");
        return JSON.toJSONString(userById);
    }

    @GetMapping("/test2")
    public String getRole(){
        List<Role> roles = roleService.listRole();
        return JSON.toJSONString(roles);
    }

    @GetMapping("/test3")
    public String test3(){
        return userService.testTransaction();
    }

}
