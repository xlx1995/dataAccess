package com.xlx.db.pojo;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author xlx
 * @descritption
 * @data 2019/11/13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
    private static final long serialVersionUID = -2221919180575796730L;
    @Protobuf(description = "用户id",fieldType = FieldType.INT32, required = false, order = 1)
    private int id;
    @Protobuf(description = "姓名",fieldType = FieldType.STRING, required = false, order = 2)
    private String name;

}
