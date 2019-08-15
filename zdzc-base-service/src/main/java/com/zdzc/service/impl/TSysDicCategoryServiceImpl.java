package com.zdzc.service.impl;

import com.zdzc.dao.TSysDicCategoryMapper;
import com.zdzc.dao.TSysDicMapper;
import com.zdzc.enums.ExceptionEnum;
import com.zdzc.model.TSysDic;
import com.zdzc.model.TSysDicCategory;
import com.zdzc.service.ITSysDicCategoryService;
import com.zdzc.utils.BaseException;
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
        //判断字典编码是否重复
        List<TSysDicCategory> list = tSysDicCategoryMapper.selectListByDicKey(tSysDicCategory);
        if(list != null && list.size() > 0 ){
            throw new BaseException(ExceptionEnum.DIC_KEY_NAMEEXIST);
        }
        tSysDicCategory.setId(UUIDUtils.getUUID());
        return tSysDicCategoryMapper.insertSelective(tSysDicCategory);
    }


    @Override
    public int deleteById(String id){
        int count = tSysDicMapper.selectDicCountByCategoryId(id);
        if(count !=0){
            throw new BaseException(ExceptionEnum.POWER_CHILD_EXIST);
        }
        return tSysDicCategoryMapper.deleteByPrimaryKey(id);
    }


    @Override
    public int update(TSysDicCategory tSysDicCategory) {
        int update = tSysDicCategoryMapper.updateByPrimaryKeySelective(tSysDicCategory);
        System.out.println("是否修改:"+update);
        return update;
    }


    @Override
    public PageList<TSysDicCategory> list(TSysDicCategory tSysDicCategory,Integer pageNo,Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<TSysDicCategory> list = tSysDicCategoryMapper.selectDicCategoryList(tSysDicCategory);
        //查询每一个类别里字典小类数量
        for (TSysDicCategory category : list) {
            int count = tSysDicMapper.selectDicCountByCategoryId(category.getId());
            category.setDicCount(count);
        }
        return new PageList<TSysDicCategory>(list);
    }
}
