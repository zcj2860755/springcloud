package com.zdzc.service.impl;

import com.zdzc.dao.TSysAreaMapper;
import com.zdzc.enums.ExceptionEnum;
import com.zdzc.model.TSysArea;
import com.zdzc.service.ITSysAreaService;
import com.zdzc.utils.BaseException;
import io.swagger.models.auth.In;
import javafx.scene.input.InputMethodTextRun;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Author : 李琳青
 * Date : 2019-08-09 11:06
 */
@Service
public class TSysAreaServiceImpl implements ITSysAreaService {
    @Resource
    private TSysAreaMapper tSysAreaMapper;

    @Override
    public int save(TSysArea tSysArea) {
        Integer parentId = tSysArea.getParentId();
        TSysArea area = tSysAreaMapper.selectByPrimaryKey(parentId);
        if(area != null){ //添加省份校验
            tSysArea.setPathIds(area.getPathIds()+"&"+String.valueOf(parentId)+"&");
        }
        return tSysAreaMapper.insertSelective(tSysArea);
    }

    @Override
    public int update(TSysArea tSysArea) {
        Integer parentId = tSysArea.getParentId();
        TSysArea area = tSysAreaMapper.selectByPrimaryKey(parentId);
        tSysArea.setPathIds(area.getPathIds()+"&"+String.valueOf(parentId)+"&");
        return tSysAreaMapper.updateByPrimaryKeySelective(tSysArea);
    }

    @Override
    public int deleteById(String id) {
        int count = tSysAreaMapper.selectCountByParentId(Integer.valueOf(id));
        if(count !=0){
            throw new BaseException(ExceptionEnum.POWER_CHILD_EXIST);
        }
        return tSysAreaMapper.deleteByPrimaryKey(id);
    }


    @Override
    public List<TSysArea> selectProvinceCityAreaList(TSysArea tSysArea) {
        Integer id = tSysArea.getId();
        if(StringUtils.isEmpty(id)){
            return tSysAreaMapper.selectProvinceList();
        }
        return tSysAreaMapper.selectAreaListByParentId(id);
    }


}
