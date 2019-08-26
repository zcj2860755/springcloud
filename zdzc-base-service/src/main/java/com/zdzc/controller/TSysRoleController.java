package com.zdzc.controller;

import com.zdzc.common.BaseRequest;
import com.zdzc.common.CommonStatus;
import com.zdzc.common.PageList;
import com.zdzc.enums.ExceptionEnum;
import com.zdzc.model.TSysRole;
import com.zdzc.model.TSysRoleAuthority;
import com.zdzc.service.ITSysRoleAuthorityService;
import com.zdzc.service.ITSysRoleService;
import com.zdzc.utils.BaseException;
import com.zdzc.utils.ObjectUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

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
    private ITSysRoleService tSysRoleService;
    @Resource
    private ITSysRoleAuthorityService tSysRoleAuthorityService;

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
    public void add(@ApiIgnore @RequestBody TSysRole tSysRole) {
        if(StringUtils.isEmpty(tSysRole.getRoleName())){
            throw new BaseException(ExceptionEnum.USER_REALNAME_NULL);
        }
        if(StringUtils.isEmpty(tSysRole.getRoleSign())){
            throw new BaseException(ExceptionEnum.USER_REALNAME_NULL);
        }
        tSysRoleService.insertSelective(tSysRole);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", required = true, paramType = "path")
    })
    public void delete(@PathVariable String id) {
        if(ObjectUtils.isEmpty(id)){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSID_NULL);
        }
        tSysRoleService.deleteByPrimaryKey(id);
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
    public void update(@ApiIgnore @RequestBody TSysRole tSysRole) {
        tSysRoleService.updateByPrimaryKeySelective(tSysRole);
    }

    @GetMapping("/{id}")
    @ApiOperation("获取详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "角色Id", required = true, paramType = "path")
    })
    public TSysRole detail(@PathVariable String id) {
        if(StringUtils.isEmpty(id)){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSID_NULL);
        }
        TSysRole tSysRole = tSysRoleService.selectByPrimaryKey(id);
        TSysRoleAuthority roleAuthority =new TSysRoleAuthority();
        roleAuthority.setRoleId(tSysRole.getId());
        Set<String> authIds = tSysRoleAuthorityService.selectRoleList(roleAuthority);
        String[] array2 = authIds.toArray(new String[authIds.size()]);
        tSysRole.setAuthIds(array2);
        return tSysRole;
    }

    @PostMapping("/pageList")
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示", required = false, paramType = "query"),
            @ApiImplicitParam(name = "searchContent", value = "查询内容", required = false, paramType = "query")
    })
    public PageList<TSysRole> list(@ApiIgnore @RequestBody TSysRole tSysRole) {
        PageList<TSysRole>  pageList = tSysRoleService.selectParamsList(tSysRole);
        return pageList;
    }

    @PostMapping("/getUserRole")
    @ApiOperation("获取用户角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "角色Id", required = true, paramType = "path")
    })
    public List<TSysRole> getUserRole(@RequestBody TSysRole tSysRole) {
        List<TSysRole> pageList = tSysRoleService.selectByExample(tSysRole);
        return pageList;
    }

    @GetMapping("/findAllRole")
    @ApiOperation("获取所有角色")
    public List<TSysRole> findAllRole() {
        TSysRole tSysRole = new TSysRole();
        tSysRole.setDelFlag(CommonStatus.STATUS_NORMAL);
        tSysRole.setStatus(0);
        List<TSysRole> List = tSysRoleService.selectByExample(tSysRole);
        return List;
    }


    @PostMapping("/existRoleSign")
    @ApiOperation("判断角色是否重复")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleName", value = "角色名称", required = true, paramType = "query")
    })
    public void getUserRoleName(@RequestBody TSysRole tSysRole) {
        tSysRole.setDelFlag(CommonStatus.STATUS_NORMAL);
        List<TSysRole> list = tSysRoleService.selectByExample(tSysRole);
        if(!StringUtils.isEmpty(list) && list.size()>0){
            throw new BaseException(ExceptionEnum.USER_ROLE_NAMEEXIST);
        }
    }
}
