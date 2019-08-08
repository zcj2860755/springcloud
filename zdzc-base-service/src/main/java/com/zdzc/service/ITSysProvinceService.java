package com.zdzc.service;

import com.zdzc.model.TSysArea;
import com.zdzc.model.TSysCity;
import com.zdzc.model.TSysProvince;
import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;

import java.util.List;

/**
 * Author : 李琳青
 * Date : 2019-08-07 16:42
 */
public interface ITSysProvinceService {

    /**
    * @description：新增
    * @author：李琳青
    * @date：2019-08-07 16:42
    */
    int save(TSysProvince tSysProvince);

    /**
    * @description：修改
    * @author：李琳青
    * @date：2019-08-07 16:42
    */
    int update(TSysProvince tSysProvince);

    /**
    * @description：删除
    * @author：李琳青
    * @date：2019-08-07 16:42
    */
    int deleteById(String id);

    /**
    * @description：根据Id获取详情
    * @author：李琳青
    * @date：2019-08-07 16:42
    */
    TSysProvince findById(String id);

    /**
    * @description：分页查询
    * @author：李琳青
    * @date：2019-08-07 16:42
    */
    PageList<TSysProvince> list(TSysProvince tSysProvince,BaseRequest baseRequest);

    /**
     * @description：查询所有的省份
     * @author：李琳青
     * @date：2019-08-07 16:42
     */
    List<TSysProvince> provinceList();


    /**
     * @description：查询某省份下的所有城市
     * @author：李琳青
     * @date：2019-08-07 16:42
     */
    List<TSysCity> selectCityList(Integer provinceId);

    /**
     * @description：查询某省城市下的所有区
     * @author：李琳青
     * @date：2019-08-07 16:42
     */
    List<TSysArea> selectAreaList(Integer cityId);


}
