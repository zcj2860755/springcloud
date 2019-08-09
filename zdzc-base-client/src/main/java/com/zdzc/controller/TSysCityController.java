package com.zdzc.controller;

import com.zdzc.model.TSysCity;
import com.zdzc.model.TSysProvince;
import com.zdzc.service.FeignTSysCityService;
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
 * description : 城市接口API
 * Author : 李琳青
 * Date : 2019-08-07 18:42
 */
@RestController
@RequestMapping("/city")
@Api(description = "城市接口API")
public class TSysCityController {
    @Resource
    private FeignTSysCityService feigntSysCityService;

    @PostMapping
    @ApiOperation("新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "provinceId", value = "省份id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "name", value = "城市名称", required = true, paramType = "query"),
    })
    public int add(@ApiIgnore TSysCity tSysCity){
        return feigntSysCityService.add(tSysCity);
    }

    @DeleteMapping
    @ApiOperation("删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query")
    })
    public int delete(String id){
          return feigntSysCityService.delete(id);
    }

    @PutMapping
    @ApiOperation("更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "provinceId", value = "省份id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "name", value = "城市名称", required = true, paramType = "query"),
    })
    public int update(@ApiIgnore TSysCity tSysCity){
         return feigntSysCityService.update(tSysCity);
    }

    @PostMapping("/selectCityListByProvinceId")
    @ApiOperation("select城市list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "provinceId", value = "省份id", required = true, paramType = "query")
    })
    public List<TSysCity> cityList(Integer provinceId) {
        return feigntSysCityService.selectCityList(provinceId);
    }






    @GetMapping("/findById")
    @ApiOperation("获取详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键Id", required = true, paramType = "query")
    })
    public TSysCity detail(String id){
        return feigntSysCityService.findById(id);
    }

    @GetMapping
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数，默认1", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示，默认10，传0查全部", required = false, paramType = "query")
    })
    public PageList<TSysCity> list(@ApiIgnore TSysCity tSysCity) {
        return feigntSysCityService.list(tSysCity);
    }




}
