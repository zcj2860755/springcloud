package com.zdzc.service.impl;

import com.github.pagehelper.PageHelper;

import com.zdzc.common.BaseRequest;
import com.zdzc.common.CommonStatus;
import com.zdzc.common.PageList;
import com.zdzc.dao.TSysAccountMapper;
import com.zdzc.dao.TSysRoleMapper;
import com.zdzc.enums.ExceptionEnum;
import com.zdzc.model.TSysAccount;
import com.zdzc.model.TSysRole;
import com.zdzc.service.ITSysAccountService;
import com.zdzc.utils.BaseException;
import com.zdzc.utils.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by zahngchangjiang on 2018/12/14.
 */
@Service
public class TSysAccountServiceImpl implements ITSysAccountService {

    @Resource
    private TSysAccountMapper tSysAccountMapper;

    @Resource
    private TSysRoleMapper tSysRoleMapper;


    @Override
    public PageList<TSysAccount> selectParamsList(TSysAccount tSysAccount, BaseRequest baseRequest) {
        return null;
    }

    @Override
    public TSysAccount selectByPrimaryKey(String id) {
        return tSysAccountMapper.selectByPrimaryKey(id);
    }

    @Override
    public Map<String,Object> login(TSysAccount tSysAccount) {
        Map<String,Object> result = new HashMap<String, Object>() ;
        tSysAccount.setDelFlag(CommonStatus.STATUS_NORMAL);
        TSysAccount userInfo= tSysAccountMapper.selectOne(tSysAccount);
        if(StringUtils.isEmpty(userInfo)){
            result.put("isLogin",-1);
        }else{
            if(StringUtils.isEmpty(userInfo.getProId())){
                throw new BaseException(ExceptionEnum.USER_NOT_ASCRIPTION);
            }
            if(userInfo.getStatus().equals(1)){
                result.put("isLogin",2);
            }else {
                String roleId = userInfo.getRoleId();
                TSysRole tSysRole = new TSysRole();
                tSysRole.setId(roleId);
                TSysRole roleInfo = tSysRoleMapper.selectByPrimaryKey(tSysRole);
                Integer isLogin = roleInfo.getIsLogin();
                if (isLogin.equals(1)) {
                    result.put("isLogin", 1);
                }
                if (isLogin.equals(0)) {
                    result.put("isLogin", 0);
                    result.put("userInfo", userInfo);
                }
            }
        }

        return result;
    }

    @Override
    public PageList<TSysAccount> selectAccountList(TSysAccount tSysAccount, BaseRequest baseRequest) {

        PageHelper.startPage(baseRequest.getPageNo(),baseRequest.getPageSize());
        return new PageList<TSysAccount>(tSysAccountMapper.selectParamsBySreach(tSysAccount));
    }

    @Override
    public List<TSysAccount> selectAccountList(TSysAccount tSysAccount) {
        return tSysAccountMapper.select(tSysAccount);
    }


    @Override
    public int insert(TSysAccount tSysAccount) {
        int result ;
        TSysAccount user = new TSysAccount();
        user.setAccount(tSysAccount.getAccount());
        user.setDelFlag(0);
        TSysAccount account = tSysAccountMapper.selectOne(user);
        if(StringUtils.isEmpty(account)){
            tSysAccount.setId(UUIDUtils.getUUID());
            tSysAccount.setCreateTime(new Date());
            if(tSysAccount.getProId() == null){
                tSysAccount.setProId("");
            }
            result = tSysAccountMapper.insertSelective(tSysAccount);
        }else{
            result = -1 ;
        }

        return result;
    }

    @Override
    public int updateByPrimaryKeySelective(TSysAccount tSysAccount) {
        //用户冻结之前需要查看用户该用户是否绑定有设备
        if(StringUtils.isEmpty(tSysAccount.getStatus())){
            tSysAccount.setStatus(0);
        }
        //用户冻结之前要查看该用户是否有其他绑定
        // TODO
        int result =tSysAccountMapper.updateByPrimaryKeySelective(tSysAccount);
        return result;
    }

    @Override
    public int insertSelective(TSysAccount tSysAccount) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(TSysAccount tSysAccount) {
        if(!StringUtils.isEmpty(tSysAccount.getIds())){
           //TODO
        }
        tSysAccount.setDelFlag(CommonStatus.STATUS_DEL);
        return tSysAccountMapper.deleteAccount(tSysAccount);
    }

    @Override
    public TSysAccount getAccountInfoByImei(String imei){
        return tSysAccountMapper.getAccountInfoByImei(imei);
    }

    @Override
    public List<TSysAccount> selectAccountAbleList(TSysAccount tSysAccount) {
        return tSysAccountMapper.selectAbleUserList(tSysAccount);
    }

    @Override
    public int updateByPrimaryKey(TSysAccount tSysAccount) {
        return tSysAccountMapper.updateByPrimaryKeySelective(tSysAccount);
    }
}
