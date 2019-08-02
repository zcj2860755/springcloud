package com.zdzc.baseModel;

import java.io.Serializable;


/**
 * 请求成功响应类
 */
public class BaseRespsonse implements Serializable {
    /**
     * 返回状态码 0-代表成功，其余代表失败
     */
    private int statusCode;

    /**
     * 返回数据
     */
    private Object data;


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

    public static BaseRespsonse success(Object data){
        BaseRespsonse br = new BaseRespsonse();
        br.setData(data);
        return br;
    }

    public static BaseRespsonse error(ExceptionResponse exception){
        BaseRespsonse br = new BaseRespsonse();
        br.setStatusCode(exception.getCode());
        br.setData(exception.getData());
        return br;
    }


    public static BaseRespsonse successOfMap(String data){
        BaseRespsonse br = new BaseRespsonse();
        br.setData(data);
        return br;
    }
}
