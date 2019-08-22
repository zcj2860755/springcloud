package com.zdzc.service;


import com.zdzc.common.PageList;
import com.zdzc.model.TSysProject;

import java.util.List;

/**
 * Created by zahngchangjiang on 2018/12/14.
 */
public interface ITSysProjectService {
    /**
     * 删除系统项目
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * @Author  zhuqilong
     * @Description 新增项目
     * @Date 17:07 2019/8/22
     * @Param
     * @return
    */
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


   /**
    * @Author  zhuqilong
    * @Description 项目树展示反显
    * @Date 11:59 2019/8/22
    * @Param
    * @return
   */
    List<TSysProject> selectByExample(TSysProject tSysProject);


    /**
     * 项目分页查询
     * @param tSysProject
     * @return
     */
    PageList<TSysProject> selectParamsList(TSysProject tSysProject);

    /**
     * 获取项目详情
     * @param id
     * @return
     */
    TSysProject selectByPrimaryKey(String id);

    /**
     * @Author  zhuqilong
     * @Description 更新项目
     * @Date 17:07 2019/8/22
     * @Param
     * @return
    */
    int updateByPrimaryKeySelective(TSysProject tSysProject);

    List<String> selectProjectByIdAndCascade(TSysProject tSysProject);

    /**
     * @Author  zhuqilong
     * @Description 通过项目Id拼接项目名称
     * @Date 11:42 2019/8/22
     * @Param
     * @return
    */
    String selectProjectAllPath(String [] ids,String seperator);


    /**
     * 获取项目详情
     * @param id
     * @return
     */
    TSysProject selectProjectById(String id);
}
