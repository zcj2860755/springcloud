package com.zdzc.service.impl;

import com.zdzc.dao.TSysDicCategoryMapper;
import com.zdzc.dao.TSysDicMapper;
import com.zdzc.model.TSysDicCategory;
import com.zdzc.service.ITSysDicCategoryService;
import com.zdzc.utils.UUIDUtils;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author : 李琳青
 * Date : 2019-08-06 19:08
 */
@Service
public class TSysDicCategoryServiceImpl implements ITSysDicCategoryService {
    @Resource
    private TSysDicCategoryMapper tSysDicCategoryMapper;
    @Resource
    private TSysDicMapper tSysDicMapper;

    @Override
    public int save(TSysDicCategory tSysDicCategory) {
        //查询出类别表里是否有相同的key  有就返回0,否则返回1
        List<TSysDicCategory> dicCategories = tSysDicCategoryMapper.select(tSysDicCategory);
        for (TSysDicCategory dicCategory : dicCategories) {
           if(dicCategory.getDicKey().equals(tSysDicCategory.getDicKey())){
               System.out.println("数据库里已经有相同的dic_key");
                return 0;
            }
        }
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
        List<TSysDicCategory> list = tSysDicCategoryMapper.selectDicCategoryList(tSysDicCategory);
        //查询每一个类别里字典小类数量
        for (TSysDicCategory category : list) {
            int count = tSysDicMapper.selectDicCountByCategoryId(category.getId());
            category.setDicCount(count);
        }
        return new PageList<TSysDicCategory>(list);
    }
}
