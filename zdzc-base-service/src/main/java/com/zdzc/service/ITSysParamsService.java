package com.zdzc.service;

import com.zdzc.model.TSysParams;
import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;

/**
 * Author : zhuqilong
 * Date : 2019-08-13 14:02
 */
public interface ITSysParamsService {

    /**
    * @description：新增
    * @author：zhuqilong
    * @date：2019-08-13 14:02
    */
    int save(TSysParams tSysParams);

    /**
    * @description：修改
    * @author：zhuqilong
    * @date：2019-08-13 14:02
    */
    int update(TSysParams tSysParams);

    /**
    * @description：删除
    * @author：zhuqilong
    * @date：2019-08-13 14:02
    */
    int deleteById(String id);

    /**
    * @description：根据Id获取详情
    * @author：zhuqilong
    * @date：2019-08-13 14:02
    */
    TSysParams findById(String id);

    /**
    * @description：分页查询
    * @author：zhuqilong
    * @date：2019-08-13 14:02
    */
    PageList<TSysParams> pageList(TSysParams tSysParams,Integer pageNo,Integer pageSize);

}
