package com.zdzc.controller;

import com.zdzc.model.TManagerUnit;
import com.zdzc.service.FeignTManagerUnitService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;
import com.zdzc.common.PageList;


/**
 * Description : 单位管理API接口
 * Author : 李琳青
 * Date : 2019-08-13 16:18
 */
@RestController
@RequestMapping("/manager/unit")
@Api(description = "单位管理API接口")
public class TManagerUnitController {
    @Resource
    private FeignTManagerUnitService feigntManagerUnitService;

    @PostMapping
    @ApiOperation("新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "单位名称", required = true, paramType = "query"),
            //@ApiImplicitParam(name = "code", value = "单位名称", required = true, paramType = "query"), //单位编号是生成的？
            @ApiImplicitParam(name = "address", value = "单位地址", required = true, paramType = "query"),
            @ApiImplicitParam(name = "areaId", value = "所属区域", required = true, paramType = "query"),
            @ApiImplicitParam(name = "longAddress", value = "所属行政区域", required = true, paramType = "query"),
            @ApiImplicitParam(name = "creditCode", value = "统一信用码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "manager", value = "负责人", required = true, paramType = "query"),
            @ApiImplicitParam(name = "managerTelephone", value = "负责人电话", required = true, paramType = "query"),
            @ApiImplicitParam(name = "adminAreaId", value = "", required = true, paramType = "query"),
            @ApiImplicitParam(name = "province", value = "省份", required = true, paramType = "query"),
            @ApiImplicitParam(name = "city", value = "城市", required = true, paramType = "query"),
            @ApiImplicitParam(name = "district", value = "区", required = true, paramType = "query"),
            @ApiImplicitParam(name = "cityCode", value = "城市编码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "adcode", value = "区编码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "lon", value = "单位坐标-lon经度", required = false, paramType = "query"),
            @ApiImplicitParam(name = "lat", value = "单位坐标-lat纬度", required = false, paramType = "query"),
            @ApiImplicitParam(name = "createUser", value = "创建者", required = false, paramType = "query"),
    })
    public int add(@ApiIgnore TManagerUnit tManagerUnit){
        return feigntManagerUnitService.add(tManagerUnit);
    }

    @DeleteMapping
    @ApiOperation("删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query")
    })
    public int delete(String id){
        return feigntManagerUnitService.delete(id);
    }

    @PutMapping
    @ApiOperation("更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "name", value = "单位名称", required = true, paramType = "query"),
            //@ApiImplicitParam(name = "code", value = "单位名称", required = true, paramType = "query"), //单位编号是生成的？
            @ApiImplicitParam(name = "address", value = "单位地址", required = true, paramType = "query"),
            @ApiImplicitParam(name = "areaId", value = "所属区域", required = true, paramType = "query"),
            @ApiImplicitParam(name = "longAddress", value = "所属行政区域", required = true, paramType = "query"),
            @ApiImplicitParam(name = "creditCode", value = "统一信用码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "manager", value = "负责人", required = true, paramType = "query"),
            @ApiImplicitParam(name = "managerTelephone", value = "负责人电话", required = true, paramType = "query"),
            @ApiImplicitParam(name = "adminAreaId", value = "", required = true, paramType = "query"),
            @ApiImplicitParam(name = "province", value = "省份", required = true, paramType = "query"),
            @ApiImplicitParam(name = "city", value = "城市", required = true, paramType = "query"),
            @ApiImplicitParam(name = "district", value = "区", required = true, paramType = "query"),
            @ApiImplicitParam(name = "cityCode", value = "城市编码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "adcode", value = "区编码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "lon", value = "单位坐标-lon经度", required = false, paramType = "query"),
            @ApiImplicitParam(name = "lat", value = "单位坐标-lat纬度", required = false, paramType = "query"),
            @ApiImplicitParam(name = "updateUser", value = "创建者", required = false, paramType = "query"),
    })
    public int update(@ApiIgnore TManagerUnit tManagerUnit){
        return feigntManagerUnitService.update(tManagerUnit);
    }

    @GetMapping("/findById")
    @ApiOperation("获取详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query")
    })
    public TManagerUnit detail(String id){
        return feigntManagerUnitService.findById(id);
    }

    @PostMapping("/pageList")
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数，默认1", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示，默认10，传0查全部", required = false, paramType = "query"),
            @ApiImplicitParam(name = "keyWords", value = "查询内容", required = false, paramType = "query"),
            @ApiImplicitParam(name = "mark", value = "0.查询所有 1.按照单位编号 2.按单位名称", required = true, paramType = "query"),
    })
    public PageList<TManagerUnit> pageList(@ApiIgnore TManagerUnit tManagerUnit) {
        return feigntManagerUnitService.pageList(tManagerUnit);
    }
}
