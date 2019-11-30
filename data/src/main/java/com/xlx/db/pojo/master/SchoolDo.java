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
public class SchoolDo implements Serializable {

    private static final long serialVersionUID = -5466487312859199610L;
    /**
     * 学校id
     */
    private int schoolId;
    /**
     * 学校姓名
     */
    private String schoolName;
    /**
     * 学校地区
     */
    private String schoolArea;

}
