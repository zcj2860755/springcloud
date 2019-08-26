package com.zdzc.service.impl;

import com.zdzc.dao.TSysParamsMapper;
import com.zdzc.enums.ExceptionEnum;
import com.zdzc.model.TSysParams;
import com.zdzc.service.ITSysParamsService;
import com.zdzc.utils.BaseException;
import com.zdzc.utils.UUIDUtils;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.zdzc.common.PageList;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * Author : zhuqilong
 * Date : 2019-08-13 14:02
 */
@Service
public class TSysParamsServiceImpl implements ITSysParamsService {
    @Resource
    private TSysParamsMapper tSysParamsMapper;

    @Override
    public int save(TSysParams tSysParams) {
        //新增系统参数，保证系统参数的Key唯一
        TSysParams temp = new TSysParams();
        temp.setParamsKey(tSysParams.getParamsKey());
        if(tSysParamsMapper.selectCount(temp)>0){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSKEY_EXIST);
        }
        tSysParams.setId(UUIDUtils.getUUID());
        return tSysParamsMapper.insertSelective(tSysParams);
    }

    @Override
    public int update(TSysParams tSysParams) {
        //系统参数修改后，保证系统参数的Key唯一
        TSysParams temp = new TSysParams();
        temp.setParamsKey(tSysParams.getParamsKey());
        temp.setId(tSysParams.getId());
        if(tSysParamsMapper.selectCountByKey(temp)>0){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSKEY_EXIST);
        }
        return tSysParamsMapper.updateByPrimaryKeySelective(tSysParams);
    }

    @Override
    public int deleteById(String id){
        return tSysParamsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TSysParams findById(String id){
        return tSysParamsMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageList<TSysParams> pageList(TSysParams tSysParams, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        return new PageList<>(tSysParamsMapper.selectPageList(tSysParams));
    }
}
