package com.zdzc.controller;

import com.zdzc.common.PageList;
import com.zdzc.model.TSysDic;
import com.zdzc.service.FeignTSysDicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping("/delete")   //deleteMappering  报错
    @ApiOperation("删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键Id", required = true, paramType = "query")
    })
    public void delete(@ApiIgnore TSysDic tSysDic){
        feigntSysDicService.delete(tSysDic);
    }

    @PostMapping("/update")     // PutMapping("/update") 报错   这个参数都得传 isEnable  cate..key
    @ApiOperation("更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parameter", value = "参数", required = false, paramType = "query")
    })
    public void update(@ApiIgnore TSysDic tSysDic){
        feigntSysDicService.update(tSysDic);
    }

    @GetMapping("findById")
    @ApiOperation("获取详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键Id", required = true, paramType = "query")
    })
    public TSysDic detail(String id){
        feigntSysDicService.findById();
        return null;
    }

    //@GetMapping("/selectAll")  405  方法不允许
    @PostMapping("/select")
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数，默认1", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示，默认10，传0查全部", required = false, paramType = "query")
    })
    public PageList<TSysDic> list(@ApiIgnore TSysDic tSysDic) {
        return feigntSysDicService.list(tSysDic);
    }
}
