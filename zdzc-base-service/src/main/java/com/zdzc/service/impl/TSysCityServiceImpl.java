package com.zdzc.service.impl;

import com.zdzc.dao.TSysCityMapper;
import com.zdzc.model.TSysCity;
import com.zdzc.service.ITSysCityService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;

import javax.annotation.Resource;

/**
 * Author : 李琳青
 * Date : 2019-08-07 18:42
 */
@Service
public class TSysCityServiceImpl implements ITSysCityService {
    @Resource
    private TSysCityMapper tSysCityMapper;

    @Override
    public int save(TSysCity tSysCity) {
        return tSysCityMapper.insertSelective(tSysCity);
    }

    @Override
    public int update(TSysCity tSysCity) {
        return tSysCityMapper.updateByPrimaryKeySelective(tSysCity);
    }

    @Override
    public int deleteById(String id){
        return tSysCityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TSysCity findById(String id){
        return tSysCityMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageList<TSysCity> list(TSysCity tSysCity,BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNo(),baseRequest.getPageSize());
        return new PageList<TSysCity>(tSysCityMapper.select(tSysCity));
    }
}
