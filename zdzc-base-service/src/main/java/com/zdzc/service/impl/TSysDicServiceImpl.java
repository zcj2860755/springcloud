package com.zdzc.service.impl;

import com.github.pagehelper.PageHelper;
import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;
import com.zdzc.dao.TSysDicCategoryMapper;
import com.zdzc.dao.TSysDicMapper;


import com.zdzc.model.TSysDic;
import com.zdzc.model.TSysDicCategory;
import com.zdzc.service.ITSysDicService;
import com.zdzc.utils.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author : 李琳青
 * Date : 2019-08-06 13:41
 */
@Service
public  class TSysDicServiceImpl implements ITSysDicService {
    @Resource
    private TSysDicMapper tSysDicMapper;

    @Resource
    private TSysDicCategoryMapper tSysDicCategoryMapper;

    @Override
    @Transactional
    public int insert(TSysDic tSysDic) {
        tSysDic.setId(UUIDUtils.getUUID());
        tSysDic.setIsEnable(1);
        int insert = tSysDicMapper.insert(tSysDic);
        System.out.println("是否插入字典表:"+insert);
        TSysDicCategory tSysDicCategory = tSysDicCategoryMapper.selectByPrimaryKey((tSysDic.getCategoryId()));
        tSysDicCategory.setDicValue(tSysDic.getCategoryDirValue());
        int update = tSysDicCategoryMapper.updateByPrimaryKey(tSysDicCategory);
        System.out.println("是否修改:"+update);
        return insert+update;
    }

    @Override
    public int delete(String id) {
        int delete = tSysDicMapper.deleteByPrimaryKey(id);
        System.out.println(delete);
        return delete;
    }

    @Override
    @Transactional
    public int update(TSysDic tSysDic) {
        int update1 = tSysDicMapper.updateByPrimaryKey(tSysDic);
        System.out.println("是否修改了字典表:"+update1);
        TSysDicCategory category = tSysDicCategoryMapper.selectByPrimaryKey(tSysDic.getCategoryId());
        category.setDicKey(tSysDic.getCategoryDirKey());
        category.setDicValue(tSysDic.getCategoryDirValue());
        int key = tSysDicCategoryMapper.updateByPrimaryKey(category);
        System.out.println("是否修改类别表:"+key);
        return update1+key;
    }

    @Override
    public TSysDic findById(String id) {
        return tSysDicMapper.selectTSysDicWithCatergory(id);
    }

    @Override
    public PageList<TSysDic> list(TSysDic tSysDic, BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNo(),baseRequest.getPageSize());
        List<TSysDic> tSysDicList = tSysDicMapper.selectAllDic(tSysDic);
        return new PageList<TSysDic>(tSysDicList);
    }



}
