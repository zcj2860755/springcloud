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
 * Author : 李琳青
 * Date : 2019-08-06 13:41
 */
@RestController
@RequestMapping("/t/sys/dic")
@Api(description = "字典管理API接口")
public class TSysDicController {
    @Resource
    private FeignTSysDicService feigntSysDicService;

    @PostMapping("/insert")
    @ApiOperation("新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parameter", value = "参数", required = false, paramType = "query")
    })
    public void add(@ApiIgnore TSysDic tSysDic){
        feigntSysDicService.add(tSysDic);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键Id", required = true, paramType = "query")
    })
    public void delete(String id){
        feigntSysDicService.delete(id);
    }

    @PutMapping("/update")     // PutMapping("/update") 报错   这个参数都得传 isEnable  cate..key
    @ApiOperation("更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parameter", value = "参数", required = false, paramType = "query")
    })
    public void update(@ApiIgnore TSysDic tSysDic){
        feigntSysDicService.update(tSysDic);
    }

    @GetMapping("/findById")
    @ApiOperation("获取详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键Id", required = true, paramType = "query")
    })
    public TSysDic detail(String id){
        return feigntSysDicService.findById(id);
    }

    @PostMapping("/pageList")
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示", required = false, paramType = "query"),
            @ApiImplicitParam(name = "keyWords", value = "查询内容", required = false, paramType = "query")
    })
    public PageList<TSysDic> pageList(@ApiIgnore TSysDic tSysDic) {
        return feigntSysDicService.pageList(tSysDic);
    }
}
