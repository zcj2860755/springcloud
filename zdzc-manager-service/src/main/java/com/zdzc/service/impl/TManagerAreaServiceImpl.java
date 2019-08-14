package com.zdzc.service.impl;

import com.zdzc.dao.TManagerAreaMapper;
import com.zdzc.dao.TManagerPlaceMapper;
import com.zdzc.dao.TManagerUnitMapper;
import com.zdzc.model.TManagerArea;
import com.zdzc.model.TManagerPlace;
import com.zdzc.model.TManagerUnit;
import com.zdzc.service.ITManagerAreaService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Author : 李琳青
 * Date : 2019-08-13 17:48
 */
@Service
public class TManagerAreaServiceImpl implements ITManagerAreaService {
    @Resource
    private TManagerAreaMapper tManagerAreaMapper;
    @Resource
    private TManagerPlaceMapper tManagerPlaceMapper;
    @Resource
    private TManagerUnitMapper tManagerUnitMapper;
    

    @Override
    public int save(TManagerArea tManagerArea) {
        tManagerArea.setParentIds(tManagerArea.getParentIds()+",");
        // return 0 数据库有同级别相同名字的数据
        List<TManagerArea> areas = tManagerAreaMapper.select(tManagerArea); //if数据量过度 多条件查询过滤
        if(areas == null || areas.size() < 1 ){
            tManagerArea.setCreateTime(new Date());
           return tManagerAreaMapper.insertSelective(tManagerArea);
        }
        return 0;
    }

    @Override
    public int update(TManagerArea tManagerArea) {
        tManagerArea.setUpdateDate(new Date());
        return tManagerAreaMapper.updateByPrimaryKeySelective(tManagerArea);
    }

    @Override
    public int deleteById(String id){ //正常删除 return 1 区域有子类 return 0 单位有用到 return 2 场所有用到 return 3
        int count = tManagerAreaMapper.selectCountByParentId(id);
        if(count !=0){
           return 0;
        }
        //查询单位、场所下有没有用到该区域
        List<TManagerUnit>  unitList = tManagerUnitMapper.selectAll();
        for (TManagerUnit unit : unitList) {
            if(id.equals(unit.getAreaId())){
                return 2;
            }
        }
        List<TManagerPlace> placeList = tManagerPlaceMapper.selectAll();
        for (TManagerPlace place : placeList) {
             if(id.equals(place.getAreaId())){
                 return 3;
             }
        }
        return tManagerAreaMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TManagerArea findById(String id){
        return tManagerAreaMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageList<TManagerArea> pageList(TManagerArea tManagerArea,BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNo(),baseRequest.getPageSize());
        List<TManagerArea> list = tManagerAreaMapper.selectAreaList(tManagerArea);
        return new PageList<TManagerArea>(list);
    }
}
