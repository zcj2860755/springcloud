package com.zdzc.dao;

import com.zdzc.core.Mapper;
import com.zdzc.model.TSysProject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TSysProjectMapper extends Mapper<TSysProject> {

    /**
     * 通过内容查询项目
     * @param tSysProject
     * @return
     */
    List<TSysProject> selectParamsBySreach(TSysProject tSysProject);


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

    /**
     * 通过项目Id拼接项目名称
     * @param ids
     * @return
     */
    String selectProjectAllPath(@Param("ids") String [] ids, @Param("seperator") String seperator);
}
