package com.zdzc.service.impl;

import com.zdzc.dao.TSysAreaMapper;
import com.zdzc.model.TSysArea;
import com.zdzc.service.ITSysAreaService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;

import javax.annotation.Resource;

/**
 * Author : 李琳青
 * Date : 2019-08-07 19:16
 */
@Service
public class TSysAreaServiceImpl implements ITSysAreaService {
    @Resource
    private TSysAreaMapper tSysAreaMapper;

    @Override
    public int save(TSysArea tSysArea) {
        return tSysAreaMapper.insertSelective(tSysArea);
    }

    @Override
    public int update(TSysArea tSysArea) {
        return tSysAreaMapper.updateByPrimaryKeySelective(tSysArea);
    }

    @Override
    public int deleteById(String id){
        return tSysAreaMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TSysArea findById(String id){
        return tSysAreaMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageList<TSysArea> list(TSysArea tSysArea,BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNo(),baseRequest.getPageSize());
        return new PageList<TSysArea>(tSysAreaMapper.select(tSysArea));
    }
}
