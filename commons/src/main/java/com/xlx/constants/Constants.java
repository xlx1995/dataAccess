package com.xlx.constants;

/**
 * @author xlx
 * @descritption
 * @data 2019/11/9
 */
public class Constants {

    /**
     *
     */
    public enum Code {
        /**
         * 成功
         */
        success(1001, "success"),
        /**
         * 失败
         */
        error(1002, "fail");

        Code(int code, String message) {
            this.code = code;
            this.message = message;
        }

        /**
         * 返回码
         */
        int code;
        /**
         * 返回信息
         */
        String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }

}
