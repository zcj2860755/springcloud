package com.zdzc.dao;

import com.zdzc.core.Mapper;
import com.zdzc.model.TSysDicCategory;

import java.util.List;

public interface TSysDicCategoryMapper extends Mapper<TSysDicCategory> {


    /**
     * @description：   查询所有 + 模糊查询
     * @author：李琳青
     * @date：2019-08-08 13:17
     */
    List<TSysDicCategory> selectDicCategoryList(TSysDicCategory category);


    /**
     * @description：   by dic_key
     * @author：李琳青
     * @date：2019-08-08 13:17
     */
    List<TSysDicCategory> selectListByDicKey(TSysDicCategory category);




}