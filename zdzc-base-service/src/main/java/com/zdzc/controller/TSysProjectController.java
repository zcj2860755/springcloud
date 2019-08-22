package com.zdzc.controller;

import com.zdzc.common.PageList;
import com.zdzc.common.Token;
import com.zdzc.enums.ExceptionEnum;
import com.zdzc.model.TSysProject;
import com.zdzc.service.ITSysAccountService;
import com.zdzc.service.ITSysProjectService;
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
 * @Description //项目相关
 * @Date 13:30 2019/8/8
 **/
@RestController
@RequestMapping("/project")
@Api(description = "项目接口API")
public class TSysProjectController extends BaseController{
    @Resource
    private ITSysProjectService tSysProjectService;

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
            @ApiImplicitParam(name = "remark", value = "备注", required = false, paramType = "query"),
            @ApiImplicitParam(name = "uuid", value = "用户token", required = true, paramType = "query")

    })
    public void add(@ApiIgnore @RequestBody TSysProject tSysProject) {
        //新增，获取session里面的数据
        if(StringUtils.isEmpty(tSysProject.getUuid())){
            throw new BaseException(ExceptionEnum.SYSTEM_USER_TOKEN);
        }
        if(StringUtils.isEmpty(tSysProject.getParentId()) || "0".equals(tSysProject.getParentId())){
            tSysProject.setParentId(getLoginUser(tSysProject.getUuid()).getProId());
            tSysProject.setCascadeId(getLoginUser(tSysProject.getUuid()).getProId());
        }
        tSysProjectService.insertSelective(tSysProject);
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
        tSysProjectService.deleteByPrimaryKey(id);
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
            @ApiImplicitParam(name = "remark", value = "备注", required = false, paramType = "query"),
            @ApiImplicitParam(name = "uuid", value = "用户token", required = true, paramType = "query")
    })
    public void update(@ApiIgnore @RequestBody TSysProject tSysProject) {
        if(StringUtils.isEmpty(tSysProject.getUuid())){
            throw new BaseException(ExceptionEnum.SYSTEM_USER_TOKEN);
        }
        if(!StringUtils.isEmpty(getLoginUser(tSysProject.getUuid()).getProId())){
            if(getLoginUser(tSysProject.getUuid()).getProId().equals(tSysProject.getId())){
                throw new BaseException(ExceptionEnum.PROJECT_EDIT_ERROR);
            }
        }
        if(StringUtils.isEmpty(tSysProject.getParentId()) || tSysProject.getParentId().equals("0")){
            tSysProject.setParentId(getLoginUser(tSysProject.getUuid()).getProId());
            tSysProject.setCascadeId(getLoginUser(tSysProject.getUuid()).getProId());
        }
        tSysProjectService.updateByPrimaryKeySelective(tSysProject);
    }

    @GetMapping("/{id}")
    @ApiOperation("获取详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "项目Id", required = true, paramType = "path")
    })
    public TSysProject detail(@PathVariable String id) {
        TSysProject sysProject = tSysProjectService.selectByPrimaryKey(id);
        return sysProject;
    }

    @PostMapping("pageList")
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示", required = false, paramType = "query"),
            @ApiImplicitParam(name = "searchContent", value = "查询内容", required = false, paramType = "query"),
            @ApiImplicitParam(name = "uuid", value = "用户token", required = true, paramType = "query"),
            @ApiImplicitParam(name = "id", value = "上级分组Id", required = false, paramType = "query")
    })
    public PageList<TSysProject> list(@ApiIgnore @RequestBody TSysProject tSysProject) {
        if(StringUtils.isEmpty(tSysProject.getUuid())){
            throw new BaseException(ExceptionEnum.SYSTEM_USER_TOKEN);
        }
        Token token = getLoginUser(tSysProject.getUuid());
        //获取用户所属本级及下级项目
        TSysProject temp = tSysProjectService.selectProjectById(token.getProId());
        tSysProject.setCascadeId(temp.getCascadeId());

        if(!StringUtils.isEmpty(tSysProject.getId())){
            TSysProject temp2 = tSysProjectService.selectProjectById(tSysProject.getId());
            tSysProject.setParentCascadeId(temp2.getCascadeId());
        }

        PageList<TSysProject> list = tSysProjectService.selectParamsList(tSysProject);
        //拼接上级全路径
        String seperator = "->";
        for(TSysProject t :list.getList()){
            String parentPath = tSysProjectService.selectProjectAllPath(t.getCascadeId().split("&"),seperator);
            t.setParentName(parentPath);
        }
        return list;
    }

    @PostMapping("/findList")
    @ApiOperation("查询所有--级联展示")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键Id", required = false, paramType = "query")
    })
    public List<TSysProject> findAlllist(@ApiIgnore @RequestBody TSysProject tSysProject) {
        List<TSysProject>  lists= tSysProjectService.selectByExample(tSysProject);
        return lists;
    }

    @PostMapping("/edit/findList")
    @ApiOperation("查询所有")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "项目Id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "uuid", value = "用户token", required = true, paramType = "query")
    })
    public List<TSysProject> editFindAlllist(@ApiIgnore @RequestBody TSysProject tSysProject) {
        if(StringUtils.isEmpty(tSysProject.getId())){
            //新增，获取session里面的数据
            if(StringUtils.isEmpty(tSysProject.getUuid())){
                throw new BaseException(ExceptionEnum.SYSTEM_USER_TOKEN);
            }
            if(StringUtils.isEmpty(getLoginUser(tSysProject.getUuid()).getProId())){
                tSysProject.setId(null);
            }
        }
        tSysProject.setCascadeId(getLoginUser(tSysProject.getUuid()).getProId());
        List<TSysProject>  lists= tSysProjectService.selectByExample(tSysProject);
        return lists;
    }
}
