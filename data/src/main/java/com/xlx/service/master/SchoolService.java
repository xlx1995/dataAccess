package com.xlx.service.master;

import com.xlx.db.pojo.master.SchoolDo;

import java.util.List;
import java.util.Map;

public interface SchoolService {

    /**
     * 查询接口
     * @param param
     * @return
     */
    List<SchoolDo> query(Map<String,Object> param);

}
