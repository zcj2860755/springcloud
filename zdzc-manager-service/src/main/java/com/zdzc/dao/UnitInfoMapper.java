package com.zdzc.dao;

import com.zdzc.core.Mapper;
import com.zdzc.model.UnitInfo;

import java.util.List;

public interface UnitInfoMapper extends Mapper<UnitInfo> {

    /**
     * @description：   查询所有 + 模糊查询
     * @author：李琳青
     * @date：2019-08-12 18:17
     */
    List<UnitInfo> selectUnitList(UnitInfo unitInfo);

}