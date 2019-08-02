package com.zdzc.baseModel;

import com.zdzc.enums.ExceptionEnum;

/**
 * 自定义异常
 */
public class BaseException extends RuntimeException{

    private int code;

    private String data;

    public BaseException(ExceptionEnum exceptionEnum){
        super(exceptionEnum.getCode()+":"+exceptionEnum.getMsg());
        this.code=exceptionEnum.getCode();
        this.data=exceptionEnum.getMsg();
    }

    public BaseException(int code , String data){
        super(code+":"+data);
        this.code=code;
        this.data=data;
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
