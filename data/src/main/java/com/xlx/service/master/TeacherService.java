package com.xlx.service.master;

import com.xlx.db.pojo.master.TeacherDo;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface TeacherService {

    /**
     * 教师DO基本查询
     * @param param
     * @return
     */
    List<TeacherDo> query(Map<String,Object> param);

}
