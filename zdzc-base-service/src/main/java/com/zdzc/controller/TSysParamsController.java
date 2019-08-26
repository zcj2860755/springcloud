package com.zdzc.controller;

import com.zdzc.common.PageList;
import com.zdzc.enums.ExceptionEnum;
import com.zdzc.model.TSysParams;
import com.zdzc.service.ITSysParamsService;
import com.zdzc.utils.BaseException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


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
    private ITSysParamsService tSysParamsService;

    @PostMapping("/add")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paramsName", value = "参数名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "paramsKey", value = "参数key", required = true, paramType = "query"),
            @ApiImplicitParam(name = "paramsValue", value = "参数值", required = true, paramType = "query"),
            @ApiImplicitParam(name = "remark", value = "备注", paramType = "query")
    })
    public int add(@RequestBody TSysParams tSysParams){
        checkParams(tSysParams);
        return tSysParamsService.save(tSysParams);
    }

    /**
     * @Author  zhuqilong
     * @Description 系统参数参数校验
     * @Date 14:25 2019/8/13
     * @Param
     * @return
     */
    public void checkParams(TSysParams tSysParams){
        if(StringUtils.isEmpty(tSysParams.getParamsName())){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSNAME_NULL);
        }
        if(StringUtils.isEmpty(tSysParams.getParamsKey())){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSKEY_NULL);
        }
        if(StringUtils.isEmpty(tSysParams.getParamsValue())){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSVALUE_NULL);
        }
    }

    @DeleteMapping
    @ApiOperation("删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query")
    })
    public int delete(@RequestParam("id") String id){
        if(StringUtils.isEmpty(id)){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSID_NULL);
        }
       return tSysParamsService.deleteById(id);
    }

    @PutMapping
    @ApiOperation("更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "categoryId", value = "类别id", paramType = "query"),
            @ApiImplicitParam(name = "dicKey", value = "字典编码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "dicValue", value = "字典名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "isEnable", value = "是否启用(0-关闭 1-启用)", required = true, paramType = "query"),
            @ApiImplicitParam(name = "sortNo", value = "排序", required = true, paramType = "query"),
            @ApiImplicitParam(name = "remark", value = "描述", paramType = "query"),
    })
    public int update(@RequestBody TSysParams tSysParams){
       checkParams(tSysParams);
        if(StringUtils.isEmpty(tSysParams.getId())){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSID_NULL);
        }
       return tSysParamsService.update(tSysParams);
    }

    @GetMapping("/findById")
    @ApiOperation("获取详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query")
    })
    public TSysParams detail(@RequestParam("id") String id){
        if(StringUtils.isEmpty(id)){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSID_NULL);
        }
        return tSysParamsService.findById(id);
    }

    @PostMapping("/pageList")
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数，默认1", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示，默认10，传0查全部",  paramType = "query"),
            @ApiImplicitParam(name="keyword",value="关键字", paramType = "query")
    })
    public PageList<TSysParams> pageList(@RequestBody TSysParams tSysParams,
        @RequestParam(value="pageNo",defaultValue="1") Integer pageNo,@RequestParam(value="pageSize",defaultValue="10") Integer pageSize) {
        return tSysParamsService.pageList(tSysParams,pageNo,pageSize);
    }
}
