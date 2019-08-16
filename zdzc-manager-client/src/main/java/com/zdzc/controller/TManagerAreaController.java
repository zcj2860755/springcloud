package com.zdzc.controller;

import com.zdzc.enums.ExceptionEnum;
import com.zdzc.model.TManagerArea;
import com.zdzc.model.TManagerPlace;
import com.zdzc.service.FeignTManagerAreaService;
import com.zdzc.utils.BaseException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;
import com.zdzc.common.PageList;

import java.util.List;


/**
 * Description : 区域管理API接口
 * Author : 李琳青
 * Date : 2019-08-13 17:48
 */
@RestController
@RequestMapping("/manager/area")
@Api(description = "区域管理API接口")
public class TManagerAreaController {
    @Resource
    private FeignTManagerAreaService feigntManagerAreaService;

    @PostMapping
    @ApiOperation("新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "区域名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "parentId", value = "上级区域id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "parentIds", value = "上级区域ids", required = true, paramType = "query"),
            @ApiImplicitParam(name = "manager", value = "添加管理员", required = false, paramType = "query"),
            @ApiImplicitParam(name = "createUser", value = "创建者", required = false, paramType = "query"),
    })
    public int add(@ApiIgnore TManagerArea tManagerArea){
        checkParams(tManagerArea);
        return feigntManagerAreaService.add(tManagerArea);
    }



    /**
     * @Description : 参数校验
     */
    public void checkParams(TManagerArea tManagerArea){
        if(StringUtils.isEmpty(tManagerArea.getName())){
            throw new BaseException(ExceptionEnum.AREA_NAME_NULL);
        }
        if(StringUtils.isEmpty(tManagerArea.getParentId())){
            throw new BaseException(ExceptionEnum.PARENT_AREA_ID_NULL);
        }
        if(StringUtils.isEmpty(tManagerArea.getParentIds())){
            throw new BaseException(ExceptionEnum.PARENT_AREA_IDS_NULL);
        }
    }



    @DeleteMapping
    @ApiOperation("删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query")
    })
    public int delete(String id){
        if(StringUtils.isEmpty(id)){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSID_NULL);
        }
        return feigntManagerAreaService.delete(id);
    }

    @PutMapping
    @ApiOperation("更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "name", value = "区域名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "parentId", value = "上级区域id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "parentIds", value = "上级区域ids", required = true, paramType = "query"),
            @ApiImplicitParam(name = "manager", value = "修改管理员", required = false, paramType = "query"),
            @ApiImplicitParam(name = "updateUser", value = "编辑者", required = false, paramType = "query"),
    })
    public int update(@ApiIgnore TManagerArea tManagerArea){
        if(StringUtils.isEmpty(tManagerArea.getId())){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSID_NULL);
        }
        checkParams(tManagerArea);
        return feigntManagerAreaService.update(tManagerArea);
    }

    @GetMapping("/findById")
    @ApiOperation("获取详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query")
    })
    public TManagerArea detail(String id){
        if(StringUtils.isEmpty(id)){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSID_NULL);
        }
        return feigntManagerAreaService.findById(id);
    }

    @PostMapping("/pageList")
    @ApiOperation("查询-模糊查询前端做")
    public List<TManagerArea> pageList() {
        return feigntManagerAreaService.pageList();
    }
}
