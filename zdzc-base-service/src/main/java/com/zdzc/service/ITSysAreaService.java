package com.zdzc.service;

import com.zdzc.model.TSysArea;

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
     * @description：城市list
     * @author：李琳青
     * @date：2019-08-09 11:06
     */
    List<TSysArea> selectProvinceCityAreaList(TSysArea tSysArea);





}
