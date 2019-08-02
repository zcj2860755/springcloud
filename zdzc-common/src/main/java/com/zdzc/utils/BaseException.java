package com.zdzc.utils;


import com.zdzc.enums.ExceptionEnum;

/**
 * 自定义异常
 */
public class BaseException extends RuntimeException{
    /**
     * 异常枚举类
     */
    private ExceptionEnum exceptionEnum;

    private int code;

    private String data;

    public BaseException(ExceptionEnum exceptionEnum){
        this.exceptionEnum=exceptionEnum;
    }

    public BaseException(int code ,String data){
        this.code=code;
        this.data=data;
    }

    public ExceptionEnum getExceptionEnum() {
        return exceptionEnum;
    }

    public void setExceptionEnum(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
