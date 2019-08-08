package com.zdzc.controller;

import com.zdzc.common.BaseRequest;
import com.zdzc.common.CommonStatus;
import com.zdzc.common.PageList;
import com.zdzc.enums.ExceptionEnum;
import com.zdzc.model.TSysRole;
import com.zdzc.service.FeignTSysRoleService;
import com.zdzc.utils.BaseException;
import com.zdzc.utils.ObjectUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import javax.annotation.Resource;
import java.util.List;

/**
 * @Author  zcj
 * @Description // 用户角色接口API
 * @Date 11:25 2019/8/7
 * @Param
 * @return
 **/
@RestController
@RequestMapping("/role")
@Api(description = "角色接口API")
public class TSysRoleController {

    @Resource
    private FeignTSysRoleService feignTSysRoleService;

    @PostMapping
    @ApiOperation("新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleName", value = "角色名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "roleSign", value = "角色标识", required = true, paramType = "query"),
            @ApiImplicitParam(name = "orgId", value = "所属机构", required = false, paramType = "query"),
            @ApiImplicitParam(name = "accountId", value = "创建人", required = false, paramType = "query"),
            @ApiImplicitParam(name = "authIds", value = "权限id集合", required = false, paramType = "query"),
            @ApiImplicitParam(name = "status", value = "状态(-1-删除 0-启用 1-冻结)", required = false, paramType = "query"),
            @ApiImplicitParam(name = "isLogin", value = "是否可以登录，0-可以登录，1-不容许", required = false, paramType = "query")
    })
    public void add(@ApiIgnore TSysRole tSysRole) {
        feignTSysRoleService.add(tSysRole);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", required = true, paramType = "path")
    })
    public void delete(@PathVariable String id) {
        if(ObjectUtils.isEmpty(id)){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSID_NULL);
        }
        feignTSysRoleService.delete(id);
    }

    @PutMapping
    @ApiOperation("更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "roleName", value = "角色名称", required = false, paramType = "query"),
            @ApiImplicitParam(name = "roleSign", value = "角色标识", required = false, paramType = "query"),
            @ApiImplicitParam(name = "orgId", value = "所属机构", required = false, paramType = "query"),
            @ApiImplicitParam(name = "accountId", value = "创建人", required = false, paramType = "query"),
            @ApiImplicitParam(name = "authIds", value = "权限id集合", required = false, paramType = "query"),
            @ApiImplicitParam(name = "status", value = "状态(-1-删除 0-启用 1-冻结)", required = false, paramType = "query"),
            @ApiImplicitParam(name = "isLogin", value = "是否可以登录，0-可以登录，1-不容许", required = false, paramType = "query")
    })
    public void update(@ApiIgnore TSysRole tSysRole) {
        feignTSysRoleService.update(tSysRole);
    }

    @GetMapping("/{id}")
    @ApiOperation("获取详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "角色Id", required = true, paramType = "path")
    })
    public TSysRole detail(@PathVariable String id) {
        TSysRole tSysRole = feignTSysRoleService.detail(id);
        return tSysRole;
    }

    @GetMapping("/pageList")
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示", required = false, paramType = "query"),
            @ApiImplicitParam(name = "searchContent", value = "查询内容", required = false, paramType = "query")
    })
    public PageList<TSysRole> list(@ApiIgnore TSysRole tSysRole) {
        PageList<TSysRole>  pageList = feignTSysRoleService.list(tSysRole);
        return pageList;
    }

    @GetMapping("/getUserRole")
    @ApiOperation("获取用户角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "角色Id", required = true, paramType = "query")
    })
    public List<TSysRole> getUserRole(@ApiIgnore TSysRole tSysRole) {
        List<TSysRole> pageList = feignTSysRoleService.getUserRole(tSysRole);
        return pageList;
    }

    @GetMapping("/findAllRole")
    @ApiOperation("获取所有角色")
    public List<TSysRole> findAllRole() {
        List<TSysRole> List = feignTSysRoleService.findAllRole();
        return List;
    }


    @PostMapping("/existRoleSign")
    @ApiOperation("判断角色是否重复")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleName", value = "角色名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "roleSign", value = "角色标识", required = false, paramType = "query")
    })
    public void getUserRoleName(@ApiIgnore  TSysRole tSysRole) {
         feignTSysRoleService.getUserRoleName(tSysRole);
    }
}
