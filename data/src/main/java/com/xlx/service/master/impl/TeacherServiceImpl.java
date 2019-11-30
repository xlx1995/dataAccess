package com.xlx.service.master.impl;

import com.alibaba.fastjson.JSON;
import com.xlx.db.pojo.master.TeacherDo;
import com.xlx.mapper.miaosha.TeacherMapper;
import com.xlx.service.master.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author xlx
 * @descritption
 * @data 2019/11/20
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherMapper teacherMapper;

    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    public TeacherServiceImpl(TeacherMapper teacherMapper, RedisTemplate<String,String> redisTemplate) {
        this.teacherMapper = teacherMapper;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public List<TeacherDo> query(Map<String, Object> param) {
        List<TeacherDo> teacherDoList = teacherMapper.query(param);
        redisTemplate.opsForValue().set("userList",JSON.toJSONString(teacherDoList));
        String userList = redisTemplate.opsForValue().get("userList");
        List<TeacherDo> teacherDoList1 = JSON.parseArray(userList, TeacherDo.class);
        return teacherDoList;
    }
}
