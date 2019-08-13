package com.zdzc.controller;

import com.zdzc.model.PlaceInfo;
import com.zdzc.service.FeignPlaceInfoService;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;
import com.zdzc.common.PageList;


/**
 * Description :
 * Author : 李琳青
 * Date : 2019-08-12 19:47
 */
@RestController
@RequestMapping("/place/info")
@Api(description = "接口描述")
public class PlaceInfoController {
    @Resource
    private FeignPlaceInfoService feignplaceInfoService;

    @PostMapping
    @ApiOperation("新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "场所名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "type", value = "场所性质", required = true, paramType = "query"),
            @ApiImplicitParam(name = "address", value = "场所地址", required = true, paramType = "query"),
            @ApiImplicitParam(name = "areaId", value = "所属区域", required = true, paramType = "query"),
            @ApiImplicitParam(name = "longAddress", value = "所属行政区域", required = true, paramType = "query"),
            @ApiImplicitParam(name = "unitId", value = "所属单位", required = true, paramType = "query"),
            @ApiImplicitParam(name = "areaSize", value = "场所面积", required = true, paramType = "query"),
            @ApiImplicitParam(name = "manager", value = "负责人", required = true, paramType = "query"),
            @ApiImplicitParam(name = "managerTelephone", value = "负责人电话", required = true, paramType = "query"),
            @ApiImplicitParam(name = "fireTelephone", value = "消防室电话", required = true, paramType = "query"),
            @ApiImplicitParam(name = "isMain", value = "是否独立主机 0.是 1.否", required = true, paramType = "query"),
            @ApiImplicitParam(name = "lon", value = "场所坐标-lon经度", required = true, paramType = "query"),
            @ApiImplicitParam(name = "lat", value = "是否可以登录，0-可以登录，1-不容许", required = true, paramType = "query"),
            @ApiImplicitParam(name = "adminAreaId", value = "", required = true, paramType = "query"),
            @ApiImplicitParam(name = "code", value = "场所编号", required = true, paramType = "query"),
            @ApiImplicitParam(name = "province", value = "省份", required = true, paramType = "query"),
            @ApiImplicitParam(name = "city", value = "城市", required = true, paramType = "query"),
            @ApiImplicitParam(name = "district", value = "区", required = true, paramType = "query"),
            @ApiImplicitParam(name = "cityCode", value = "城市编码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "adcode", value = "场所编号", required = true, paramType = "query"),
            @ApiImplicitParam(name = "code", value = "场所编号", required = true, paramType = "query"),
            @ApiImplicitParam(name = "create_user", value = "创建者", required = false, paramType = "query"),
    })
    public int add(@ApiIgnore PlaceInfo placeInfo){
        return feignplaceInfoService.add(placeInfo);
    }

    @DeleteMapping
    @ApiOperation("删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query")
    })
    public int delete(String id){
        return feignplaceInfoService.delete(id);
    }

    @PutMapping
    @ApiOperation("更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "name", value = "场所名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "type", value = "场所性质", required = true, paramType = "query"),
            @ApiImplicitParam(name = "address", value = "场所地址", required = true, paramType = "query"),
            @ApiImplicitParam(name = "areaId", value = "所属区域", required = true, paramType = "query"),
            @ApiImplicitParam(name = "longAddress", value = "所属行政区域", required = true, paramType = "query"),
            @ApiImplicitParam(name = "unitId", value = "所属单位", required = true, paramType = "query"),
            @ApiImplicitParam(name = "areaSize", value = "场所面积", required = true, paramType = "query"),
            @ApiImplicitParam(name = "manager", value = "负责人", required = true, paramType = "query"),
            @ApiImplicitParam(name = "managerTelephone", value = "负责人电话", required = true, paramType = "query"),
            @ApiImplicitParam(name = "fireTelephone", value = "消防室电话", required = true, paramType = "query"),
            @ApiImplicitParam(name = "isMain", value = "是否独立主机 0.是 1.否", required = true, paramType = "query"),
            @ApiImplicitParam(name = "lon", value = "场所坐标-lon经度", required = true, paramType = "query"),
            @ApiImplicitParam(name = "lat", value = "是否可以登录，0-可以登录，1-不容许", required = true, paramType = "query"),
            @ApiImplicitParam(name = "adminAreaId", value = "", required = true, paramType = "query"),
            @ApiImplicitParam(name = "code", value = "场所编号", required = true, paramType = "query"),
            @ApiImplicitParam(name = "province", value = "省份", required = true, paramType = "query"),
            @ApiImplicitParam(name = "city", value = "城市", required = true, paramType = "query"),
            @ApiImplicitParam(name = "district", value = "区", required = true, paramType = "query"),
            @ApiImplicitParam(name = "cityCode", value = "城市编码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "adcode", value = "场所编号", required = true, paramType = "query"),
            @ApiImplicitParam(name = "code", value = "场所编号", required = true, paramType = "query"),
            @ApiImplicitParam(name = "updateUser", value = "编辑者", required = false, paramType = "query"),
    })
    public int update(@ApiIgnore PlaceInfo placeInfo){
        return feignplaceInfoService.update(placeInfo);
    }


    @PutMapping("/updateFreezeStatus")
    @ApiOperation("冻结/解冻")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query"),
    })
    public int updateFreezeStatus(@ApiIgnore Integer id){
        return feignplaceInfoService.updateFreezeStatus(id);
    }


    @GetMapping("/findById")
    @ApiOperation("获取详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query")
    })
    public PlaceInfo detail(String id){
        return feignplaceInfoService.findById(id);
    }

    @PostMapping("/pageList")
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数，默认1", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示，默认10，传0查全部", required = false, paramType = "query"),
            @ApiImplicitParam(name = "keyWords", value = "查询内容", required = false, paramType = "query"),
            @ApiImplicitParam(name = "code", value = "场所编号", required = false, paramType = "query"),
            @ApiImplicitParam(name = "type", value = "场所性质", required = false, paramType = "query"),
            @ApiImplicitParam(name = "unitId", value = "所属单位", required = false, paramType = "query"),
    })
    public PageList<PlaceInfo> pageList(@ApiIgnore PlaceInfo placeInfo) {
        return feignplaceInfoService.pageList(placeInfo);
    }
}
