package com.zdzc.dao;


import com.zdzc.core.Mapper;
import com.zdzc.model.TSysRoleAuthority;

import java.util.List;

public interface TSysRoleAuthorityMapper extends Mapper<TSysRoleAuthority> {

    /**
     * 通过内容查询角色
     * @param tSysRoleAuthority
     * @return
     */
    List<TSysRoleAuthority> selectParamsByOrder(TSysRoleAuthority tSysRoleAuthority);
}