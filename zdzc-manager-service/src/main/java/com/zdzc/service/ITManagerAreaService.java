package com.zdzc.service;

import com.zdzc.model.TManagerArea;
import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;

/**
 * Author : 李琳青
 * Date : 2019-08-13 17:48
 */
public interface ITManagerAreaService {

    /**
    * @description：新增
    * @author：李琳青
    * @date：2019-08-13 17:48
    */
    int save(TManagerArea tManagerArea);

    /**
    * @description：修改
    * @author：李琳青
    * @date：2019-08-13 17:48
    */
    int update(TManagerArea tManagerArea);

    /**
    * @description：删除
    * @author：李琳青
    * @date：2019-08-13 17:48
    */
    int deleteById(String id);

    /**
    * @description：根据Id获取详情
    * @author：李琳青
    * @date：2019-08-13 17:48
    */
    TManagerArea findById(String id);

    /**
    * @description：分页查询
    * @author：李琳青
    * @date：2019-08-13 17:48
    */
    PageList<TManagerArea> pageList(TManagerArea tManagerArea,BaseRequest baseRequest);

}
