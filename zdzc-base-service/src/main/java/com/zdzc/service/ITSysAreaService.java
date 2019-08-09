package com.zdzc.service;

import com.zdzc.model.TSysArea;
import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;

import java.util.List;

/**
 * Author : 李琳青
 * Date : 2019-08-09 11:06
 */
public interface ITSysAreaService {

    /**
    * @description：新增
    * @author：李琳青
    * @date：2019-08-09 11:06
    */
    int save(TSysArea tSysArea);

    /**
    * @description：修改
    * @author：李琳青
    * @date：2019-08-09 11:06
    */
    int update(TSysArea tSysArea);

    /**
    * @description：删除
    * @author：李琳青
    * @date：2019-08-09 11:06
    */
    int deleteById(String id);

    /**
    * @description：根据Id获取详情
    * @author：李琳青
    * @date：2019-08-09 11:06
    */
    TSysArea findById(String id);

    /**
    * @description：分页查询
    * @author：李琳青
    * @date：2019-08-09 11:06
    */
    PageList<TSysArea> pageList(TSysArea tSysArea,BaseRequest baseRequest);

    /**
     * @description：省份list
     * @author：李琳青
     * @date：2019-08-09 11:06
     */
    List<TSysArea> selectProvinceList();

     /**
     * @description：城市list
     * @author：李琳青
     * @date：2019-08-09 11:06
     */
    List<TSysArea> selectCityList(Integer provinceId);

     /**
     * @description：区域list
     * @author：李琳青
     * @date：2019-08-09 11:06
     */
    List<TSysArea> selectAreaList(Integer cityId);

     /**
     * @description：街道、城镇list
     * @author：李琳青
     * @date：2019-08-09 11:06
     */
    List<TSysArea> selectTownList(Integer areaId);




}
