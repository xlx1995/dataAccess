package com.xlx.controller.master.teacher;

import com.xlx.db.pojo.master.TeacherDo;
import com.xlx.service.master.TeacherService;
import com.xlx.util.EmptyUtil;
import com.xlx.util.ReMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xlx
 * @descritption
 * @data 2019/11/21
 */
@RestController
@RequestMapping("/teacherapi")
@Slf4j
@Api(tags = "教师接口")
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping(value = {"/teacher/{teacherId}","/teacher"})
    @ApiOperation(value = "教师查询接口", notes = "根据教师id查询教师接口", httpMethod = "GET")
    public ReMessage getTeacher(@PathVariable(required = false,value = "teacherId") String teacherId){
        ReMessage reMessage = new ReMessage();
        Map<String,Object> param = new HashMap<>(3);
        try{
            if(!EmptyUtil.isEmpty(teacherId)){
                param.put("teacherId",teacherId);
            }
            List<TeacherDo> teacherDoList = teacherService.query(param);
            reMessage.setSuccess(true);
            reMessage.setData(teacherDoList);
        }catch (Throwable e){
            log.error("fail to get date , e{}",e);
            reMessage.setSuccess(false);
        }
        return reMessage;
    }



}
