package com.zdzc.dao;

import com.zdzc.core.Mapper;
import com.zdzc.model.TSysProvince;

import java.util.List;

public interface TSysProvinceMapper extends Mapper<TSysProvince> {

    List<TSysProvince> selectProvinceList();


}