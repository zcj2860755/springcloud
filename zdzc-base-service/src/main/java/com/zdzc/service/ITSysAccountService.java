package com.zdzc.service;




import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;
import com.zdzc.model.TSysAccount;

import java.util.List;
import java.util.Map;

/**
 * Created by zahngchangjiang on 2018/12/14.
 */

public interface ITSysAccountService {

    /**
     *
     * @Description:
     * @auther:   zcj
     * @date:     2018/12/14
     * @param:    新增账户
     * @return:   int
     *
     */
    int insert(TSysAccount tSysAccount);


    /**
     *
     * @Description:
     * @auther:   zcj
     * @date:     2018/12/14
     * @param:     修改账户
     * @return:   int
     *
     */
    int updateByPrimaryKeySelective(TSysAccount tSysAccount);


    int insertSelective(TSysAccount tSysAccount);

    /**
     * 删除用户信息
     * @param tSysAccount
     * @return int
     */
    int deleteByPrimaryKey(TSysAccount tSysAccount);


    PageList<TSysAccount> selectParamsList(TSysAccount tSysAccount, BaseRequest baseRequest);

    /**
     * 获取用户信息详情
     * @param id
     * @return
     */
    TSysAccount selectByPrimaryKey(String id);

    Map<String,Object> login(TSysAccount tSysAccount);

    PageList<TSysAccount> selectAccountList(TSysAccount tSysAccount, BaseRequest baseRequest);

    List<TSysAccount> selectAccountList(TSysAccount tSysAccount);

    /**
     * Description: 通过设备编号查询绑定的用户信息
     * Author: cwg
     * Date: 下午6:55
     **/
    TSysAccount getAccountInfoByImei(String imei);


    List<TSysAccount> selectAccountAbleList(TSysAccount tSysAccount);

    int updateByPrimaryKey(TSysAccount tSysAccount);

}
