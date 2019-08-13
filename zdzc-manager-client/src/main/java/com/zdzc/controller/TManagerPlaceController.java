package com.zdzc.controller;

import com.zdzc.model.TManagerPlace;
import com.zdzc.service.FeignTManagerPlaceService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;
import com.zdzc.common.PageList;


/**
 * Description : 场所管理API接口
 * Author : 李琳青
 * Date : 2019-08-13 16:17
 */
@RestController
@RequestMapping("/manager/place")
@Api(description = "场所管理API接口")
public class TManagerPlaceController {
    @Resource
    private FeignTManagerPlaceService feigntManagerPlaceService;

    @PostMapping
    @ApiOperation("新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "场所名称", required = true, paramType = "query"),
            //@ApiImplicitParam(name = "code", value = "场所编号", required = true, paramType = "query"), //场所编号是生成的？
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
            @ApiImplicitParam(name = "lat", value = "场所坐标-lat纬度", required = true, paramType = "query"),
            @ApiImplicitParam(name = "adminAreaId", value = "", required = true, paramType = "query"),
            @ApiImplicitParam(name = "code", value = "场所编号", required = true, paramType = "query"),
            @ApiImplicitParam(name = "province", value = "省份", required = true, paramType = "query"),
            @ApiImplicitParam(name = "city", value = "城市", required = true, paramType = "query"),
            @ApiImplicitParam(name = "district", value = "区", required = true, paramType = "query"),
            @ApiImplicitParam(name = "cityCode", value = "城市编码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "adcode", value = "区编码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "createUser", value = "创建者", required = false, paramType = "query"),
    })
    public int add(@ApiIgnore TManagerPlace tManagerPlace){
        return feigntManagerPlaceService.add(tManagerPlace);
    }

    @DeleteMapping
    @ApiOperation("删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query")
    })
    public int delete(String id){
        return feigntManagerPlaceService.delete(id);
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
    public int update(@ApiIgnore TManagerPlace tManagerPlace){
        return feigntManagerPlaceService.update(tManagerPlace);
    }

    @PutMapping("/updateFreezeStatus")
    @ApiOperation("冻结/解冻")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query"),
    })
    public int updateFreezeStatus(@ApiIgnore Integer id){
        return feigntManagerPlaceService.updateFreezeStatus(id);
    }


    @GetMapping("/findById")
    @ApiOperation("获取详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query")
    })
    public TManagerPlace detail(String id){
        return feigntManagerPlaceService.findById(id);
    }

    @PostMapping("/pageList")
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数，默认1", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示，默认10，传0查全部", required = false, paramType = "query"),
            @ApiImplicitParam(name = "keyWords", value = "查询内容", required = false, paramType = "query"),
            @ApiImplicitParam(name = "mark", value = "0.查询所有 1.场所编号 2.场所名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "type", value = "场所性质", required = false, paramType = "query"),
            @ApiImplicitParam(name = "unitId", value = "所属单位", required = false, paramType = "query"),
    })
    public PageList<TManagerPlace> pageList(@ApiIgnore TManagerPlace tManagerPlace) {
        return feigntManagerPlaceService.pageList(tManagerPlace);
    }
}
