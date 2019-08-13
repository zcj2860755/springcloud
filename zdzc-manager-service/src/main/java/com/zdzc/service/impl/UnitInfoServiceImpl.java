package com.zdzc.service.impl;

import com.zdzc.dao.UnitInfoMapper;
import com.zdzc.model.UnitInfo;
import com.zdzc.service.IUnitInfoService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Author : 李琳青
 * Date : 2019-08-13 10:21
 */
@Service
public class UnitInfoServiceImpl implements IUnitInfoService {
    @Resource
    private UnitInfoMapper unitInfoMapper;

    @Override
    public int save(UnitInfo unitInfo) {
        unitInfo.setCreateTime(new Date());
        unitInfo.setUnitCredentUrl("Credent_url");
        unitInfo.setLogoUrl("logo_url");
        unitInfo.setCode("暂时先写死");
        return unitInfoMapper.insertSelective(unitInfo);
    }

    @Override
    public int update(UnitInfo unitInfo) {
        unitInfo.setUpdateTime(new Date());
        return unitInfoMapper.updateByPrimaryKeySelective(unitInfo);
    }

    @Override
    public int deleteById(String id){
        return unitInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public UnitInfo findById(String id){
        return unitInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageList<UnitInfo> pageList(UnitInfo unitInfo,BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNo(),baseRequest.getPageSize());
        List<UnitInfo> list = unitInfoMapper.selectUnitList(unitInfo);
        return new PageList<UnitInfo>(list);
    }
}
