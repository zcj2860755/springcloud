package com.zdzc.common;



import com.zdzc.utils.ExceptionResponse;

import java.io.Serializable;

/**
 * 请求成功响应类
 */
public class BaseRespsonse implements Serializable {
    /**
     * 返回状态码
     */
    private int statusCode;

    /**
     * 返回数据
     */
    private Object data;

    /**
     * true接口成功，false接口失败
     */
    public Boolean success;

    /**
     * 请求成功或失败的提示信息
     */
    public String message;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static BaseRespsonse success(Object data){
        BaseRespsonse br = new BaseRespsonse();
        br.setData(data);
        br.setSuccess(true);
        br.setMessage("请求成功");
        return br;
    }

    public static BaseRespsonse error(ExceptionResponse exception){
        BaseRespsonse br = new BaseRespsonse();
        br.setSuccess(false);
        br.setMessage(exception.getData());
        br.setStatusCode(exception.getCode());
        return br;
    }
}
