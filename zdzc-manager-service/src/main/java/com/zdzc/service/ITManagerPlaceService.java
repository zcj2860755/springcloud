package com.zdzc.service;

import com.zdzc.model.TManagerPlace;
import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;

/**
 * Author : 李琳青
 * Date : 2019-08-13 16:17
 */
public interface ITManagerPlaceService {

    /**
    * @description：新增
    * @author：李琳青
    * @date：2019-08-13 16:17
    */
    int save(TManagerPlace tManagerPlace);

    /**
    * @description：修改
    * @author：李琳青
    * @date：2019-08-13 16:17
    */
    int update(TManagerPlace tManagerPlace);

    /**
     * @description：冻结/解冻
     * @author：李琳青
     * @date：2019-08-12 19:47
     */
    int updateFreezeStatus(Integer id);


    /**
    * @description：删除
    * @author：李琳青
    * @date：2019-08-13 16:17
    */
    int deleteById(String id);

    /**
    * @description：根据Id获取详情
    * @author：李琳青
    * @date：2019-08-13 16:17
    */
    TManagerPlace findById(String id);

    /**
    * @description：分页查询
    * @author：李琳青
    * @date：2019-08-13 16:17
    */
    PageList<TManagerPlace> pageList(TManagerPlace tManagerPlace,BaseRequest baseRequest);

}
