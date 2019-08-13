package com.zdzc.service.impl;

import com.zdzc.dao.TManagerPlaceMapper;
import com.zdzc.model.TManagerPlace;
import com.zdzc.service.ITManagerPlaceService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Author : 李琳青
 * Date : 2019-08-13 16:17
 */
@Service
public class TManagerPlaceServiceImpl implements ITManagerPlaceService {
    @Resource
    private TManagerPlaceMapper tManagerPlaceMapper;

    @Override
    public int save(TManagerPlace tManagerPlace) {
        tManagerPlace.setCreateTime(new Date());
        tManagerPlace.setCode("暂时先写死");
        return tManagerPlaceMapper.insertSelective(tManagerPlace);
    }

    @Override
    public int update(TManagerPlace tManagerPlace) {
        tManagerPlace.setUpdateTime(new Date());
        return tManagerPlaceMapper.updateByPrimaryKeySelective(tManagerPlace);
    }

    @Override
    public int updateFreezeStatus(Integer id) {
        TManagerPlace placeInfo = tManagerPlaceMapper.selectByPrimaryKey(id);
        Integer freezeStatus = placeInfo.getFreezeStatus();
        int status = 0;
        if(freezeStatus == 0){ //未冻结
            status =1;
        }
        placeInfo.setFreezeStatus(status);
        return tManagerPlaceMapper.updateByPrimaryKeySelective(placeInfo);
    }

    @Override
    public int deleteById(String id){
        return tManagerPlaceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TManagerPlace findById(String id){
        return tManagerPlaceMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageList<TManagerPlace> pageList(TManagerPlace tManagerPlace,BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNo(),baseRequest.getPageSize());
        List<TManagerPlace> list = tManagerPlaceMapper.selectPlaceList(tManagerPlace);
        return new PageList<TManagerPlace>(list);
    }
}
