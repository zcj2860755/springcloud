package com.zdzc.hystrix;

import com.zdzc.common.PageList;
import com.zdzc.model.TSysDicCategory;
import org.springframework.stereotype.Component;
import com.zdzc.service.FeignTSysDicCategoryService;


/**
 * Author : 李琳青
 * Date : 2019-08-06 19:08
 */
@Component
public abstract class FeignTSysDicCategoryServiceHystrix implements FeignTSysDicCategoryService {
    @Override
    public int add(TSysDicCategory tSysDicCategory) {
        return 0;
    }

    @Override
    public int delete(String id) {
        return 0;
    }

    @Override
    public int update(TSysDicCategory tSysDicCategory) {
        return 0;
    }

    @Override
    public TSysDicCategory findById(String id) {
        return null;
    }

    @Override
    public PageList<TSysDicCategory> pageList(TSysDicCategory tSysDicCategory, Integer pageNo, Integer pageSize) {
        return null;
    }
}
