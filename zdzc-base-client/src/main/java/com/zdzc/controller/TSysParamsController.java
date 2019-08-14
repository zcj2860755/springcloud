package com.zdzc.controller;

import com.zdzc.enums.ExceptionEnum;
import com.zdzc.model.TSysParams;
import com.zdzc.service.FeignTSysParamsService;
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


/**
 * Description :
 * Author : zhuqilong
 * Date : 2019-08-13 14:02
 */
@RestController
@RequestMapping("/sys/params")
@Api(description = "系统参数相关接口")
public class TSysParamsController {
    @Resource
    private FeignTSysParamsService feigntSysParamsService;

    @PostMapping
    @ApiOperation("新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paramsName", value = "参数名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "paramsKey", value = "参数key", required = true, paramType = "query"),
            @ApiImplicitParam(name = "paramsValue", value = "参数值", required = true, paramType = "query"),
            @ApiImplicitParam(name = "remark", value = "备注", required = false, paramType = "query")
    })
    public int add(@ApiIgnore TSysParams tSysParams){
        checkParams(tSysParams);
        return feigntSysParamsService.add(tSysParams);
    }

    /**
     * @Author  zhuqilong
     * @Description 系统参数参数校验
     * @Date 14:25 2019/8/13
     * @Param
     * @return
    */
    public void checkParams(TSysParams tSysParams){
        if(StringUtils.isEmpty(tSysParams.getParamsValue())){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSVALUE_NULL);
        }

        if(StringUtils.isEmpty(tSysParams.getParamsName())){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSNAME_NULL);
        }

        if(StringUtils.isEmpty(tSysParams.getParamsKey())){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSKEY_NULL);
        }
    }

    @DeleteMapping
    @ApiOperation("删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query")
    })
    public int delete(String id){
        return feigntSysParamsService.delete(id);
    }

    @PutMapping
    @ApiOperation("更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键Id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "paramsName", value = "参数名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "paramsKey", value = "参数key", required = true, paramType = "query"),
            @ApiImplicitParam(name = "paramsValue", value = "参数值", required = true, paramType = "query"),
            @ApiImplicitParam(name = "remark", value = "备注", required = false, paramType = "query")
    })
    public int update(@ApiIgnore TSysParams tSysParams){
        if(StringUtils.isEmpty(tSysParams.getId())){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSID_NULL);
        }
        checkParams(tSysParams);
        return feigntSysParamsService.update(tSysParams);
    }

    @GetMapping("/findById")
    @ApiOperation("获取详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query")
    })
    public TSysParams detail(String id){
        return feigntSysParamsService.findById(id);
    }

    @GetMapping
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数，默认1", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示，默认10，传0查全部", required = false, paramType = "query"),
    })
    public PageList<TSysParams> pageList(@ApiIgnore TSysParams tSysParams,
            @RequestParam(value="pageNo",defaultValue="1") Integer pageNo,@RequestParam(value="pageSize",defaultValue="10") Integer pageSize) {
        return feigntSysParamsService.pageList(tSysParams,pageNo,pageSize);
    }
}
