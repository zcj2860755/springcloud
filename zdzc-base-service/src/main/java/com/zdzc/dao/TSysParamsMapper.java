package com.zdzc.dao;

import com.zdzc.core.Mapper;
import com.zdzc.model.TSysParams;

import java.util.List;

public interface TSysParamsMapper extends Mapper<TSysParams> {
    /**
     * @Author  zhuqilong
     * @Description 系统参数分页查询
     * @Date 9:51 2019/8/20
     * @Param
     * @return
    */
    List<TSysParams> selectPageList(TSysParams tSysParams);

    /**
     * @Author  zhuqilong
     * @Description 查询除去某个ID外的系统参数key的数量，
     * @Date 10:14 2019/8/20
     * @Param
     * @return
    */
    int selectCountByKey(TSysParams tSysParams);
}
