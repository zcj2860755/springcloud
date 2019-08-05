package com.zdzc.service;

import com.zdzc.model.TSysDic;

import java.util.List;

/**
 * Created by zcj on 2019/08/01.
 */
public interface ITSysDicService {

    List<TSysDic> findTest();

    int  add(TSysDic test);

}
