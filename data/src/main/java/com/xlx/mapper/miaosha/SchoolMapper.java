package com.xlx.mapper.miaosha;

import com.xlx.db.pojo.master.SchoolDo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author xlx
 */
@Repository
public interface SchoolMapper {

    /**
     * 查询学校接口
     * @param param
     * @return
     */
    List<SchoolDo> query(Map<String,Object> param);

}
