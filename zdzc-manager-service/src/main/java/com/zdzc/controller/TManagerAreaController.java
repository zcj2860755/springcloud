package com.zdzc.controller;

import com.zdzc.common.BaseRequest;
import com.zdzc.model.TManagerArea;
import com.zdzc.service.ITManagerAreaService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.zdzc.common.PageList;

import javax.annotation.Resource;


/**
 * Description : 区域管理API接口
 * Author : 李琳青
 * Date : 2019-08-13 17:48
 */
@RestController
@RequestMapping("/manager/area")
public class TManagerAreaController {
    @Resource
    private ITManagerAreaService tManagerAreaService;

    @PostMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "区域名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "parentId", value = "上级区域id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "parentIds", value = "上级区域ids", required = true, paramType = "query"),
            @ApiImplicitParam(name = "manager", value = "添加管理员", required = false, paramType = "query"),
            @ApiImplicitParam(name = "createUser", value = "创建者", required = false, paramType = "query"),
    })
    public int add(@RequestBody TManagerArea tManagerArea){
        return tManagerAreaService.save(tManagerArea);
    }

    @DeleteMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query")
    })
    public int delete(@RequestParam("id") String id){
       return tManagerAreaService.deleteById(id);
    }

    @PutMapping
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "区域名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "parentId", value = "上级区域id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "parentIds", value = "上级区域ids", required = true, paramType = "query"),
            @ApiImplicitParam(name = "manager", value = "修改管理员", required = false, paramType = "query"),
            @ApiImplicitParam(name = "updateUser", value = "编辑者", required = false, paramType = "query"),
    })
    public int update(@RequestBody TManagerArea tManagerArea){
       return tManagerAreaService.update(tManagerArea);
    }

    @GetMapping("/findById")
    public TManagerArea detail(@RequestParam("id") String id){
        return tManagerAreaService.findById(id);
    }

    @PostMapping("/pageList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数，默认1", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示，默认10，传0查全部", required = false, paramType = "query"),
            @ApiImplicitParam(name = "keyWords", value = "查询内容", required = false, paramType = "query"),
    })
    public PageList<TManagerArea> pageList(@RequestBody TManagerArea tManagerArea,BaseRequest baseRequest) {
        return tManagerAreaService.pageList(tManagerArea,baseRequest);
    }
}
