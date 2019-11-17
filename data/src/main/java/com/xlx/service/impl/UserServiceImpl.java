package com.xlx.service.impl;

import com.xlx.db.pojo.User;
import com.xlx.mapper.miaosha.UserMapper;
import com.xlx.mapper.slavel.RoleMapper;
import com.xlx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xlx
 * @descritption
 * @data 2019/11/13
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public User findUserById(String userId) {
        return userMapper.findUserById(userId);
    }

    @Override
    @Transactional
    public String testTransaction() {
        User user = new User();
        user.setUser_name("qqq");
        user.setRegist_mode("1");
        user.setThrid_party_id("1");
        user.setUser_age(10);
        user.setUser_gender(0);
        user.setUser_telphone("12312313212");
        userMapper.insertUser(user);
        roleMapper.delete(1);
        int i = 1/0;
        return "asdasd";
    }
}
