package com.zdzc.service;

import com.zdzc.model.TSysDicCategory;
import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;

/**
 * Author : 李琳青
 * Date : 2019-08-06 19:08
 */
public interface ITSysDicCategoryService {

    /**
    * @description：新增
    * @author：李琳青
    * @date：2019-08-06 19:08
    */
    int save(TSysDicCategory tSysDicCategory);

    /**
    * @description：修改
    * @author：李琳青
    * @date：2019-08-06 19:08
    */
    int update(TSysDicCategory tSysDicCategory);

    /**
    * @description：删除
    * @author：李琳青
    * @date：2019-08-06 19:08
    */
    int deleteById(String id);

    /**
     * @description：查询一个
     * @author：李琳青
     * @date：2019-08-06 19:08
     */
    TSysDicCategory findById(String id);

    /**
    * @description：分页查询
    * @author：李琳青
    * @date：2019-08-06 19:08
    */
    PageList<TSysDicCategory> list(TSysDicCategory tSysDicCategory,Integer pageNo,Integer pageSize);

}
