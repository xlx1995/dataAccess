package com.xlx.util;

/**
 * @author xlx
 * @descritption
 * @data 2019/11/21
 */
public class EmptyUtil {

    public static boolean isEmpty(String str){
        if("".equals(str) || null == str){
            return true;
        }
        return false;
    }

    public static boolean isEmpty(Integer num){
        if(null == num || "".equals(num)){
            return true;
        }
        return false;
    }


}
