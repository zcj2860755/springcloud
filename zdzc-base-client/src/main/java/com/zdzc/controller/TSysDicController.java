package com.zdzc.controller;

import com.zdzc.common.PageList;
import com.zdzc.model.TSysDic;
import com.zdzc.service.FeignTSysDicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;


/**
 * descirption : 字典API接口
 * Author : 李琳青
 * Date : 2019-08-06 13:41
 */
@RestController
@RequestMapping("/dic")
@Api(description = "字典API接口")
public class TSysDicController {
    @Resource
    private FeignTSysDicService feigntSysDicService;

    @PostMapping
    @ApiOperation("新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId", value = "类别id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "dicKey", value = "字典编码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "dicValue", value = "字典名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "isEnable", value = "是否启用(0-关闭 1-启用)", required = true, paramType = "query"),
            @ApiImplicitParam(name = "sortNo", value = "排序", required = true, paramType = "query"),
            @ApiImplicitParam(name = "remark", value = "描述", required = true, paramType = "query"),
    })
    public int add(@ApiIgnore TSysDic tSysDic){
        return feigntSysDicService.add(tSysDic);
    }

    @DeleteMapping
    @ApiOperation("删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query")
    })
    public int delete(String id){
        return feigntSysDicService.delete(id);
    }

    @PutMapping
    @ApiOperation("更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "categoryId", value = "类别id", required = false, paramType = "query"),
            @ApiImplicitParam(name = "dicKey", value = "字典编码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "dicValue", value = "字典名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "isEnable", value = "是否启用(0-关闭 1-启用)", required = true, paramType = "query"),
            @ApiImplicitParam(name = "sortNo", value = "排序", required = true, paramType = "query"),
            @ApiImplicitParam(name = "remark", value = "描述", required = true, paramType = "query"),
    })
    public int update(@ApiIgnore TSysDic tSysDic){
        return feigntSysDicService.update(tSysDic);
    }

    @GetMapping("/findById")
    @ApiOperation("获取详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query")
    })
    public TSysDic detail(String id){
        return feigntSysDicService.findById(id);
    }

    @PostMapping("/pageList")
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示", required = false, paramType = "query"),
            @ApiImplicitParam(name = "categoryId", value = "类别id", required = true, paramType = "query")
    })
    public PageList<TSysDic> pageList(@ApiIgnore TSysDic tSysDic) {
        return feigntSysDicService.pageList(tSysDic);
    }
}
