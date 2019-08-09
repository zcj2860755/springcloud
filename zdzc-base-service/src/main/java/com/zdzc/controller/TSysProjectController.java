package com.zdzc.controller;

import com.zdzc.common.PageList;
import com.zdzc.common.Token;
import com.zdzc.enums.ExceptionEnum;
import com.zdzc.model.TSysAccount;
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

    @Resource
    private ITSysAccountService tSysAccountService;

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
    public void add(@ApiIgnore @RequestBody TSysProject tSysProject) {
        //新增，获取session里面的数据
       /* if(StringUtils.isEmpty(tSysProject.getParentId()) || tSysProject.getParentId().equals("0")){
            tSysProject.setParentId(getLoginUser().getProId());
            tSysProject.setCascadeId(getLoginUser().getProId());
        }*/
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
            @ApiImplicitParam(name = "remark", value = "备注", required = false, paramType = "query")
    })
    public void update(@ApiIgnore @RequestBody TSysProject tSysProject) {
        if(!StringUtils.isEmpty(getLoginUser().getProId())){
            if(getLoginUser().getProId().equals(tSysProject.getId())){
                throw new BaseException(ExceptionEnum.PROJECT_EDIT_ERROR);
            }
        }
        if(StringUtils.isEmpty(tSysProject.getParentId()) || tSysProject.getParentId().equals("0")){
            tSysProject.setParentId(getLoginUser().getProId());
            tSysProject.setCascadeId(getLoginUser().getProId());
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
        TSysAccount account = new TSysAccount();

        //根据项目id查询绑定的管理员以及管理员名称
        account.setProId(sysProject.getId());
        account.setIsbind(1);
        List<TSysAccount> accountList = tSysAccountService.selectAccountList(account);
        if(!StringUtils.isEmpty(accountList)) {
            List<String> userNames = new ArrayList<>();
            List<String> userIds = new ArrayList<>();
            for (TSysAccount tSysAccount : accountList) {
                userNames.add(tSysAccount.getRealName());
                userIds.add(tSysAccount.getId());
            }
            sysProject.setUserIds(userIds.toArray(new String[userIds.size()]));
            sysProject.setUserNames(userNames);
        }


        return sysProject;
    }

    @PostMapping("pageList")
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示", required = false, paramType = "query"),
            @ApiImplicitParam(name = "searchContent", value = "查询内容", required = false, paramType = "query")
    })
    public PageList<TSysProject> list(@ApiIgnore @RequestBody TSysProject tSysProject) {

        Token token = getLoginUser();
        if(!StringUtils.isEmpty(token.getProId())){
            TSysAccount tSysAccount = tSysAccountService.selectByPrimaryKey(getLoginUser().getUserId());
            if(tSysAccount.getIsbind() == 0){
                tSysProject.setId(token.getProId());
            }else if (tSysAccount.getIsbind() == 1){
                tSysProject.setCascadeId(token.getProId());
            }
        }

        if(StringUtils.isEmpty(tSysProject.getSearchContent())){
            tSysProject.setSearchContent(null);
        }
        PageList<TSysProject> pageList = tSysProjectService.selectParamsList(tSysProject);
        List<TSysProject> projectList = pageList.getList();
        List<TSysProject> resultList = new ArrayList<TSysProject>();
        TSysAccount account = new TSysAccount();
        for(TSysProject sysProject : projectList){
            //根据项目id查询绑定的管理员以及管理员名称
            account.setProId(sysProject.getId());
            account.setIsbind(1);
            List<TSysAccount> accountList = tSysAccountService.selectAccountList(account);
            if(!StringUtils.isEmpty(accountList)) {
                List<String> userNames = new ArrayList<>();
                for (TSysAccount tSysAccount : accountList) {
                    userNames.add(tSysAccount.getRealName());
                }
                sysProject.setUserNames(userNames);
            }

            if(!StringUtils.isEmpty(sysProject.getParentId()) && !sysProject.getParentId().equals("0")){
                TSysProject project = tSysProjectService.selectByPrimaryKey(sysProject.getParentId());
                if(!StringUtils.isEmpty(project)){
                    sysProject.setParentName(project.getProName());
                }
            }
            resultList.add(sysProject);
        }
        pageList.setList(resultList);
        return pageList;
    }

    @PostMapping("/findList")
    @ApiOperation("查询所有--级联展示")
    public List<TSysProject> findAlllist(@ApiIgnore @RequestBody TSysProject tSysProject) {
        List<TSysProject>  lists= tSysProjectService.selectByExample(tSysProject);
        return lists;
    }

    @PostMapping("/edit/findList")
    @ApiOperation("查询所有")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "项目Id", required = true, paramType = "query")
    })
    public List<TSysProject> editFindAlllist(@ApiIgnore @RequestBody TSysProject tSysProject) {
        if(StringUtils.isEmpty(tSysProject.getId())){
            //新增，获取session里面的数据
            if(StringUtils.isEmpty(getLoginUser().getProId())){
                tSysProject.setId(null);
            }

        }
        tSysProject.setCascadeId(getLoginUser().getProId());
        List<TSysProject>  lists= tSysProjectService.selectByExample(tSysProject);
        return lists;
    }
}
