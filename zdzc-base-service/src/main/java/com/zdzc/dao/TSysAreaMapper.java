package com.zdzc.dao;

import com.zdzc.core.Mapper;
import com.zdzc.model.TSysArea;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TSysAreaMapper extends Mapper<TSysArea> {


    List<TSysArea> selectProvinceList();

    List<TSysArea> selectCityList(@Param("provinceId") Integer provinceId);

    List<TSysArea> selectAreaList(@Param("cityId") Integer provinceId);

    List<TSysArea> selectTownList(@Param("areaId") Integer areaId);

    int deleteByParentIdAndLevel(@Param("parentId") Integer parentId,@Param("level") Integer level);

    List<TSysArea> selectAreaListByParentId(@Param("parentId") Integer parentId);

    int deleteByIds(@Param("ids") String ids);





}