package com.zdzc.service;


import com.zdzc.common.PageList;
import com.zdzc.enums.ExceptionEnum;
import com.zdzc.model.TSysProject;
import com.zdzc.model.TSysRole;
import com.zdzc.utils.BaseException;
import com.zdzc.utils.ObjectUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@FeignClient(value = "base-service")
public interface FeignTSysProjectService {
    /**
     * @Author  zcj
     * @Description  新增
     * @Date 17:51 2019/8/8
     * @Param [tSysProject]
     * @return void
     **/
    @PostMapping("/project")
    void add(@RequestBody TSysProject tSysProject);
    /**
     * @Author  zcj
     * @Description //删除
     * @Date 17:53 2019/8/8
     * @Param [id]
     * @return void
     **/
    @DeleteMapping("/project/{id}")
    void delete(@PathVariable(value = "id") String id);
    /**
     * @Author  zcj
     * @Description //更新
     * @Date 17:54 2019/8/8
     * @Param [tSysProject]
     * @return void
     **/
    @PutMapping("/project")
    void update(@RequestBody TSysProject tSysProject) ;
    /**
     * @Author  zcj
     * @Description 获取详情
     * @Date 17:54 2019/8/8
     * @Param [id]
     * @return com.zdzc.model.TSysProject
     **/
    @GetMapping("/project/{id}")
    TSysProject detail(@PathVariable(value = "id") String id);
    /**
     * @Author  zcj
     * @Description 分页查询
     * @Date 17:55 2019/8/8
     * @Param [tSysProject]
     * @return com.zdzc.common.PageList<com.zdzc.model.TSysProject>
     **/
    @PostMapping("/project/pageList")
    PageList<TSysProject> list(@RequestBody TSysProject tSysProject);
    /**
     * @Author  zcj
     * @Description 查询所有
     * @Date 17:55 2019/8/8
     * @Param [tSysProject]
     * @return java.util.List<com.zdzc.model.TSysProject>
     **/
    @PostMapping("/project/findList")
    List<TSysProject> findAlllist(@RequestBody TSysProject tSysProject) ;

    /**
     * @Author  zcj
     * @Description //修改时查询所有
     * @Date 17:56 2019/8/8
     * @Param [tSysProject]
     * @return java.util.List<com.zdzc.model.TSysProject>
     **/
    @PostMapping("/project/edit/findList")
    List<TSysProject> editFindAlllist(@RequestBody TSysProject tSysProject);


}
