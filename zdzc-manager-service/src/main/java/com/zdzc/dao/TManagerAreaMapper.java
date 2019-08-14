package com.zdzc.dao;

import com.zdzc.core.Mapper;
import com.zdzc.model.TManagerArea;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TManagerAreaMapper extends Mapper<TManagerArea> {


    /**
     * @description：   查询所有 + 模糊查询
     * @author：李琳青
     * @date：2019-08-12 18:17
     */
     List<TManagerArea> selectAreaList(TManagerArea area);


     int selectCountByParentId(@Param("parentId") String parentId);


}