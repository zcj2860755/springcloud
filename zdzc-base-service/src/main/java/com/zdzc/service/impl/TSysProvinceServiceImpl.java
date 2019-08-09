package com.zdzc.service.impl;

import com.zdzc.dao.TSysAreaMapper;
import com.zdzc.dao.TSysCityMapper;
import com.zdzc.dao.TSysProvinceMapper;
import com.zdzc.model.TSysArea;
import com.zdzc.model.TSysCity;
import com.zdzc.model.TSysProvince;
import com.zdzc.service.ITSysProvinceService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author : 李琳青
 * Date : 2019-08-07 16:42
 */
@Service
public class TSysProvinceServiceImpl implements ITSysProvinceService {
    @Resource
    private TSysProvinceMapper tSysProvinceMapper;
    @Resource
    private TSysCityMapper tSysCityMapper;
    @Resource
    private TSysAreaMapper tSysAreaMapper;

    @Override
    public int save(TSysProvince tSysProvince) {
        return tSysProvinceMapper.insertSelective(tSysProvince);
    }

    @Override
    public int update(TSysProvince tSysProvince) {
        return tSysProvinceMapper.updateByPrimaryKeySelective(tSysProvince);
    }

    @Override
    public int deleteById(String id){
        return tSysProvinceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TSysProvince findById(String id){
        return tSysProvinceMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageList<TSysProvince> list(TSysProvince tSysProvince,BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNo(),baseRequest.getPageSize());
        return new PageList<TSysProvince>(tSysProvinceMapper.select(tSysProvince));
    }

    @Override
    public List<TSysProvince> provinceList() {
        return tSysProvinceMapper.selectProvinceList();
    }



}
