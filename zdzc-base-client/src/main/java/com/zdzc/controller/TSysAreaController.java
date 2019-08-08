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
 * description : 区域接口API
 * Author : 李琳青
 * Date : 2019-08-07 19:16
 */
@RestController
@RequestMapping("/area")
@Api(description = "接口描述")
public class TSysAreaController {
    @Resource
    private FeignTSysAreaService feigntSysAreaService;

    @PostMapping
    @ApiOperation("新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cityId", value = "城市id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "name", value = "区域名称", required = true, paramType = "query"),
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
    @ApiOperation("更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "cityId", value = "城市id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "name", value = "区域名称", required = true, paramType = "query"),
    })
    public int update(@ApiIgnore TSysArea tSysArea){
         return feigntSysAreaService.update(tSysArea);
    }

    @GetMapping("/findById")
    @ApiOperation("获取详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键Id", required = true, paramType = "query")
    })
    public TSysArea detail(String id){
        return feigntSysAreaService.findById(id);
    }

    @GetMapping
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数，默认1", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示，默认10，传0查全部", required = false, paramType = "query")
    })
    public PageList<TSysArea> pageList(@ApiIgnore TSysArea tSysArea) {
        return feigntSysAreaService.list(tSysArea);
    }



    @PostMapping("/selectAreaListByCityId")
    @ApiOperation("select区域list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cityId", value = "省份id", required = true, paramType = "query")
    })
    public List<TSysArea> areaList(Integer cityId) {
        return feigntSysAreaService.selectAreaList(cityId);
    }

}
