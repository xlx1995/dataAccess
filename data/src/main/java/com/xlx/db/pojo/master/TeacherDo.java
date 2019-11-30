package com.xlx.db.pojo.master;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

/**
 * @author xlx
 * @descritption
 * @data 2019/11/18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDo implements Serializable {

    private static final long serialVersionUID = 8362487377939027183L;
    /**
     * 教师id
     */
    private int teacherId;
    /**
     * 教师姓名
     */
    private String teacherName;
    /**
     * 教师年龄
     */
    private int teacherAge;
    /**
     * 教师手机
     */
    private String teacherPhone;
    /**
     * 学校id
     */
    private int schoolId;

    /**
     * 学校姓名
     */
    private String schoolName;

    /**
     * 学生集合
     */
    private List<StudentDo> studentDoList;



}
