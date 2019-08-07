package com.zdzc.service;


import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;
import com.zdzc.model.TSysDic;

/**
 * Author : 李琳青
 * Date : 2019-08-06 13:41
 */
public interface ITSysDicService {


    int insert(TSysDic tSysDic);

    int delete(String id);

    int update(TSysDic tSysDic);

    TSysDic findById(String id);


    /**
     * @description：分页查询
     */
    PageList<TSysDic> list(TSysDic tSysDic, BaseRequest baseRequest);


}
