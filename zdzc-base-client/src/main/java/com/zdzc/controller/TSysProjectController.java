package com.zdzc.controller;

import com.zdzc.common.PageList;
import com.zdzc.enums.ExceptionEnum;
import com.zdzc.model.TSysProject;
import com.zdzc.service.FeignTSysProjectService;
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
 * @Description //项目相关
 * @Date 13:30 2019/8/8
 **/
@RestController
@RequestMapping("/project")
@Api(description = "项目接口API")
public class TSysProjectController {
    @Resource
    private FeignTSysProjectService feignTSysProjectService;

    @PostMapping
    @ApiOperation("新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "proName", value = "项目名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "proCode", value = "项目编码", required = false, paramType = "query"),
            @ApiImplicitParam(name = "parentId", value = "上级ID", required = false, paramType = "query"),
            @ApiImplicitParam(name = "cascadeId", value = "串联id", required = false, paramType = "query"),
            @ApiImplicitParam(name = "contacts", value = "联系人", required = false, paramType = "query"),
            @ApiImplicitParam(name = "isLeaf", value = "是否叶子节点", required = false, paramType = "query"),
            @ApiImplicitParam(name = "orders", value = "排序字段", required = false, paramType = "query"),
            @ApiImplicitParam(name = "isEnable", value = "是否启用", required = false, paramType = "query"),
            @ApiImplicitParam(name = "orders", value = "排序字段", required = false, paramType = "query"),
            @ApiImplicitParam(name = "accountId", value = "创建人", required = false, paramType = "query"),
            @ApiImplicitParam(name = "userIds", value = "管理员id集合",allowMultiple = true , required = false, paramType = "query"),
            @ApiImplicitParam(name = "remark", value = "备注", required = false, paramType = "query")

    })
    public void add(@ApiIgnore TSysProject tSysProject) {
        feignTSysProjectService.add(tSysProject);
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
        feignTSysProjectService.delete(id);
    }

    @PutMapping
    @ApiOperation("更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "项目Id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "proName", value = "项目名称", required = false, paramType = "query"),
            @ApiImplicitParam(name = "proCode", value = "项目编码", required = false, paramType = "query"),
            @ApiImplicitParam(name = "parentId", value = "上级ID", required = false, paramType = "query"),
            @ApiImplicitParam(name = "cascadeId", value = "串联id", required = false, paramType = "query"),
            @ApiImplicitParam(name = "contacts", value = "联系人", required = false, paramType = "query"),
            @ApiImplicitParam(name = "isLeaf", value = "是否叶子节点", required = false, paramType = "query"),
            @ApiImplicitParam(name = "orders", value = "排序字段", required = false, paramType = "query"),
            @ApiImplicitParam(name = "isEnable", value = "是否启用", required = false, paramType = "query"),
            @ApiImplicitParam(name = "orders", value = "排序字段", required = false, paramType = "query"),
            @ApiImplicitParam(name = "accountId", value = "创建人", required = false, paramType = "query"),
            @ApiImplicitParam(name = "userIds", value = "管理员id",allowMultiple = true , required = false, paramType = "query"),
            @ApiImplicitParam(name = "remark", value = "备注", required = false, paramType = "query")
    })
    public void update(@ApiIgnore TSysProject tSysProject) {
        feignTSysProjectService.update(tSysProject);
    }

    @GetMapping("/{id}")
    @ApiOperation("获取详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "项目Id", required = true, paramType = "path")
    })
    public TSysProject detail(@PathVariable String id) {

        return feignTSysProjectService.detail(id);
    }

    @GetMapping
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示", required = false, paramType = "query"),
            @ApiImplicitParam(name = "searchContent", value = "查询内容", required = false, paramType = "query")
    })
    public PageList<TSysProject> list(@ApiIgnore TSysProject tSysProject) {
        return feignTSysProjectService.list(tSysProject);
    }

    @GetMapping("/findList")
    @ApiOperation("查询所有--级联展示")
    public List<TSysProject> findAlllist(@ApiIgnore TSysProject tSysProject) {
        return feignTSysProjectService.findAlllist(tSysProject);
    }

    @GetMapping("/edit/findList")
    @ApiOperation("查询所有")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "项目Id", required = true, paramType = "query")
    })
    public List<TSysProject> editFindAlllist(@ApiIgnore TSysProject tSysProject) {
        return feignTSysProjectService.editFindAlllist(tSysProject);
    }
}
