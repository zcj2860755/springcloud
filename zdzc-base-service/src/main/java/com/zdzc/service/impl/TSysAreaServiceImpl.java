package com.zdzc.service.impl;

import com.zdzc.dao.TSysAreaMapper;
import com.zdzc.model.TSysArea;
import com.zdzc.service.ITSysAreaService;
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
        tSysArea.setPathIds(area.getPathIds()+String.valueOf(parentId)+"&");
        return tSysAreaMapper.insertSelective(tSysArea);
    }

    @Override
    public int update(TSysArea tSysArea) {
        Integer parentId = tSysArea.getParentId();
        TSysArea area = tSysAreaMapper.selectByPrimaryKey(parentId);
        tSysArea.setPathIds(area.getPathIds()+String.valueOf(parentId)+"&");
        return tSysAreaMapper.updateByPrimaryKeySelective(tSysArea);
    }

    @Override
    public int deleteById(String id) {
        int key = tSysAreaMapper.deleteByPrimaryKey(id);
        deleteChildrenAreas(Integer.valueOf(id));
        return key;
    }

    /**
     * @description：递归删除所有子类别
     */
    public void deleteChildrenAreas(Integer id) {
        List<TSysArea> tSysAreas = tSysAreaMapper.selectAreaListByParentId(id);
        //判断id是否存在下级id   无判断就ok
        for (TSysArea tSysArea : tSysAreas) {
            int delete = tSysAreaMapper.deleteByPrimaryKey(tSysArea.getId());
            deleteChildrenAreas(tSysArea.getId());
        }
    }

    @Override
    public List<TSysArea> selectProvinceCityAreaList(TSysArea tSysArea) {
        Integer id = tSysArea.getId();
        Integer mark = tSysArea.getMark();
        int type = 0;
        if (mark == 1) {
                return tSysAreaMapper.selectProvinceList();
        } else if (mark == 2) {
            type = 2;
        } else if (mark == 3) {
            type = 3;
        } else if (mark == 4) {
            type = 4;
        }
        return tSysAreaMapper.selectProvinceCityAreaList(id, type);
    }


}
