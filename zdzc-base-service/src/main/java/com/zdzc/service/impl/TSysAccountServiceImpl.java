package com.zdzc.service.impl;

import com.github.pagehelper.PageHelper;
import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;
import com.zdzc.enums.ExceptionEnum;
import com.zdzc.utils.BaseException;
import com.zdzc.utils.UUIDUtils;
import com.zdzc.dao.TSysAccountMapper;

import com.zdzc.model.TSysAccount;

import com.zdzc.service.ITSysAccountService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Author  zcj
 * @Description //TODO
 * @Date 15:48 2019/8/2
 * @Param
 * @return
 **/
@Service
public class TSysAccountServiceImpl implements ITSysAccountService {

    @Resource
    private TSysAccountMapper tSysAccountMapper;


    @Override
    public int insert(TSysAccount tSysAccount) {
        return tSysAccountMapper.insert(tSysAccount);
    }

    @Override
    public int updateByPrimaryKeySelective(TSysAccount tSysAccount) {
        return tSysAccountMapper.updateByPrimaryKeySelective(tSysAccount);
    }

    @Override
    public int insertSelective(TSysAccount tSysAccount) {
        return tSysAccountMapper.insertSelective(tSysAccount);
    }

    @Override
    public int deleteByPrimaryKey(TSysAccount tSysAccount) {
        return tSysAccountMapper.deleteByPrimaryKey(tSysAccount);
    }

    @Override
    public PageList<TSysAccount> selectParamsList(TSysAccount tSysAccount, BaseRequest baseRequest) {
        return null;
    }

    @Override
    public TSysAccount selectByPrimaryKey(String id) {
        return tSysAccountMapper.selectByPrimaryKey(id);
    }

    @Override
    public Map<String, Object> login(TSysAccount tSysAccount) {
        return null;
    }

    @Override
    public PageList<TSysAccount> selectAccountList(TSysAccount tSysAccount, BaseRequest baseRequest) {
        return null;
    }

    @Override
    public List<TSysAccount> selectAccountList(TSysAccount tSysAccount) {
        return tSysAccountMapper.select(tSysAccount);
    }

    @Override
    public TSysAccount getAccountInfoByImei(String imei) {
        return null;
    }

    @Override
    public List<TSysAccount> selectAccountAbleList(TSysAccount tSysAccount) {
        return null;
    }

    @Override
    public int updateByPrimaryKey(TSysAccount tSysAccount) {
        return tSysAccountMapper.updateByPrimaryKey(tSysAccount);
    }
}
