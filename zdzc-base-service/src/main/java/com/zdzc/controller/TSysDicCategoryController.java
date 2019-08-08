package com.zdzc.controller;

import com.zdzc.common.BaseRequest;
import com.zdzc.model.TSysDicCategory;
import com.zdzc.service.ITSysDicCategoryService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.zdzc.common.PageList;

import javax.annotation.Resource;


/**
 * Author : 李琳青
 * Date : 2019-08-06 19:08
 */
@RestController
@RequestMapping("/t/sys/dic/category")
public class TSysDicCategoryController {
    @Resource
    private ITSysDicCategoryService tSysDicCategoryService;

    @PostMapping
    public int add(@RequestBody TSysDicCategory tSysDicCategory){
        return tSysDicCategoryService.save(tSysDicCategory);
    }

    @DeleteMapping
    public int delete(@RequestParam("id") String Id){
        return tSysDicCategoryService.deleteById(Id);
    }

    @PutMapping
    public int update(@RequestBody TSysDicCategory tSysDicCategory){
        return tSysDicCategoryService.update(tSysDicCategory);
    }

    @GetMapping("/findById")  // 去掉注解 报错  load balance
    public TSysDicCategory detail(@RequestParam("id") String Id){
        return tSysDicCategoryService.findById(Id);
    }


    @PostMapping("/pageList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示", required = false, paramType = "query"),
            @ApiImplicitParam(name = "searchContent", value = "查询内容", required = false, paramType = "query")
    })
    public PageList<TSysDicCategory> pageList(@RequestBody TSysDicCategory tSysDicCategory,BaseRequest baseRequest) {
        return tSysDicCategoryService.list(tSysDicCategory,baseRequest);
    }
}
