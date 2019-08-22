package com.zdzc.service;


import com.zdzc.common.PageList;
import com.zdzc.model.TSysDic;

import java.util.List;

/**
 * Author : 李琳青
 * Date : 2019-08-06 13:41
 */
public interface ITSysDicService {


    int insert(TSysDic tSysDic);

    int delete(String id);

    int update(TSysDic tSysDic);

    /**
     * @description：查询一个
     * @author：李琳青
     * @date：2019-08-06 19:08
     */
    TSysDic findById(String id);


    /**
     * @description：分页查询
     */
    PageList<TSysDic> list(TSysDic tSysDic,Integer pageNo,Integer pageSize);

    /**
     * @Author  zhuqilong
     * @Description 通过字典类别Key查询，子类字典
     * @Date 15:56 2019/8/21
     * @Param
     * @return
    */
    List<TSysDic> getDicByDicKey(String DicKey);
}
