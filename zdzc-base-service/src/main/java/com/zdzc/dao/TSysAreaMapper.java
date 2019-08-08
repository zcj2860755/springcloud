package com.zdzc.dao;

import com.zdzc.core.Mapper;
import com.zdzc.model.TSysArea;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TSysAreaMapper extends Mapper<TSysArea> {

    List<TSysArea> selectAreaList(@Param("cityId") Integer cityId);



}