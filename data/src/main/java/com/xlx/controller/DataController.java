package com.xlx.controller;

import com.alibaba.fastjson.JSON;
import com.xlx.db.pojo.Role;
import com.xlx.db.pojo.User;
import com.xlx.mapper.miaosha.UserMapper;
import com.xlx.mapper.slavel.RoleMapper;
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
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @GetMapping("/test")
    public String getTest(){
        User userById = userMapper.findUserById("1");
        return JSON.toJSONString(userById);
    }

    @GetMapping("/test2")
    public String getRole(){
        List<Role> roles = roleMapper.listRole();
        return JSON.toJSONString(roles);
    }

}
