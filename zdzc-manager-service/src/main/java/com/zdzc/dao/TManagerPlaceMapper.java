package com.zdzc.dao;

import com.zdzc.core.Mapper;
import com.zdzc.model.TManagerPlace;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TManagerPlaceMapper extends Mapper<TManagerPlace> {

    /**
     * @description：   查询所有 + 模糊查询
     * @author：李琳青
     * @date：2019-08-12 18:17
     */
    List<TManagerPlace> selectPlaceList(TManagerPlace place);


    /**
     * @description：   by id
     * @author：李琳青
     * @date：2019-08-12 18:17
     */
    TManagerPlace selectPalceById(@Param("id")String id);


}