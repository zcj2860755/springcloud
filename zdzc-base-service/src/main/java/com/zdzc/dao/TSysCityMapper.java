package com.zdzc.dao;

import com.zdzc.core.Mapper;
import com.zdzc.model.TSysCity;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TSysCityMapper extends Mapper<TSysCity> {

    List<TSysCity> selectCityList(@Param("provinceId") Integer provinceId);


}