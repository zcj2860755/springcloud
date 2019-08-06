package com.zdzc.dao;

import com.zdzc.core.Mapper;
import com.zdzc.model.TSysDic;

import java.util.List;

public interface TSysDicMapper extends Mapper<TSysDic> {

    List<TSysDic> selectAllDic(TSysDic tSysDic); //查询所有

}