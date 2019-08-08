package com.zdzc.service.impl;

import com.github.pagehelper.PageHelper;
import com.zdzc.common.BaseRequest;
import com.zdzc.common.CommonStatus;
import com.zdzc.common.PageList;
import com.zdzc.enums.ExceptionEnum;
import com.zdzc.utils.ArrayUtil;
import com.zdzc.utils.BaseException;
import com.zdzc.utils.UUIDUtils;
import com.zdzc.dao.TSysAccountMapper;
import com.zdzc.dao.TSysRoleAuthorityMapper;
import com.zdzc.dao.TSysRoleMapper;
import com.zdzc.model.TSysAccount;
import com.zdzc.model.TSysRole;
import com.zdzc.model.TSysRoleAuthority;
import com.zdzc.service.ITSysRoleService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * @Author  zcj
 * @Description // 用户角色相关
 * @Date 10:25 2019/8/7
 **/
@Service
public class TSysRoleServiceImpl implements ITSysRoleService {
    @Resource
    private TSysRoleMapper tSysRoleMapper;

    @Resource
    private TSysRoleAuthorityMapper tSysRoleAuthorityMapper;

    @Resource
    private TSysAccountMapper tSysAccountMapper;

    @Override
    public int countByExample(TSysRole tSysRole) {
        return 0;
    }

    @Override
    public int deleteByExample(TSysRole tSysRole) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String id){
        List<String> idList = Arrays.asList(id.replace(" ","").split(","));//根据逗号分隔转化为
        TSysAccount tSysAccount = new TSysAccount();
        TSysRole tSysRole = new TSysRole();
        int roleNum= 0 ;
        for(String Id :idList) {
            tSysAccount.setRoleId(Id);
            tSysAccount.setDelFlag(CommonStatus.STATUS_NORMAL);
            if (tSysAccountMapper.selectCount(tSysAccount) > 0) {
                throw new BaseException(ExceptionEnum.USER_ROLE_DISTRIBUTION);
            }
            tSysRole.setId(Id);
            tSysRole.setDelFlag(CommonStatus.STATUS_DEL);
            roleNum = tSysRoleMapper.updateByPrimaryKeySelective(tSysRole);

            if (roleNum == 0) {
                throw new BaseException(ExceptionEnum.SYSTEM_DELETE_ERROR);
            }
            TSysRoleAuthority tSysRoleAuthority = new TSysRoleAuthority();
            tSysRoleAuthority.setRoleId(Id);
            tSysRoleAuthorityMapper.delete(tSysRoleAuthority);
        }
        return roleNum;
    }

    @Override
    public int insert(TSysRole tSysRole) {
        return 0;
    }

    @Override
    public int insertSelective(TSysRole tSysRole) {
        tSysRole.setId(UUIDUtils.getUUID());
        tSysRole.setCreateTime(new Date());
        if(!StringUtils.isEmpty(tSysRole.getAuthIds())) {
            String[] authIds = tSysRole.getAuthIds();
            TSysRoleAuthority tSysRoleAuthority = new TSysRoleAuthority();
            for (String auth : authIds) {
                auth = ArrayUtil.replace(auth);
                tSysRoleAuthority.setId(UUIDUtils.getUUID());
                tSysRoleAuthority.setRoleId(tSysRole.getId());
                tSysRoleAuthority.setAuthId(auth);
                tSysRoleAuthorityMapper.insertSelective(tSysRoleAuthority);
            }
        }

        return tSysRoleMapper.insertSelective(tSysRole);
    }

    @Override
    public List<TSysRole> selectByExample(TSysRole tSysRole) {
        return tSysRoleMapper.select(tSysRole);
    }

    @Override
    public PageList<TSysRole> selectParamsList(TSysRole Params) {
        Params.setDelFlag(0);
        PageHelper.startPage(Params.getPageNo(),Params.getPageSize());
        return new PageList<TSysRole>(tSysRoleMapper.selectParamsBySreach(Params));
    }

    @Override
    public TSysRole selectByPrimaryKey(String id) {
        return tSysRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(TSysRole tSysRoleParams) {
        return 0;
    }

    @Override
    public int updateByExample(TSysRole tSysRoleParams, TSysRole ParamsChange) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(TSysRole tSysRoleParams) {
        //根据角色id将权限角色表更新
        //先删除，再添加
        if(!StringUtils.isEmpty(tSysRoleParams.getAuthIds()) && tSysRoleParams.getAuthIds().length>0){
            TSysRoleAuthority tSysRoleAuthority = new TSysRoleAuthority();
            tSysRoleAuthority.setRoleId(tSysRoleParams.getId());
            tSysRoleAuthorityMapper.delete(tSysRoleAuthority);
            for(String authId :  tSysRoleParams.getAuthIds()){
                if(!StringUtils.isEmpty(authId)){
                    tSysRoleAuthority.setAuthId(authId);
                    tSysRoleAuthority.setId(UUIDUtils.getUUID());
                    tSysRoleAuthorityMapper.insertSelective(tSysRoleAuthority);
                }
            }

        }

        return tSysRoleMapper.updateByPrimaryKeySelective(tSysRoleParams);
    }

    @Override
    public int updateByPrimaryKey(TSysRole tSysRoleParams) {
        return 0;
    }

    @Override
    public List<TSysRole> selectAll() {
        return tSysRoleMapper.selectAll();
    }
}
