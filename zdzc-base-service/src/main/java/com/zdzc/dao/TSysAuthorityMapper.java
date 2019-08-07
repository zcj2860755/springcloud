package com.zdzc.dao;

import com.zdzc.core.Mapper;
import com.zdzc.model.TSysAuthority;

import java.util.List;

public interface TSysAuthorityMapper extends Mapper<TSysAuthority> {

    /**
     * 通过内容查询权限
     * @param tSysAuthority
     * @return
     */
    List<TSysAuthority> selectParamsBySreach(TSysAuthority tSysAuthority);

    /**
     * 获取所有权限
     * @return
     */
    List<TSysAuthority> selectAllAuthority(TSysAuthority tSysAuthority);
    
    /**
     *
     * @Description:
     * @auther:   zcj
     * @date:     2019/1/14   
     * @param:
     * @return:   java.util.List<com.zdzc.model.TSysAuthority>
     *
     */
    List<TSysAuthority> defaultAuth(TSysAuthority tSysAuthority);

}
