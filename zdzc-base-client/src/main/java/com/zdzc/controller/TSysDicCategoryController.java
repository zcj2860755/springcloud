package com.zdzc.controller;

import com.zdzc.model.TSysDicCategory;
import com.zdzc.service.FeignTSysDicCategoryService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;
import com.zdzc.common.PageList;


/**
 * Description : 字典类别API接口
 * Author : 李琳青
 * Date : 2019-08-06 19:08
 */
@RestController
@RequestMapping("/dic/category")
@Api(description = "字典类别API接口")
public class TSysDicCategoryController {
    @Resource
    private FeignTSysDicCategoryService feigntSysDicCategoryService;

    @PostMapping
    @ApiOperation("新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dicKey", value = "字典编码(类别)", required = true, paramType = "query"),
            @ApiImplicitParam(name = "dicValue", value = "字典名称(类别)", required = true, paramType = "query"),
            @ApiImplicitParam(name = "isEnable", value = "是否启用(0-关闭 1-启用)", required = true, paramType = "query"),
            @ApiImplicitParam(name = "sortNo", value = "排序", required = true, paramType = "query"),
            @ApiImplicitParam(name = "remark", value = "描述(类别)", required = true, paramType = "query"),
    })
    public int add(@ApiIgnore TSysDicCategory tSysDicCategory){
        return feigntSysDicCategoryService.add(tSysDicCategory);
    }

    @DeleteMapping
    @ApiOperation("删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query")
    })
    public int delete(String id){
        return feigntSysDicCategoryService.delete(id);
    }

    @PutMapping
    @ApiOperation("更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "dicKey", value = "字典编码(类别)", required = true, paramType = "query"),
            @ApiImplicitParam(name = "dicValue", value = "字典名称(类别)", required = true, paramType = "query"),
            @ApiImplicitParam(name = "isEnable", value = "是否启用(0-关闭 1-启用)", required = true, paramType = "query"),
            @ApiImplicitParam(name = "sortNo", value = "排序", required = true, paramType = "query"),
            @ApiImplicitParam(name = "remark", value = "描述(类别)", required = true, paramType = "query"),
    })
    public int update(@ApiIgnore TSysDicCategory tSysDicCategory){
        return feigntSysDicCategoryService.update(tSysDicCategory);
    }

    @GetMapping("/findById")
    @ApiOperation("获取详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query")
    })
    public TSysDicCategory detail(String id){
        return feigntSysDicCategoryService.findById(id);
    }


    @PostMapping("/pageList") //get 报错
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示", required = false, paramType = "query"),
            @ApiImplicitParam(name = "keyWords", value = "查询内容", required = false, paramType = "query")
    })
    public PageList<TSysDicCategory> pageList(@ApiIgnore TSysDicCategory tSysDicCategory) {
        return feigntSysDicCategoryService.pageList(tSysDicCategory);
    }
}
