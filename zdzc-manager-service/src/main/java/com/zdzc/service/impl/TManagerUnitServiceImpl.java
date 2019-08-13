package com.zdzc.service.impl;

import com.zdzc.dao.TManagerUnitMapper;
import com.zdzc.model.TManagerUnit;
import com.zdzc.service.ITManagerUnitService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Author : 李琳青
 * Date : 2019-08-13 16:18
 */
@Service
public class TManagerUnitServiceImpl implements ITManagerUnitService {
    @Resource
    private TManagerUnitMapper tManagerUnitMapper;

    @Override
    public int save(TManagerUnit tManagerUnit) {
        tManagerUnit.setCreateTime(new Date());
        tManagerUnit.setUnitCredentUrl("Credent_url");
        tManagerUnit.setLogoUrl("logo_url");
        tManagerUnit.setCode("暂时先写死");
        return tManagerUnitMapper.insertSelective(tManagerUnit);
    }

    @Override
    public int update(TManagerUnit tManagerUnit) {
        tManagerUnit.setUpdateTime(new Date());
        return tManagerUnitMapper.updateByPrimaryKeySelective(tManagerUnit);
    }

    @Override
    public int deleteById(String id){
        return tManagerUnitMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TManagerUnit findById(String id){
        return tManagerUnitMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageList<TManagerUnit> pageList(TManagerUnit tManagerUnit,BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNo(),baseRequest.getPageSize());
        List<TManagerUnit> list = tManagerUnitMapper.selectUnitList(tManagerUnit);
        return new PageList<TManagerUnit>(list);
    }
}
