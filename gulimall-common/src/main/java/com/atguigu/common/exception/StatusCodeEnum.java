package com.atguigu.common.exception;

public enum  StatusCodeEnum {
    UNKNOWN_EXCEPTION (10000,"系统未知异常"),
    VALID_EXCEPTION (10001,"参数格式校验异常");

    private int code;
    private String msg;

    StatusCodeEnum(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
