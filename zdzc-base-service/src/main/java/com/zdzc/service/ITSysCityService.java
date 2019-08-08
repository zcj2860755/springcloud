package com.zdzc.service;

import com.zdzc.model.TSysCity;
import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;

import java.util.List;

/**
 * Author : 李琳青
 * Date : 2019-08-07 18:42
 */
public interface ITSysCityService {

    /**
    * @description：新增
    * @author：李琳青
    * @date：2019-08-07 18:42
    */
    int save(TSysCity tSysCity);

    /**
    * @description：修改
    * @author：李琳青
    * @date：2019-08-07 18:42
    */
    int update(TSysCity tSysCity);

    /**
    * @description：删除
    * @author：李琳青
    * @date：2019-08-07 18:42
    */
    int deleteById(String id);

    /**
    * @description：根据Id获取详情
    * @author：李琳青
    * @date：2019-08-07 18:42
    */
    TSysCity findById(String id);

    /**
    * @description：分页查询
    * @author：李琳青
    * @date：2019-08-07 18:42
    */
    PageList<TSysCity> list(TSysCity tSysCity,BaseRequest baseRequest);

    /**
     * @description：查询某省份下的所有城市
     * @author：李琳青
     * @date：2019-08-07 16:42
     */
    List<TSysCity> selectCityList(Integer provinceId);


}
