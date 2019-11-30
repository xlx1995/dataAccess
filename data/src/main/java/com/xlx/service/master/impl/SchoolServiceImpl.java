package com.xlx.service.master.impl;

import com.xlx.db.pojo.master.SchoolDo;
import com.xlx.mapper.miaosha.SchoolMapper;
import com.xlx.service.master.SchoolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author xlx
 * @descritption
 * @data 2019/11/18
 */
@Service
@Slf4j
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolMapper schoolMapper;

    @Override
    public List<SchoolDo> query(Map<String, Object> param) {
        List<SchoolDo> schoolDoList = new ArrayList<>();
        try {
            schoolDoList = schoolMapper.query(param);
        }catch (Throwable e){
            log.error("fail to get date ,e{}",e);
            schoolDoList = null;
        }
        return schoolDoList;
    }
}
