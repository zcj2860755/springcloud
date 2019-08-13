package com.zdzc.service;

import com.zdzc.model.UnitInfo;
import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;

/**
 * Author : 李琳青
 * Date : 2019-08-13 10:21
 */
public interface IUnitInfoService {

    /**
    * @description：新增
    * @author：李琳青
    * @date：2019-08-13 10:21
    */
    int save(UnitInfo unitInfo);

    /**
    * @description：修改
    * @author：李琳青
    * @date：2019-08-13 10:21
    */
    int update(UnitInfo unitInfo);

    /**
    * @description：删除
    * @author：李琳青
    * @date：2019-08-13 10:21
    */
    int deleteById(String id);

    /**
    * @description：根据Id获取详情
    * @author：李琳青
    * @date：2019-08-13 10:21
    */
    UnitInfo findById(String id);

    /**
    * @description：分页查询
    * @author：李琳青
    * @date：2019-08-13 10:21
    */
    PageList<UnitInfo> pageList(UnitInfo unitInfo,BaseRequest baseRequest);

}
