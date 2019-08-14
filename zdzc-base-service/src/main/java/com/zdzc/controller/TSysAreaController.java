package com.zdzc.controller;

import com.zdzc.common.BaseRequest;
import com.zdzc.model.TSysArea;
import com.zdzc.service.ITSysAreaService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import com.zdzc.common.PageList;

import javax.annotation.Resource;
import java.util.List;


/**
 * Description : 省市区API接口
 * Author : 李琳青
 * Date : 2019-08-09 11:06
 */
@RestController
@RequestMapping("/area")
public class TSysAreaController {
    @Resource
    private ITSysAreaService tSysAreaService;

    @PostMapping
    @ApiOperation("新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parentId", value = "父id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "name", value = "区域名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "shortName", value = "简写名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "level", value = "区域等级", required = true, paramType = "query"),
            //@ApiImplicitParam(name = "pathIds", value = "父类ids", required = true, paramType = "query"),
    })
    public int add(@RequestBody TSysArea tSysArea){
        return tSysAreaService.save(tSysArea);
    }

    @DeleteMapping
    @ApiOperation("删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query")
    })
    public int delete(@RequestParam("id") String id){
       return tSysAreaService.deleteById(id);
    }

    @PutMapping
    @ApiOperation("更新")//不支持跨省修改
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "parentId", value = "父id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "name", value = "区域名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "shortName", value = "简写名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "level", value = "区域等级", required = true, paramType = "query"),
            //@ApiImplicitParam(name = "pathIds", value = "父类ids", required = true, paramType = "query"),
    })
    public int update(@RequestBody TSysArea tSysArea){
       return tSysAreaService.update(tSysArea);
    }

    @GetMapping("/findById")
    public TSysArea detail(@RequestParam("id") String id){
        return tSysAreaService.findById(id);
    }

    @PostMapping("/pageList")
    public PageList<TSysArea> pageList(@RequestBody TSysArea tSysArea,BaseRequest baseRequest) {
        return tSysAreaService.pageList(tSysArea,baseRequest);
    }

    @PostMapping("/selectProvinceList")
    public List<TSysArea> selectProvinceList() {
        return tSysAreaService.selectProvinceList();
    }

    @PostMapping("/selectCityList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "provinceId", value = "省份id", required = true, paramType = "query")
    })
    public List<TSysArea> selectCityList(@RequestParam("provinceId") Integer provinceId) {
        return tSysAreaService.selectCityList(provinceId);
    }

    @PostMapping("/selectAreaList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cityId", value = "城市id", required = true, paramType = "query")
    })
    public List<TSysArea> selectAreaList(@RequestParam("cityId") Integer cityId) {
        return tSysAreaService.selectAreaList(cityId);
    }

    @PostMapping("/selectTownList")
    @ApiOperation("街道、城镇list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "areaId", value = "区域id", required = true, paramType = "query")
    })
    public List<TSysArea> selectTownList(@RequestParam("areaId") Integer areaId) {
        return tSysAreaService.selectTownList(areaId);
    }

}
