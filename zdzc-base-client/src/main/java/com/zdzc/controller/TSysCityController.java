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
 * Author : 李琳青
 * Date : 2019-08-07 18:42
 */
@RestController
@RequestMapping("/t/sys/city")
@Api(description = "接口描述")
public class TSysCityController {
    @Resource
    private FeignTSysCityService feigntSysCityService;

    @PostMapping
    @ApiOperation("新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parameter", value = "参数", required = false, paramType = "query")
    })
    public void add(@ApiIgnore TSysCity tSysCity){
        feigntSysCityService.add(tSysCity);
    }

    @DeleteMapping
    @ApiOperation("删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键Id", required = true, paramType = "query")
    })
    public void delete(String id){
        feigntSysCityService.delete(id);
    }

    @PutMapping
    @ApiOperation("更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parameter", value = "参数", required = false, paramType = "query")
    })
    public void update(@ApiIgnore TSysCity tSysCity){
        feigntSysCityService.update(tSysCity);
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


    @GetMapping("/selectCityListByProvinceId")
    @ApiOperation("分页查询")
    public List<TSysCity> cityList(Integer provinceId) {
        return feigntSysCityService.selectCityList(provinceId);
    }

}
