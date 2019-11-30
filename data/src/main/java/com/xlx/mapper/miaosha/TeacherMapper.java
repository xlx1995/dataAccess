package com.xlx.mapper.miaosha;

import com.xlx.db.pojo.master.TeacherDo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TeacherMapper {

    List<TeacherDo> query(Map<String,Object> param);


}
