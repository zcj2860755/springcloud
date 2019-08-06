package com.zdzc.service.impl;

import com.zdzc.dao.TSysDicCategoryMapper;
import com.zdzc.model.TSysDicCategory;
import com.zdzc.service.ITSysDicCategoryService;
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
        return tSysDicCategoryMapper.insertSelective(tSysDicCategory);
    }

    @Override
    public int update(TSysDicCategory tSysDicCategory) {
        return tSysDicCategoryMapper.updateByPrimaryKeySelective(tSysDicCategory);
    }

    @Override
    public int deleteById(String id){
        return tSysDicCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TSysDicCategory findById(String id){
        return tSysDicCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageList<TSysDicCategory> list(TSysDicCategory tSysDicCategory,BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNo(),baseRequest.getPageSize());
        return new PageList<TSysDicCategory>(tSysDicCategoryMapper.select(tSysDicCategory));
    }
}
