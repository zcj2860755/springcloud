package com.zdzc.service;

import com.zdzc.model.TManagerUnit;
import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;

/**
 * Author : 李琳青
 * Date : 2019-08-13 16:18
 */
public interface ITManagerUnitService {

    /**
    * @description：新增
    * @author：李琳青
    * @date：2019-08-13 16:18
    */
    int save(TManagerUnit tManagerUnit);

    /**
    * @description：修改
    * @author：李琳青
    * @date：2019-08-13 16:18
    */
    int update(TManagerUnit tManagerUnit);

    /**
    * @description：删除
    * @author：李琳青
    * @date：2019-08-13 16:18
    */
    int deleteById(String id);

    /**
     * @description：根据Id获取详情
     * @author：李琳青
     * @date：2019-08-13 16:18
     */
    TManagerUnit findById(String id);

    /**
    * @description：分页查询
    * @author：李琳青
    * @date：2019-08-13 16:18
    */
    PageList<TManagerUnit> pageList(TManagerUnit tManagerUnit,Integer pageNo,Integer pageSize);

}
