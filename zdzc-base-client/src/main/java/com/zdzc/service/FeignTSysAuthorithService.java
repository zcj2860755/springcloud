package com.zdzc.service;


import com.zdzc.common.PageList;
import com.zdzc.model.TSysAuthority;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@FeignClient(value = "base-service")
public interface FeignTSysAuthorithService {

    /**
     *
     * @Author  zcj
     * @Description 新增
     * @Date 10:36 2019/8/9
     * @Param [tSysAuthority]
     * @return void
     **/
    @PostMapping("/authority")
    @ApiOperation("新增")
    void add(@ApiIgnore TSysAuthority tSysAuthority);
    /**
     *
     * @Author  zcj
     * @Description 删除
     * @Date 10:37 2019/8/9
     * @Param [id]
     * @return void
     **/
    @DeleteMapping("/authority/{id}")
    @ApiOperation("删除")
    void delete(@PathVariable(value = "id") String id) ;
    /**
     *
     * @Author  zcj
     * @Description 更新
     * @Date 10:38 2019/8/9
     * @Param [tSysAuthority]
     * @return void
     **/
    @PutMapping("/authority")
    @ApiOperation("更新")
    void update(@ApiIgnore TSysAuthority tSysAuthority);
    /**
     *
     * @Author  zcj
     * @Description 获取详情
     * @Date 10:38 2019/8/9
     * @Param [id]
     * @return com.zdzc.model.TSysAuthority
     **/
    @GetMapping("/authority/{id}")
    @ApiOperation("获取详情")
    TSysAuthority detail(@PathVariable(value = "id") String id);
    /**
     *
     * @Author  zcj
     * @Description 分页查询
     * @Date 10:38 2019/8/9
     * @Param [tSysAuthority]
     * @return com.zdzc.common.PageList<com.zdzc.model.TSysAuthority>
     **/
    @PostMapping("/authority/pageList")
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示", required = false, paramType = "query"),
            @ApiImplicitParam(name = "searchContent", value = "查询内容", required = false, paramType = "query")
    })
    PageList<TSysAuthority> list(@RequestBody TSysAuthority tSysAuthority);
    /**
     *
     * @Author  zcj
     * @Description 查询当前用户的所有权限
     * @Date 10:39 2019/8/9
     * @Param [tSysAuthority]
     * @return java.util.List<com.zdzc.model.TSysAuthority>
     **/
    @PostMapping("/authority/getRoleAuth")
    @ApiOperation("查询当前用户的所有权限")
    List<TSysAuthority> getRoleAuthList(@RequestBody TSysAuthority tSysAuthority);

    /**
     *
     * @Author  zcj
     * @Description 查询所有权限
     * @Date 10:39 2019/8/9
     * @Param []
     * @return java.util.List<com.zdzc.model.TSysAuthority>
     **/
    @PostMapping("/authority/List")
    @ApiOperation("查询所有权限")
    List<TSysAuthority> getAuthList();

    /**
     *
     * @Author  zcj
     * @Description 权限列表
     * @Date 10:40 2019/8/9
     * @Param [tSysAuthority]
     * @return com.zdzc.common.PageList<com.zdzc.model.TSysAuthority>
     **/
    @PostMapping("/authority/getAllAuthList")
    @ApiOperation("权限列表")
    PageList<TSysAuthority> getAllAuthList(@RequestBody TSysAuthority tSysAuthority);

    /**
     *
     * @Author  zcj
     * @Description //黑白名单
     * @Date 10:41 2019/8/9
     * @Param [tSysAuthority]
     * @return java.util.List<com.zdzc.model.TSysAuthority>
     **/
    @PostMapping("/authority/existAuthSign")
    List<TSysAuthority> existAuthSign(@RequestBody TSysAuthority tSysAuthority);

    /**
     *
     * @Author  zcj
     * @Description 查询默认权限列表
     * @Date 10:42 2019/8/9
     * @Param [tSysAuthority]
     * @return java.util.List<java.lang.String>
     **/
    @PostMapping("/authority/defaultAuth")
    @ApiOperation("查询默认权限列表")
    List<String> defaultAuth(@RequestBody TSysAuthority tSysAuthority);


}
