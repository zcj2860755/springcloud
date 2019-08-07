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
    public String add(TSysDic tSysDic) {
        return null;
    }

    @Override
    public String delete(TSysDic tSysDic) {
        return null;
    }

    @Override
    public String update(TSysDic tSysDic) {
        return null;
    }

    @Override
    public String findById(){
        return "service has fail!";
    }

    @Override
    public PageList<TSysDic> list(TSysDic tSysDic) {
        return null;
    }
}
