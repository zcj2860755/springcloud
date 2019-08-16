package com.zdzc.service.impl;

import com.zdzc.dao.TManagerPlaceMapper;
import com.zdzc.dao.TManagerUnitMapper;
import com.zdzc.enums.ExceptionEnum;
import com.zdzc.model.TManagerPlace;
import com.zdzc.model.TManagerUnit;
import com.zdzc.service.ITManagerUnitService;
import com.zdzc.utils.BaseException;
import com.zdzc.utils.PlaceUnitUtils;
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
    @Resource
    private TManagerPlaceMapper tManagerPlaceMapper;

    @Override
    public int save(TManagerUnit tManagerUnit) {
        tManagerUnit.setCreateTime(new Date());
        tManagerUnit.setUnitCredentUrl("Credent_url");
        tManagerUnit.setLogoUrl("logo_url");
        //生成单位编号
        tManagerUnit.setCode(PlaceUnitUtils.createPlaceCode(1));
        return tManagerUnitMapper.insertSelective(tManagerUnit);
    }

    @Override
    public int update(TManagerUnit tManagerUnit) {
        tManagerUnit.setUpdateTime(new Date());
        return tManagerUnitMapper.updateByPrimaryKeySelective(tManagerUnit);
    }

    @Override
    public int deleteById(String id){
        TManagerPlace place =new TManagerPlace();
        place.setUnitId(id);
        int count = tManagerPlaceMapper.selectCount(place);
        if(count != 0){
            throw new BaseException(ExceptionEnum.UNIT_CHILDREN_PLACE_NULL);
        }
        return tManagerUnitMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TManagerUnit findById(String id){
        return tManagerUnitMapper.selectUnitById(id);
    }

    @Override
    public PageList<TManagerUnit> pageList(TManagerUnit tManagerUnit,Integer pageNo,Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<TManagerUnit> list = tManagerUnitMapper.selectUnitList(tManagerUnit);
        return new PageList<TManagerUnit>(list);
    }
}
