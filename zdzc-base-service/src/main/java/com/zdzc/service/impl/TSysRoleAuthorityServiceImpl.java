package com.zdzc.service.impl;

import com.zdzc.dao.TSysRoleAuthorityMapper;
import com.zdzc.model.TSysRoleAuthority;
import com.zdzc.service.ITSysRoleAuthorityService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by zahngchangjiang on 2018/12/14.
 */
@Service
public class TSysRoleAuthorityServiceImpl implements ITSysRoleAuthorityService {
    @Resource
    private TSysRoleAuthorityMapper tSysRoleAuthorityMapper;

    @Override
    public Set<String> selectRoleList(TSysRoleAuthority tSysRoleAuthority) {
        List<TSysRoleAuthority> tSysRoleAuthoritys = tSysRoleAuthorityMapper.selectParamsByOrder(tSysRoleAuthority);
        Set<String>  roleIds = new HashSet<>();

        if(!StringUtils.isEmpty(tSysRoleAuthoritys) && tSysRoleAuthoritys.size()>0) {
            for (TSysRoleAuthority role : tSysRoleAuthoritys) {
                roleIds.add(role.getAuthId());
            }
        }

        return roleIds;
    }
}
