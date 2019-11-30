package com.xlx.config;

import com.xlx.db.pojo.master.StudentDo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xlx
 * @descritption
 * @data 2019/11/23
 */
@ComponentScan("com.xlx.iocstudy")
public class AppConfig {
    @Bean(name = "student")
    public StudentDo getStudentDo(){
        StudentDo studentDo = new StudentDo();
        studentDo.setStudentAge(13);
        studentDo.setStudentId(1);
        studentDo.setStudentName("xlx");
        studentDo.setTeacherId(2);
        return studentDo;
    }

    @Bean(name = "student2")
    public StudentDo getStudentDo2(){
        StudentDo studentDo = new StudentDo();
        studentDo.setStudentAge(22);
        studentDo.setStudentId(3);
        studentDo.setStudentName("qqq");
        studentDo.setTeacherId(2);
        return studentDo;
    }
}
