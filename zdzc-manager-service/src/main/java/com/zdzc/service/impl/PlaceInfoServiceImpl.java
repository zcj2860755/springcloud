package com.zdzc.service.impl;

import com.zdzc.dao.PlaceInfoMapper;
import com.zdzc.model.PlaceInfo;
import com.zdzc.service.IPlaceInfoService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Author : 李琳青
 * Date : 2019-08-12 19:47
 */
@Service
public class PlaceInfoServiceImpl implements IPlaceInfoService {
    @Resource
    private PlaceInfoMapper placeInfoMapper;

    @Override
    public int save(PlaceInfo placeInfo) {
        placeInfo.setCreateTime(new Date());
        return placeInfoMapper.insertSelective(placeInfo);
    }

    @Override
    public int update(PlaceInfo placeInfo) {
        placeInfo.setUpdateTime(new Date());
        return placeInfoMapper.updateByPrimaryKeySelective(placeInfo);
    }

    @Override
    public int updateFreezeStatus(Integer id) {
        PlaceInfo placeInfo = placeInfoMapper.selectByPrimaryKey(id);
        Integer freezeStatus = placeInfo.getFreezeStatus();
        int status = 0;
        if(freezeStatus == 0){ //未冻结
            status =1;
        }
        placeInfo.setFreezeStatus(status);
        return placeInfoMapper.updateByPrimaryKeySelective(placeInfo);
    }

    @Override
    public int deleteById(String id){
        return placeInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PlaceInfo findById(String id){
        return placeInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageList<PlaceInfo> pageList(PlaceInfo placeInfo,BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNo(),baseRequest.getPageSize());
        List<PlaceInfo> list = placeInfoMapper.selectPlaceInfoList(placeInfo);
        return new PageList<PlaceInfo>(list);
    }
}
