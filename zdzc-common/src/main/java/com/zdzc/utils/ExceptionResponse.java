package com.zdzc.utils;



import com.zdzc.enums.ExceptionEnum;

import java.io.Serializable;

/**
 * 异常响应类
 */
public class ExceptionResponse implements Serializable
{
    /**
     * 错误码
     */
    private int code;

    /**
     * 错误信息
     */
    private String data;

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getData()
    {
        return data;
    }

    public void setData(String data)
    {
        this.data = data;
    }

    public static ExceptionResponse create(int code, String data)
    {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setCode(code);
        exceptionResponse.setData(data);
        return exceptionResponse;
    }

    public static ExceptionResponse create(ExceptionEnum exceptionInfo)
    {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setCode(exceptionInfo.getCode());
        exceptionResponse.setData(exceptionInfo.getMsg());
        return exceptionResponse;
    }
}
