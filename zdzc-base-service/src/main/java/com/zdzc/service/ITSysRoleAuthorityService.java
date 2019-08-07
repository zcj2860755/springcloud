package com.zdzc.service;


import com.zdzc.model.TSysRoleAuthority;

import java.util.Set;

/**
 * Created by zahngchangjiang on 2018/12/14.
 */
public interface ITSysRoleAuthorityService {



    /**
     * 角色权限关联表
     * @return
     */
    Set<String> selectRoleList(TSysRoleAuthority TSysRoleAuthority);

}
