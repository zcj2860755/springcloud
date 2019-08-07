package com.zdzc.service;


import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;
import com.zdzc.model.TSysRole;

import java.util.List;

/**
 * @Author  zcj
 * @Description  用户角色接口
 * @Date 9:56 2019/8/7
 **/
public interface ITSysRoleService {
    /**
     * @Author  zcj
     * @Description //根据条件统计数据
     * @Date 9:56 2019/8/7
     * @Param [tSysRole]
     * @return int
     **/
    int countByExample(TSysRole tSysRole);
    /**
     * @Author  zcj
     * @Description //根据条件删除角色
     * @Date 9:59 2019/8/7
     * @Param [tSysRole]
     * @return int
     **/
    int deleteByExample(TSysRole tSysRole);

    /**
     * @Author  zcj
     * @Description //根据主键id删除角色
     * @Date 9:59 2019/8/7
     * @Param [id]
     * @return int
     **/
    int deleteByPrimaryKey(String id);
    /**
     * @Author  zcj
     * @Description //新增角色，需要全部数据
     * @Date 10:00 2019/8/7
     * @Param [tSysRole]
     * @return int
     **/
    int insert(TSysRole tSysRole);

    /**
     * @Author  zcj
     * @Description  新增角色，部分属性新增
     * @Date 10:01 2019/8/7
     * @Param [tSysRole]
     * @return int
     **/
    int insertSelective(TSysRole tSysRole);

    /**
     * @Author  zcj
     * @Description // 查询角色接口
     * @Date 10:02 2019/8/7
     * @Param [tSysRole]
     * @return java.util.List<com.zdzc.model.TSysRole>
     **/
    List<TSysRole> selectByExample(TSysRole tSysRole);

   /**
    * @Author  zcj
    * @Description //分页查询
    * @Date 10:03 2019/8/7
    * @Param [Params, baseRequest]
    * @return com.zdzc.common.PageList<com.zdzc.model.TSysRole>
    **/
    PageList<TSysRole> selectParamsList(TSysRole Params, BaseRequest baseRequest);

    /**
     * @Author  zcj
     * @Description  根据主键id 获取角色详情
     * @Date 10:03 2019/8/7
     * @Param [id]
     * @return com.zdzc.model.TSysRole
     **/
    TSysRole selectByPrimaryKey(String id);
    /**
     * @Author  zcj
     * @Description //根据属性部分更新数据
     * @Date 10:04 2019/8/7
     * @Param [Params]
     * @return int
     **/
    int updateByExampleSelective(TSysRole Params);

    int updateByExample(TSysRole Params, TSysRole ParamsChange);
    /**
     * @Author  zcj
     * @Description  根据主键部分更新数据
     * @Date 10:06 2019/8/7
     * @Param [Params]
     * @return int
     **/
    int updateByPrimaryKeySelective(TSysRole Params);

    int updateByPrimaryKey(TSysRole Params);
    /**
     * @Author  zcj
     * @Description // 查询所有角色
     * @Date 10:07 2019/8/7
     * @Param []
     * @return java.util.List<com.zdzc.model.TSysRole>
     **/
    List<TSysRole> selectAll();

}
