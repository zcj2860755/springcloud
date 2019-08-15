package com.zdzc.controller;

import com.zdzc.model.TSysArea;
import com.zdzc.service.ITSysAreaService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
    @ApiOperation("更新") // --跨省修改有问题,提升地区等级也会有问题 子类level不变  一般不会操作
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



    @PostMapping("/selectProvinceCityAreaList")
    @ApiOperation("多级类别查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "省份/城市/区id", required = false, paramType = "query"),
            @ApiImplicitParam(name = "mark", value = "标记 1.省份 2.城市 3.区域 4.镇、街道 ", required = true, paramType = "query"),
    })
    public List<TSysArea> selectProvinceCityAreaList(@RequestBody TSysArea tSysArea){
        return tSysAreaService.selectProvinceCityAreaList(tSysArea);
    }


}
