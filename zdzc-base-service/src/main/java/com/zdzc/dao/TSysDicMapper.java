package com.zdzc.dao;

import com.zdzc.core.Mapper;
import com.zdzc.model.TSysDic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TSysDicMapper extends Mapper<TSysDic> {

    List<TSysDic> selectAllDic(TSysDic tSysDic); //查询所有

    TSysDic selectTSysDicWithCatergory(@Param("id") String id);

}