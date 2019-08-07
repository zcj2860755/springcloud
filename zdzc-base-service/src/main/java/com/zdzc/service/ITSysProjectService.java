package com.zdzc.service;


import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;
import com.zdzc.model.TSysProject;

import java.util.List;

/**
 * Created by zahngchangjiang on 2018/12/14.
 */
public interface ITSysProjectService {

    int countByExample(TSysProject tSysProject);

    int deleteByExample(TSysProject tSysProject);

    /**
     * 删除系统项目
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    int insert(TSysProject tSysProject);

    /**
     *
     * @Description: 添加项目
     * @auther:   zcj
     * @date:     2018/12/14
     * @param:    [tSysRole]
     * @return:   int
     *
     */
    int insertSelective(TSysProject tSysProject);


    List<TSysProject> selectByExample(TSysProject tSysProject);


    /**
     * 项目分页查询
     * @param tSysProject
     * @return
     */
    PageList<TSysProject> selectParamsList(TSysProject tSysProject, BaseRequest baseRequest);

    /**
     * 获取项目详情
     * @param id
     * @return
     */
    TSysProject selectByPrimaryKey(String id);

    int updateByExampleSelective(TSysProject tSysProject);

    int updateByExample(TSysProject tSysProject, TSysProject tSysProjectChange);

    int updateByPrimaryKeySelective(TSysProject tSysProject);

    int updateByPrimaryKey(TSysProject tSysProject);

    List<String> selectProjectByIdAndCascade(TSysProject tSysProject);

}
