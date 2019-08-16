package com.zdzc.controller;

import com.zdzc.enums.ExceptionEnum;
import com.zdzc.model.TManagerPlace;
import com.zdzc.model.TManagerUnit;
import com.zdzc.service.FeignTManagerUnitService;
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
 * Description : 单位管理API接口
 * Author : 李琳青
 * Date : 2019-08-13 16:18
 */
@RestController
@RequestMapping("/manager/unit")
@Api(description = "单位管理API接口")
public class TManagerUnitController {
    @Resource
    private FeignTManagerUnitService feigntManagerUnitService;

    @PostMapping
    @ApiOperation("新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "单位名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "address", value = "单位地址", required = true, paramType = "query"),
            @ApiImplicitParam(name = "areaId", value = "所属区域", required = true, paramType = "query"),
            @ApiImplicitParam(name = "adminAreaId", value = "adminAreaId", required = true, paramType = "query"),
            @ApiImplicitParam(name = "creditCode", value = "统一信用码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "manager", value = "负责人-userId", required = true, paramType = "query"),
            @ApiImplicitParam(name = "managerTelephone", value = "负责人电话", required = true, paramType = "query"),
            @ApiImplicitParam(name = "createUser", value = "创建者", required = false, paramType = "query"),
    })
    public int add(@ApiIgnore TManagerUnit tManagerUnit){
        checkParams(tManagerUnit);
        return feigntManagerUnitService.add(tManagerUnit);
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
        return feigntManagerUnitService.delete(id);
    }

    @PutMapping
    @ApiOperation("更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "name", value = "单位名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "address", value = "单位地址", required = true, paramType = "query"),
            @ApiImplicitParam(name = "areaId", value = "所属区域", required = true, paramType = "query"),
            @ApiImplicitParam(name = "adminAreaId", value = "adminAreaId", required = true, paramType = "query"),
            @ApiImplicitParam(name = "creditCode", value = "统一信用码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "manager", value = "负责人-userId", required = true, paramType = "query"),
            @ApiImplicitParam(name = "managerTelephone", value = "负责人电话", required = true, paramType = "query"),
            @ApiImplicitParam(name = "createUser", value = "创建者", required = false, paramType = "query"),
    })
    public int update(@ApiIgnore TManagerUnit tManagerUnit){
        if(StringUtils.isEmpty(tManagerUnit.getId())){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSID_NULL);
        }
        checkParams(tManagerUnit);
        return feigntManagerUnitService.update(tManagerUnit);
    }


    @GetMapping("/findById")
    @ApiOperation("获取详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query")
    })
    public TManagerUnit detail(String id){
        if(StringUtils.isEmpty(id)){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSID_NULL);
        }
        return feigntManagerUnitService.findById(id);
    }


    @PostMapping("/pageList")
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数，默认1", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示，默认10，传0查全部", required = false, paramType = "query"),
            @ApiImplicitParam(name = "keyWords", value = "查询内容", required = false, paramType = "query"),
            @ApiImplicitParam(name = "mark", value = "0.查询所有 1.按照单位编号 2.按单位名称", required = true, paramType = "query"),
    })
    public PageList<TManagerUnit> pageList(@ApiIgnore TManagerUnit tManagerUnit,@RequestParam(value="pageNo",defaultValue="1") Integer pageNo,@RequestParam(value="pageSize",defaultValue="10") Integer pageSize) {
        if(StringUtils.isEmpty(tManagerUnit.getMark())){
            throw new BaseException(ExceptionEnum.PARAM_IS_NOT_NULL);
        }
        return feigntManagerUnitService.pageList(tManagerUnit,pageNo,pageSize);
    }



    /**
     * @Description : 参数校验
     */
    public void checkParams(TManagerUnit tManagerUnit){
        if(StringUtils.isEmpty(tManagerUnit.getName())){
            throw new BaseException(ExceptionEnum.UNIT_NAME_NULL);
        }
        if(StringUtils.isEmpty(tManagerUnit.getAddress())){
            throw new BaseException(ExceptionEnum.UNIT_ADDRESS_NULL);
        }
        if(StringUtils.isEmpty(tManagerUnit.getAreaId())){
            throw new BaseException(ExceptionEnum.PLACE_OF_AREA_NULL);
        }
        if(StringUtils.isEmpty(tManagerUnit.getAdminAreaId())){
            throw new BaseException(ExceptionEnum.ADMIN_AREA_ID_MULL);
        }
        if(StringUtils.isEmpty(tManagerUnit.getCreditCode())){
            throw new BaseException(ExceptionEnum.CREDIT_CODE_NULL);
        }
        if(StringUtils.isEmpty(tManagerUnit.getManager())){
            throw new BaseException(ExceptionEnum.MANAGER_NULL);
        }
        if(StringUtils.isEmpty(tManagerUnit.getManagerTelephone())){
            throw new BaseException(ExceptionEnum.MANAGER_TEL_NULL);
        }
    }



}
