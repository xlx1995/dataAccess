package com.xlx.db.pojo.master;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author xlx
 * @descritption
 * @data 2019/11/18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDo implements Serializable {

    private static final long serialVersionUID = -1732506967907657956L;
    /**
     * 学生id
     */
    private int studentId;
    /**
     * 学生姓名
     */
    private String studentName;
    /**
     * 学生年龄
     */
    private int studentAge;
    /**
     * 教师id
     */
    private int teacherId;

}
