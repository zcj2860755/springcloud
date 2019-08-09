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
 * description : 区域接口API
 * Author : 李琳青
 * Date : 2019-08-07 19:16
 */
@RestController
@RequestMapping("/area")
public class TSysAreaController {
    @Resource
    private ITSysAreaService tSysAreaService;

    @PostMapping
    @ApiOperation("新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cityId", value = "城市id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "name", value = "区域名称", required = true, paramType = "query"),
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
    @ApiOperation("更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "cityId", value = "城市id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "name", value = "区域名称", required = true, paramType = "query"),
    })
    public int update(@RequestBody TSysArea tSysArea){
       return tSysAreaService.update(tSysArea);
    }

    @GetMapping("/findById")
    public TSysArea detail(@RequestParam("id") String id){
        return tSysAreaService.findById(id);
    }

    @GetMapping("pageList")
    public PageList<TSysArea> pageList(@RequestBody TSysArea tSysArea,BaseRequest baseRequest) {
        return tSysAreaService.list(tSysArea,baseRequest);
    }

    @PostMapping("/selectAreaList")
    @ApiOperation("select区域list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cityId", value = "省份id", required = true, paramType = "query")
    })
    public List<TSysArea> selectAreaList(@RequestParam("cityId") Integer cityId) {
        return tSysAreaService.selectAreaList(cityId);
    }

}
