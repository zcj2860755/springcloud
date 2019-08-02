package com.zdzc.service.impl;

import com.zdzc.dao.TSysDicMapper;
import com.zdzc.model.TSysDic;
import com.zdzc.service.ITSysDicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zcj on 2019/08/01.
 */
@Service
public class TSysDicServiceImpl implements ITSysDicService {
    @Resource
    private TSysDicMapper tSysDicMapper;

    @Override
    public List<TSysDic> findTest() {
        return tSysDicMapper.selectAll();
    }

    @Override
    public int add(TSysDic test) {
        return tSysDicMapper.insert(test);
    }
}
