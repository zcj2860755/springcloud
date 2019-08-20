package com.zdzc.service.impl;

import com.alibaba.fastjson.JSON;
import com.zdzc.dao.TManagerPlaceMapper;
import com.zdzc.model.TManagerPlace;
import com.zdzc.service.ITManagerPlaceService;
import com.zdzc.utils.HttpUtil;
import com.zdzc.utils.PlaceUnitUtils;
import io.swagger.models.auth.In;
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
        String lon = tManagerPlace.getLon();
        String lat = tManagerPlace.getLat();
        //updatePalce.js
        String sendGet = HttpUtil.sendGet("http://restapi.amap.com/v3/geocode/regeo?key=c7f9ff065d022ad4d3f015f147ccc426&location=", lon+","+lat);
        String regeocode = JSON.parseObject(sendGet).getString("regeocode");
        String formattedAddress = JSON.parseObject(regeocode).getString("formatted_address");
        String addressComponent = JSON.parseObject(regeocode).getString("addressComponent");
        String province = JSON.parseObject(addressComponent).getString("province");
        String city = JSON.parseObject(addressComponent).getString("city");
        String district = JSON.parseObject(addressComponent).getString("district");
        String cityCode = JSON.parseObject(addressComponent).getString("citycode");
        String adcode = JSON.parseObject(addressComponent).getString("adcode");
        tManagerPlace.setCreateTime(new Date());
        //生成场所编号
        tManagerPlace.setCode(PlaceUnitUtils.createPlaceCode(0));
        tManagerPlace.setFormattedAddress(formattedAddress);
        tManagerPlace.setProvince(province);
        tManagerPlace.setCity(city);
        tManagerPlace.setDistrict(district);
        tManagerPlace.setCityCode(cityCode);
        tManagerPlace.setAdcode(adcode);
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
        return tManagerPlaceMapper.selectPalceById(id);
    }

    @Override
    public PageList<TManagerPlace> pageList(TManagerPlace tManagerPlace, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<TManagerPlace> list = tManagerPlaceMapper.selectPlaceList(tManagerPlace);
        return new PageList<TManagerPlace>(list);
    }
}
