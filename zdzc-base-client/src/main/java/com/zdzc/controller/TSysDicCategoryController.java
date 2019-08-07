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
 * Author : 李琳青
 * Date : 2019-08-06 19:08
 */
@RestController
@RequestMapping("/t/sys/dic/category")
@Api(description = "接口描述")
public class TSysDicCategoryController {
    @Resource
    private FeignTSysDicCategoryService feigntSysDicCategoryService;

    @PostMapping("/insert")
    @ApiOperation("新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parameter", value = "参数", required = false, paramType = "query")
    })
    public void add(@ApiIgnore TSysDicCategory tSysDicCategory){
        feigntSysDicCategoryService.add(tSysDicCategory);
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键Id", required = true, paramType = "query")
    })
    public void delete(String Id){
        feigntSysDicCategoryService.delete(Id);
    }

    @PutMapping("/update")
    @ApiOperation("更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parameter", value = "参数", required = false, paramType = "query")
    })
    public void update(@ApiIgnore TSysDicCategory tSysDicCategory){
        feigntSysDicCategoryService.update(tSysDicCategory);
    }

    @GetMapping("/findById")
    @ApiOperation("获取详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键Id", required = true, paramType = "query")
    })
    public TSysDicCategory detail(String id){
        return feigntSysDicCategoryService.findById(id);
    }

    @GetMapping("/selectAll")
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数，默认1", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示，默认10，传0查全部", required = false, paramType = "query")
    })
    public PageList<TSysDicCategory> list(@ApiIgnore TSysDicCategory tSysDicCategory) {
        return feigntSysDicCategoryService.list(tSysDicCategory);
    }
}
