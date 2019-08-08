package com.zdzc.service;


import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;
import com.zdzc.model.TSysAuthority;

import java.util.List;

/**
 * @Author  zcj
 * @Description // 权限菜单相关
 * @Date 10:28 2019/8/7
 **/
public interface ITSysAuthorityService {

    /**
     * @Author  zcj
     * @Description //根据主键删除该菜单/按钮
     * @Date 10:30 2019/8/7
     * @Param [id]
     * @return int
     **/
    int deleteByPrimaryKey(String id);

    /**
     * @Author  zcj
     * @Description // 新增菜单/按钮 部分属性 ---常用
     * @Date 10:32 2019/8/7
     * @Param [tSysAuthority]
     * @return int
     **/
    int insertSelective(TSysAuthority tSysAuthority);

    /**
     * @Author  zcj
     * @Description 获取所有权限菜单
     * @Date 10:34 2019/8/7
     * @Param []
     * @return java.util.List<com.zdzc.model.TSysAuthority>
     **/
    List<TSysAuthority> selectByExample();


    /**
     * @Author  zcj
     * @Description 系统权限分页查询
     * @Date 10:34 2019/8/7
     * @Param [tSysAuthority, baseRequest]
     * @return com.zdzc.common.PageList<com.zdzc.model.TSysAuthority>
     **/
    PageList<TSysAuthority> selectParamsList(TSysAuthority tSysAuthority);

    /**
     * @Author  zcj
     * @Description //根据主键id  获取菜单按钮详情
     * @Date 10:34 2019/8/7
     * @Param [id]
     * @return com.zdzc.model.TSysAuthority
     **/
    TSysAuthority selectByPrimaryKey(String id);

    /**
     * @Author  zcj
     * @Description // 更新权限资源
     * @Date 10:35 2019/8/7
     * @Param [tSysAuthority]
     * @return int
     **/
    int updateByPrimaryKeySelective(TSysAuthority tSysAuthority);
    /**
     * @Author  zcj
     * @Description //根据ids 查询多个菜单/按钮 信息
     * @Date 10:36 2019/8/7
     * @Param [tSysAuthority]
     * @return java.util.List<com.zdzc.model.TSysAuthority>
     **/
    List<TSysAuthority> selectListByIds(TSysAuthority tSysAuthority);

    /**
     * @Author  zcj
     * @Description 获取所有权限列表
     * @Date 10:37 2019/8/7
     * @Param [tSysAuthority, baseRequest]
     * @return com.zdzc.common.PageList<com.zdzc.model.TSysAuthority>
     **/
    PageList<TSysAuthority> getAllAuthList(TSysAuthority tSysAuthority);

    /**
     * @Author  zcj
     * @Description //获取菜单或者按钮
     * @Date 10:37 2019/8/7
     * @Param [tSysAuthority]
     * @return java.util.List<com.zdzc.model.TSysAuthority>
     **/
    List<TSysAuthority> existAuthSign(TSysAuthority tSysAuthority);

    /**
     * @Author  zcj
     * @Description //获取默认菜单
     * @Date 10:38 2019/8/7
     * @Param [tSysAuthority]
     * @return java.util.List<com.zdzc.model.TSysAuthority>
     **/
    List<TSysAuthority> defaultAuth(TSysAuthority tSysAuthority);
}
