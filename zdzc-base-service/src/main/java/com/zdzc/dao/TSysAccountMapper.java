package com.zdzc.dao;


import com.zdzc.core.Mapper;
import com.zdzc.model.TSysAccount;

import java.util.List;

public interface TSysAccountMapper extends Mapper<TSysAccount> {

    int deleteAccount(TSysAccount tSysAccount);

    /**
     * 通过内容查询系统参数
     * @param tSysAccount
     * @return
     */
    List<TSysAccount> selectParamsBySreach(TSysAccount tSysAccount);

    /**
     *
     * @Description: 通过项目id解绑用户
     * @auther:   zcj
     * @date:     2018/12/26
     * @param:    [tSysAccount]
     * @return:   int
     *
     */
    int  updateByProjectId(TSysAccount tSysAccount);

    /**
     * Description: 通过设备编号查询绑定的用户信息
     * Author: cwg
     * Date: 下午6:55
     **/
    TSysAccount getAccountInfoByImei(String imei);

    /**
     * 获取项目管理员
     * @param tSysAccount
     * @return
     */
    String [] selectProjectManger(TSysAccount tSysAccount);

    /**
     * 获取未绑定项目的用户加自身管理员
     * @param tSysAccount
     * @return
     */
    List<TSysAccount> selectAccountList(TSysAccount tSysAccount);

    /**
     * 获取可用的用户列表
     * @param tSysAccount
     * @return
     */
    List<TSysAccount> selectAbleUserList(TSysAccount tSysAccount);
}
