package com.zdzc.dao;

import com.zdzc.core.Mapper;
import com.zdzc.model.TSysRole;

import java.util.List;

public interface TSysRoleMapper extends Mapper<TSysRole> {

    /**
     * 通过内容查询角色
     * @param tSysRole
     * @return
     */
    List<TSysRole> selectParamsBySreach(TSysRole tSysRole);
}