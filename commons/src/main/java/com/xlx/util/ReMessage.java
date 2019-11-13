package com.xlx.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xlx
 * @descritption
 * @data 2019/11/6
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReMessage {

    private int code;
    private String message;
    private Object data;
    private Boolean success;

}
