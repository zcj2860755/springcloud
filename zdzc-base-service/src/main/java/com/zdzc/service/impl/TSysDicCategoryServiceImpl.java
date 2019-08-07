package com.zdzc.service.impl;

import com.zdzc.dao.TSysDicCategoryMapper;
import com.zdzc.model.TSysDicCategory;
import com.zdzc.service.ITSysDicCategoryService;
import com.zdzc.utils.UUIDUtils;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;

import javax.annotation.Resource;

/**
 * Author : 李琳青
 * Date : 2019-08-06 19:08
 */
@Service
public class TSysDicCategoryServiceImpl implements ITSysDicCategoryService {
    @Resource
    private TSysDicCategoryMapper tSysDicCategoryMapper;

    @Override
    public int save(TSysDicCategory tSysDicCategory) {
        tSysDicCategory.setId(UUIDUtils.getUUID());
        int insert = tSysDicCategoryMapper.insertSelective(tSysDicCategory);
        System.out.println("是否插入成功:"+insert);
        return insert;
    }


    @Override
    public int deleteById(String id){
        return tSysDicCategoryMapper.deleteByPrimaryKey(id);
    }


    @Override
    public int update(TSysDicCategory tSysDicCategory) {
        int update = tSysDicCategoryMapper.updateByPrimaryKeySelective(tSysDicCategory);
        System.out.println("是否修改:"+update);
        return update;
    }


    @Override
    public TSysDicCategory findById(String id){
        TSysDicCategory tSysDicCategory = tSysDicCategoryMapper.selectByPrimaryKey(id);
        System.out.println(tSysDicCategory);
        return tSysDicCategory;
    }

    @Override
    public PageList<TSysDicCategory> list(TSysDicCategory tSysDicCategory,BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNo(),baseRequest.getPageSize());
        return new PageList<TSysDicCategory>(tSysDicCategoryMapper.select(tSysDicCategory));
    }
}
