package com.zdzc.controller;

import com.zdzc.model.TSysArea;
import com.zdzc.model.TSysCity;
import com.zdzc.model.TSysProvince;
import com.zdzc.service.FeignTSysProvinceService;
import io.swagger.models.auth.In;
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
 * Author : 李琳青
 * Date : 2019-08-07 16:42
 */
@RestController
@RequestMapping("/province")
@Api(description = "省份接口API")
public class TSysProvinceController {
    @Resource
    private FeignTSysProvinceService feigntSysProvinceService;

    @PostMapping
    @ApiOperation("新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parameter", value = "参数", required = false, paramType = "query")
    })
    public void add(@ApiIgnore TSysProvince tSysProvince){
        feigntSysProvinceService.add(tSysProvince);
    }

    @DeleteMapping
    @ApiOperation("删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键Id", required = true, paramType = "query")
    })
    public void delete(String id){
        feigntSysProvinceService.delete(id);
    }

    @PutMapping
    @ApiOperation("更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parameter", value = "参数", required = false, paramType = "query")
    })
    public void update(@ApiIgnore TSysProvince tSysProvince){
        feigntSysProvinceService.update(tSysProvince);
    }

    @GetMapping("/findById")
    @ApiOperation("获取详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键Id", required = true, paramType = "query")
    })
    public TSysProvince detail(String id){
        return feigntSysProvinceService.findById(id);
    }

   /* @GetMapping
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数，默认1", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示，默认10，传0查全部", required = false, paramType = "query")
    })
    public PageList<TSysProvince> list(@ApiIgnore TSysProvince tSysProvince) {
        return feigntSysProvinceService.list(tSysProvince);
    }*/


    @GetMapping("/selectProvinceList")
    @ApiOperation("分页查询")
    public List<TSysProvince> provinceList() {
        return feigntSysProvinceService.provinceList();
    }

    @GetMapping("/selectCityListByProvinceId")
    @ApiOperation("分页查询")
    public List<TSysCity> cityList(Integer provinceId) {
        return feigntSysProvinceService.selectCityList(provinceId);
    }

    @GetMapping("/selectAreaListByCityId")
    @ApiOperation("分页查询")
    public List<TSysArea> areaList(Integer cityId) {
        return feigntSysProvinceService.selectAreaList(cityId);
    }

}
