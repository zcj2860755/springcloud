package com.zdzc.service.impl;

import com.github.pagehelper.PageHelper;
import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;
import com.zdzc.dao.TSysDicCategoryMapper;
import com.zdzc.dao.TSysDicMapper;


import com.zdzc.enums.ExceptionEnum;
import com.zdzc.model.TSysDic;
import com.zdzc.model.TSysDicCategory;
import com.zdzc.service.ITSysDicService;
import com.zdzc.utils.BaseException;
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

    @Override
    public int insert(TSysDic tSysDic) {
        //categoryId + key查询是否有数据
        int count = tSysDicMapper.selectCountBykeyAndCategory(tSysDic);
        if(count != 0){
            throw new BaseException(ExceptionEnum.SYSTEM_DICKEY_EXIST);
        }
        tSysDic.setId(UUIDUtils.getUUID());
        return tSysDicMapper.insert(tSysDic);
    }

    @Override
    public int delete(String id) {
        return tSysDicMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(TSysDic tSysDic) {
        return tSysDicMapper.updateByPrimaryKey(tSysDic);
    }


    @Override
    public TSysDic findById(String id) {
        return tSysDicMapper.selectTSysDicWithCatergory(id);
    }

    @Override
    public PageList<TSysDic> list(TSysDic tSysDic, Integer pageNo,Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<TSysDic> tSysDicList = tSysDicMapper.selectAllDic(tSysDic);
        return new PageList<TSysDic>(tSysDicList);
    }



}
