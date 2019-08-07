package com.zdzc.service;


import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;
import com.zdzc.model.TSysAccount;

import java.util.List;
import java.util.Map;

/**
 * @Author  zcj
 * @Description // 用户相关接口信息
 * @Date 10:45 2019/8/7

 **/

public interface ITSysAccountService{

    /**
     * @Author  zcj
     * @Description 新增用户信息
     * @Date 10:47 2019/8/7
     * @Param [tSysAccount]
     * @return int
     **/
    int insert(TSysAccount tSysAccount);


    /**
     * @Author  zcj
     * @Description //修改账户信息
     * @Date 10:47 2019/8/7
     * @Param [tSysAccount]
     * @return int
     **/
    int updateByPrimaryKeySelective(TSysAccount tSysAccount);

    /**
     * @Author  zcj
     * @Description //新增用户信息 ，部分属性，常用
     * @Date 10:48 2019/8/7
     * @Param [tSysAccount]
     * @return int
     **/
    int insertSelective(TSysAccount tSysAccount);

    /**
     * @Author  zcj
     * @Description //根据主键删除用户信息
     * @Date 10:49 2019/8/7
     * @Param [tSysAccount]
     * @return int
     **/
    int deleteByPrimaryKey(TSysAccount tSysAccount);

    /**
     * @Author  zcj
     * @Description 分页查询用户相关信息
     * @Date 10:49 2019/8/7
     * @Param [tSysAccount, baseRequest]
     * @return com.zdzc.common.PageList<com.zdzc.model.TSysAccount>
     **/
    PageList<TSysAccount> selectParamsList(TSysAccount tSysAccount, BaseRequest baseRequest);

    /**
     * @Author  zcj
     * @Description 根据主键id 获取用户信息详情
     * @Date 10:50 2019/8/7
     * @Param [id]
     * @return com.zdzc.model.TSysAccount
     **/
    TSysAccount selectByPrimaryKey(String id);
    /**
     * @Author  zcj
     * @Description //用户登录信息接口，返回用户相关信息
     * @Date 10:51 2019/8/7
     * @Param [tSysAccount]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    Map<String,Object> login(TSysAccount tSysAccount);
    /**
     * @Author  zcj
     * @Description //用户分页查询接口
     * @Date 10:51 2019/8/7
     * @Param [tSysAccount, baseRequest]
     * @return com.zdzc.common.PageList<com.zdzc.model.TSysAccount>
     **/
    PageList<TSysAccount> selectAccountList(TSysAccount tSysAccount, BaseRequest baseRequest);

    List<TSysAccount> selectAccountList(TSysAccount tSysAccount);


    TSysAccount getAccountInfoByImei(String imei);


    List<TSysAccount> selectAccountAbleList(TSysAccount tSysAccount);

    int updateByPrimaryKey(TSysAccount tSysAccount);

}
