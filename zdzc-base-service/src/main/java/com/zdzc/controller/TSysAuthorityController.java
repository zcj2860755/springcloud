package com.zdzc.controller;

import com.zdzc.common.PageList;
import com.zdzc.enums.ExceptionEnum;
import com.zdzc.model.TSysAuthority;
import com.zdzc.service.ITSysAuthorityService;
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
import java.util.ArrayList;
import java.util.List;

/**
 * @Author  zcj
 * @Description //菜单权限相关
 * @Date 13:18 2019/8/8
 **/
@RestController
@RequestMapping("/authority")
@Api(description = "菜单按钮权限接口API")
public class TSysAuthorityController {
    @Resource
    private ITSysAuthorityService tSysAuthorityService;

    @PostMapping
    @ApiOperation("新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authName", value = "权限名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "authSign", value = "权限标识", required = true, paramType = "query"),
            @ApiImplicitParam(name = "parentId", value = "上级id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "authUrl", value = "访问路径", required = false, paramType = "query"),
            @ApiImplicitParam(name = "icon", value = "图标", required = false, paramType = "query"),
            @ApiImplicitParam(name = "authType", value = "权限类型", required = false, paramType = "query"),
            @ApiImplicitParam(name = "remark", value = "备注", required = false, paramType = "query"),
            @ApiImplicitParam(name = "sortNo", value = "排序", required = false, paramType = "query")

    })
    public void add(@ApiIgnore @RequestBody TSysAuthority tSysAuthority) {
        tSysAuthorityService.insertSelective(tSysAuthority);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", required = true, paramType = "path")
    })
    public void delete(@PathVariable String id) {
        if (ObjectUtils.isEmpty(id)) {
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSID_NULL);
        }

        if (tSysAuthorityService.deleteByPrimaryKey(id) == 0) {
            throw new BaseException(ExceptionEnum.SYSTEM_DELETE_ERROR);
        }
    }

    @PutMapping
    @ApiOperation("更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "path"),
            @ApiImplicitParam(name = "authName", value = "权限名称", required = false, paramType = "query"),
            @ApiImplicitParam(name = "authSign", value = "权限标识", required = false, paramType = "query"),
            @ApiImplicitParam(name = "authUrl", value = "访问路径", required = false, paramType = "query"),
            @ApiImplicitParam(name = "parentId", value = "上级id", required = false, paramType = "query"),
            @ApiImplicitParam(name = "icon", value = "图标", required = false, paramType = "query"),
            @ApiImplicitParam(name = "authType", value = "权限类型", required = false, paramType = "query"),
            @ApiImplicitParam(name = "remark", value = "备注", required = false, paramType = "query"),
            @ApiImplicitParam(name = "sortNo", value = "排序", required = false, paramType = "query")
    })
    public void update(@ApiIgnore @RequestBody TSysAuthority tSysAuthority) {
        tSysAuthorityService.updateByPrimaryKeySelective(tSysAuthority);
    }

    @GetMapping("/{id}")
    @ApiOperation("获取详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "path")
    })
    public TSysAuthority detail(@PathVariable String id) {
        return tSysAuthorityService.selectByPrimaryKey(id);
    }

    @GetMapping
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示", required = false, paramType = "query"),
            @ApiImplicitParam(name = "searchContent", value = "查询内容", required = false, paramType = "query")
    })
    public PageList<TSysAuthority> list(@ApiIgnore @RequestBody TSysAuthority tSysAuthority) {

        PageList<TSysAuthority> pageList = tSysAuthorityService.selectParamsList(tSysAuthority);
        List<TSysAuthority> authorityList = pageList.getList();
        List<TSysAuthority> resultList = new ArrayList<TSysAuthority>();
        for (TSysAuthority sysAuthority : authorityList) {
            if (!StringUtils.isEmpty(sysAuthority.getParentId()) && !sysAuthority.getParentId().equals("0")) {
                TSysAuthority authority = tSysAuthorityService.selectByPrimaryKey(sysAuthority.getParentId());
                if (!StringUtils.isEmpty(authority)) {
                    sysAuthority.setParentName(authority.getAuthName());
                }
            }
            resultList.add(sysAuthority);
        }
        pageList.setList(resultList);
        return pageList;
    }

    @PostMapping("/getRoleAuth")
    @ApiOperation("查询当前用户的所有权限")
    @ApiImplicitParam(name = "ids", value = "权限主键集合", allowMultiple = true, required = false, paramType = "query")
    public List<TSysAuthority> getRoleAuthList(@ApiIgnore @RequestBody TSysAuthority tSysAuthority) {
        return tSysAuthorityService.selectListByIds(tSysAuthority);
    }

    @PostMapping("/List")
    @ApiOperation("查询所有权限")
    public List<TSysAuthority> getAuthList() {
        return tSysAuthorityService.selectByExample();
    }


    @PostMapping("getAllAuthList")
    @ApiOperation("权限列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示", required = false, paramType = "query"),
            @ApiImplicitParam(name = "keyword", value = "权限名称", required = false, paramType = "query"),
            @ApiImplicitParam(name = "id", value = "设备主键黑名单", required = false, paramType = "query"),
            @ApiImplicitParam(name = "authTypeBlack", value = "权限类型黑名单", required = false, paramType = "query")
    })
    public PageList<TSysAuthority> getAllAuthList(@ApiIgnore @RequestBody TSysAuthority tSysAuthority) {
        return tSysAuthorityService.getAllAuthList(tSysAuthority);
    }


    @PostMapping("existAuthSign")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authSign", value = "权限标识", required = false, paramType = "query"),
            @ApiImplicitParam(name = "id", value = "设备主键黑名单", required = false, paramType = "query")
    })
    public List<TSysAuthority> existAuthSign(@ApiIgnore @RequestBody TSysAuthority tSysAuthority){
        return tSysAuthorityService.existAuthSign(tSysAuthority);
    }

    @PostMapping("defaultAuth")
    @ApiOperation("查询默认权限列表")
    public List<String> defaultAuth(@ApiIgnore @RequestBody TSysAuthority tSysAuthority){
         List<TSysAuthority>  list = tSysAuthorityService.defaultAuth(tSysAuthority);
         List<String> result = new ArrayList<>();
         if(list.size() > 0 ){
             for(TSysAuthority authority : list){
                 result.add(authority.getId());
             }
         }
         return result;
    }
}
