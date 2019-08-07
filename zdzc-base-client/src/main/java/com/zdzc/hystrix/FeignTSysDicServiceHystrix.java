package com.zdzc.hystrix;

import com.zdzc.common.PageList;
import com.zdzc.model.TSysDic;
import org.springframework.stereotype.Component;
import com.zdzc.service.FeignTSysDicService;


/**
 * Author : 李琳青
 * Date : 2019-08-06 13:41
 */
@Component
public  class FeignTSysDicServiceHystrix implements FeignTSysDicService {


    @Override
    public int add(TSysDic tSysDic) {
        return 0;
    }

    @Override
    public int delete(String id) {
        return 0;
    }

    @Override
    public int update(TSysDic tSysDic) {
        return 0;
    }

    @Override
    public TSysDic findById(String id) {
        return null;
    }

    @Override
    public PageList<TSysDic> list(TSysDic tSysDic) {
        return null;
    }
}
