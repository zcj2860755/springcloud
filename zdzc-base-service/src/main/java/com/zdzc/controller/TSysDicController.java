package com.zdzc.controller;

import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;
import com.zdzc.model.TSysDic;
import com.zdzc.service.ITSysDicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * Author : 李琳青
 * Date : 2019-08-06 13:41
 */
@RestController
@RequestMapping("/t/sys/dic")
@Api(description="数据字典接口API")
public class TSysDicController {
    @Resource
    private ITSysDicService tSysDicService;

    @PostMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dicKey", value = "字典key(编号)", required = true, paramType = "query"),
            @ApiImplicitParam(name = "dicValue", value = "字典value(标签)", required = true, paramType = "query"),
            @ApiImplicitParam(name = "sortNo", value = "排序", required = true, paramType = "query"),
            @ApiImplicitParam(name = "categoryId", value = "类型(字典类别的key)", required = true, paramType = "query"),
            @ApiImplicitParam(name = "CategoryDirValue", value = "类型描述(字典类别的value)", required = true, paramType = "query"),
    })
    public int add(@RequestBody TSysDic tSysDic){
        return tSysDicService.insert(tSysDic);
    }

    @DeleteMapping
    public int delete(@RequestParam("id") String id){
        return tSysDicService.delete(id);
    }

    @PutMapping
    public int update(@RequestBody TSysDic tSysDic){
        return tSysDicService.update(tSysDic);
    }

    @GetMapping("/findById")
    public TSysDic detail(@RequestParam("id") String id){
        return tSysDicService.findById(id);
    }

    @GetMapping("/findList")
    public PageList<TSysDic> list(@RequestBody TSysDic tSysDic, BaseRequest baseRequest) {
        return tSysDicService.list(tSysDic,baseRequest);
    }

}
