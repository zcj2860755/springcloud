package com.zdzc.service;

import com.zdzc.model.TSysArea;
import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;

import java.util.List;

/**
 * Author : 李琳青
 * Date : 2019-08-07 19:16
 */
public interface ITSysAreaService {

    /**
    * @description：新增
    * @author：李琳青
    * @date：2019-08-07 19:16
    */
    int save(TSysArea tSysArea);

    /**
    * @description：修改
    * @author：李琳青
    * @date：2019-08-07 19:16
    */
    int update(TSysArea tSysArea);

    /**
    * @description：删除
    * @author：李琳青
    * @date：2019-08-07 19:16
    */
    int deleteById(String id);

    /**
    * @description：根据Id获取详情
    * @author：李琳青
    * @date：2019-08-07 19:16
    */
    TSysArea findById(String id);

    /**
    * @description：分页查询
    * @author：李琳青
    * @date：2019-08-07 19:16
    */
    PageList<TSysArea> list(TSysArea tSysArea,BaseRequest baseRequest);




    /**
     * @description：查询某省城市下的所有区
     * @author：李琳青
     * @date：2019-08-07 16:42
     */
    List<TSysArea> selectAreaList(Integer cityId);



}
