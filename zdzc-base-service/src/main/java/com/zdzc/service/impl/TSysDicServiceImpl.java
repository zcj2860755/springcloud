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
    public int insert(TSysDic tSysDic) {
        List<TSysDic> dicList = tSysDicMapper.select(tSysDic);
        for (TSysDic sysDic : dicList) {
           if(sysDic.getDicKey().equals(tSysDic.getDicKey())){
               System.out.println("数据库里已经有相同的dic_key");
               return 0;
           }
        }
        tSysDic.setId(UUIDUtils.getUUID());
        //tSysDic.setIsEnable(1);
        int insert = tSysDicMapper.insert(tSysDic);
        System.out.println("是否插入字典表:"+insert);
        return insert;
    }

    @Override
    public int delete(String id) {
        int delete = tSysDicMapper.deleteByPrimaryKey(id);
        System.out.println(delete);
        return delete;
    }

    @Override
    public int update(TSysDic tSysDic) {
        int update = tSysDicMapper.updateByPrimaryKey(tSysDic);
        System.out.println("是否修改了字典表:"+update);
        return update;
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
