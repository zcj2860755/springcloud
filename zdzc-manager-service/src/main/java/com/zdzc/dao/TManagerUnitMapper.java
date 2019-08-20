package com.zdzc.dao;

import com.zdzc.core.Mapper;
import com.zdzc.model.TManagerUnit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TManagerUnitMapper extends Mapper<TManagerUnit> {

    /**
     * @description：   查询所有 + 模糊查询
     * @author：李琳青
     * @date：2019-08-12 18:17
     */
    List<TManagerUnit> selectUnitList(TManagerUnit unit);


    /**
     * @description：   by id
     * @author：李琳青
     * @date：2019-08-12 18:17
     */
    TManagerUnit selectUnitById(@Param("id")String id);



}