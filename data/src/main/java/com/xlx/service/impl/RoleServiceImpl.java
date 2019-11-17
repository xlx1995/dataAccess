package com.xlx.service.impl;

import com.xlx.db.pojo.Role;
import com.xlx.mapper.slavel.RoleMapper;
import com.xlx.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xlx
 * @descritption
 * @data 2019/11/17
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> listRole() {
        return roleMapper.listRole();
    }
}
