package com.zdzc.dao;

import com.zdzc.core.Mapper;
import com.zdzc.model.TSysProject;

import java.util.List;

public interface TSysProjectMapper extends Mapper<TSysProject> {

    /**
     * 通过内容查询项目
     * @param tSysProject
     * @return
     */
    List<TSysProject> selectParamsBySreach(TSysProject tSysProject);

    /**
     *
     * @Description: 更新项目信息
     * @auther:   zcj
     * @date:     2018/12/19
     * @param:    [tSysProject]
     * @return:   int
     *
     */
    int updateByExampleSelective(TSysProject tSysProject);


    List<TSysProject> selectParamsNot(TSysProject tSysProject);

    /**
     * 通过Id获取本级级子级所有项目Id
     * @param tSysProject
     * @return
     */
    List<String> selectProjectByIdAndCascade(TSysProject tSysProject);

    /**
     * 通过项目名称查询数量
     * @return
     */
    int selectProjectNameCount(TSysProject proParams);
}
