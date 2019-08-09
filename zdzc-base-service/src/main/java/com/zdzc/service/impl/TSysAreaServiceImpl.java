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

        /*Integer parentId = tSysArea.getParentId();
        TSysArea area = tSysAreaMapper.selectByPrimaryKey(parentId);
        tSysArea.setPathIds(area.getPathIds()+String.valueOf(parentId)+"&");*/

       /* Integer parentId1 = tSysArea.getParentId();
        String[] splits = String.valueOf(parentId1).split("&");
        System.out.println("ids数组是:"+splits);*/
        return tSysAreaMapper.insertSelective(tSysArea);
    }

    @Override
    public int update(TSysArea tSysArea) {
        return tSysAreaMapper.updateByPrimaryKeySelective(tSysArea);
    }

    @Override
    public int deleteById(String id){
        int key = tSysAreaMapper.deleteByPrimaryKey(id);
        deleteAreas(Integer.valueOf(id));
        return key;
    }

    /**
     * @description：递归删除所有子类别
     */
    public void deleteAreas(Integer id){
        List<TSysArea> tSysAreas = tSysAreaMapper.selectAreaListByParentId(id);
        //判断id是否存在下级id   无判断就ok
            for (TSysArea tSysArea : tSysAreas) {
                int delete = tSysAreaMapper.deleteByPrimaryKey(tSysArea.getId());
                deleteAreas(tSysArea.getId());
            }
        }



    @Override
    public TSysArea findById(String id){
        return tSysAreaMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageList<TSysArea> pageList(TSysArea tSysArea,BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNo(),baseRequest.getPageSize());
        return new PageList<TSysArea>(tSysAreaMapper.select(tSysArea));
    }

    @Override
    public List<TSysArea> selectProvinceList() {
        List<TSysArea> provinceList = tSysAreaMapper.selectProvinceList();
        return provinceList;
    }

    @Override
    public List<TSysArea> selectCityList(Integer provinceId) {
        return tSysAreaMapper.selectCityList(provinceId);
    }

    @Override
    public List<TSysArea> selectAreaList(Integer cityId) {
        return tSysAreaMapper.selectAreaList(cityId);
    }

    @Override
    public List<TSysArea> selectTownList(Integer areaId) {
        return tSysAreaMapper.selectTownList(areaId);
    }
}
