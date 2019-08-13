package com.zdzc.dao;

import com.zdzc.core.Mapper;
import com.zdzc.model.PlaceInfo;
import com.zdzc.model.TSysDicCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlaceInfoMapper extends Mapper<PlaceInfo> {

    /**
     * @description：   查询所有 + 模糊查询
     * @author：李琳青
     * @date：2019-08-12 18:17
     */
    List<PlaceInfo> selectPlaceInfoList(PlaceInfo placeInfo);




}