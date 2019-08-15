package com.zdzc.controller;

import com.zdzc.model.TSysArea;
import com.zdzc.service.FeignTSysAreaService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;
import com.zdzc.common.PageList;

import java.util.List;


/**
 * Description : 省市区API接口
 * Author : 李琳青
 * Date : 2019-08-09 11:06
 */
@RestController
@RequestMapping("/area")
@Api(description = "省市区API接口")
public class TSysAreaController {
    @Resource
    private FeignTSysAreaService feigntSysAreaService;

    @PostMapping
    @ApiOperation("新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parentId", value = "父id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "name", value = "区域名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "shortName", value = "简写名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "level", value = "区域等级", required = true, paramType = "query"),
            //@ApiImplicitParam(name = "pathIds", value = "父类ids", required = true, paramType = "query"),
    })
    public int add(@ApiIgnore TSysArea tSysArea){
        return feigntSysAreaService.add(tSysArea);
    }

    @DeleteMapping
    @ApiOperation("删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query")
    })
    public int delete(String id){
        return feigntSysAreaService.delete(id);
    }

    @PutMapping
    @ApiOperation("更新")// --跨省修改有问题,提升地区等级也会有问题 子类level不变  一般不会操作
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "parentId", value = "父id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "name", value = "区域名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "shortName", value = "简写名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "level", value = "区域等级", required = true, paramType = "query"),
            //@ApiImplicitParam(name = "pathIds", value = "父类ids", required = true, paramType = "query"),
    })
    public int update(@ApiIgnore TSysArea tSysArea){
        return feigntSysAreaService.update(tSysArea);
    }



    @PostMapping("/selectProvinceCityAreaList")
    @ApiOperation("省市区查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "省份/城市/区id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "mark", value = "标记 1.省份 2.城市 3.区域 4.镇、街道 ", required = true, paramType = "query"),
    })
    public List<TSysArea> selectProvinceCityAreaList(@ApiIgnore TSysArea tSysArea) {
        return feigntSysAreaService.selectProvinceCityAreaList(tSysArea);
    }



}
