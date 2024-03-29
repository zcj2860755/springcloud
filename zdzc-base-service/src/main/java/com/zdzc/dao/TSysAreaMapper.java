package com.zdzc.dao;

import com.zdzc.core.Mapper;
import com.zdzc.model.TSysArea;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TSysAreaMapper extends Mapper<TSysArea> {


    /**
     * @description：   查询省份
     * @author：李琳青
     * @date：2019-08-08 13:17
     */
    List<TSysArea> selectProvinceList();

    /**
     * @description：   根据parentId查询子类集合
     * @author：李琳青
     * @date：2019-08-08 13:17
     */
    List<TSysArea> selectAreaListByParentId(@Param("parentId") Integer parentId);

    /**
     * @description：   根据parentId查询count
     * @author：李琳青
     * @date：2019-08-08 13:17
     */
    int selectCountByParentId(@Param("parentId") Integer parentId);




}