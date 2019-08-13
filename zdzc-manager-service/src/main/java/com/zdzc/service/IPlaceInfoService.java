package com.zdzc.service;

import com.zdzc.model.PlaceInfo;
import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;

/**
 * Author : 李琳青
 * Date : 2019-08-12 19:47
 */
public interface IPlaceInfoService {

    /**
    * @description：新增
    * @author：李琳青
    * @date：2019-08-12 19:47
    */
    int save(PlaceInfo placeInfo);

    /**
    * @description：修改
    * @author：李琳青
    * @date：2019-08-12 19:47
    */
    int update(PlaceInfo placeInfo);


    /**
     * @description：冻结/解冻
     * @author：李琳青
     * @date：2019-08-12 19:47
     */
    int updateFreezeStatus(Integer id);

    /**
    * @description：删除
    * @author：李琳青
    * @date：2019-08-12 19:47
    */
    int deleteById(String id);

    /**
    * @description：根据Id获取详情
    * @author：李琳青
    * @date：2019-08-12 19:47
    */
    PlaceInfo findById(String id);

    /**
    * @description：分页查询
    * @author：李琳青
    * @date：2019-08-12 19:47
    */
    PageList<PlaceInfo> pageList(PlaceInfo placeInfo,BaseRequest baseRequest);

}
