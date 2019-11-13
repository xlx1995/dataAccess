package com.xlx.db.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Auther: 徐林啸
 * @Date: 2019/7/29 16:17
 * @Description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -2221919180575796730L;
    private Integer user_id;
    private String user_name;
    private Integer user_gender;
    private Integer user_age;
    private String user_telphone;
    private String regist_mode;
    private String thrid_party_id;





}
