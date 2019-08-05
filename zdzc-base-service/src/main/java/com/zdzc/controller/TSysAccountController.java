package com.zdzc.controller;


import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;
import com.zdzc.enums.ExceptionEnum;
import com.zdzc.model.TSysAccount;
import com.zdzc.service.ITSysAccountService;
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
import java.util.*;

/**
 * Created by zahngchangjiang on 2018/12/14.
 */
@RestController
@RequestMapping("/account")
@Api(description="用户接口API")
public class TSysAccountController {
    @Resource
    private ITSysAccountService tSysAccountService;



    @PostMapping()
    @ApiOperation("新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账号", required = true, paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = false, paramType = "query"),
            @ApiImplicitParam(name = "realName", value = "用户名", required = true, paramType = "query"),
            @ApiImplicitParam(name = "tel", value = "联系电话", required = true, paramType = "query"),
            @ApiImplicitParam(name = "roleId", value = "角色id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "deviceIds", value = "设备id集",allowMultiple = false ,required = false, paramType = "query")

    })
    public void add(@ApiIgnore TSysAccount tSysAccount){
        int result = tSysAccountService.insert(tSysAccount);
    }
    @PostMapping("/login")
    @ApiOperation("用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账号", required = true, paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "query")
    })
    public String login(@ApiIgnore TSysAccount tSysAccount, HttpServletRequest request){
        return null;
    }

    @PostMapping("/logout")
    @ApiOperation("用户退出")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", required = false, paramType = "query")
    })
    public void logout(@ApiIgnore TSysAccount tSysAccount, HttpServletRequest request) {

    }

    @DeleteMapping("/deleteAccount")
    @ApiOperation("删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "用户主键",allowMultiple = true, required = true, paramType = "query")
    })
    public void delete(@RequestParam(value="ids[]",required = false) String[] ids, @RequestParam(value="ids",required = false)String[] id)  {
        if(ObjectUtils.isEmpty(ids) && ObjectUtils.isEmpty(id)){

        }
    }

    @PutMapping
    @ApiOperation("更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户Id", required = true, paramType = "path"),
            @ApiImplicitParam(name = "account", value = "账号", required = true, paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = false, paramType = "query"),
            @ApiImplicitParam(name = "realName", value = "用户名", required = true, paramType = "query"),
            @ApiImplicitParam(name = "tel", value = "联系电话", required = true, paramType = "query"),
            @ApiImplicitParam(name = "roleId", value = "角色id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "selfId", value = "创建人", required = false, paramType = "query"),
            @ApiImplicitParam(name = "state", value = "用户状态（0-启用 1-禁用）", required = true, paramType = "query"),
            @ApiImplicitParam(name = "deviceIds", value = "设备id集",allowMultiple = false ,required = false, paramType = "query")
    })
    public void update(@ApiIgnore TSysAccount tSysAccount) {

        TSysAccount account = tSysAccountService.selectByPrimaryKey(tSysAccount.getId());
        tSysAccountService.updateByPrimaryKeySelective(tSysAccount);
        //当用户修改自身的角色和账号时，需要清空session
    }

    @GetMapping("/{id}")
    @ApiOperation("获取详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户Id", required = true, paramType = "path")
    })
    public TSysAccount detail(@PathVariable String id) {

        TSysAccount account =  tSysAccountService.selectByPrimaryKey(id);
        return  account;
    }

    @GetMapping("/list")
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示", required = false, paramType = "query"),
            @ApiImplicitParam(name = "searchContent", value = "查询内容", required = false, paramType = "query")
    })
    public PageList<TSysAccount> list(@ApiIgnore TSysAccount tSysAccount, BaseRequest baseRequest) {
        tSysAccount.setDelFlag(0);
        PageList<TSysAccount> tSysAccountPageList = tSysAccountService.selectAccountList(tSysAccount,baseRequest);
        return tSysAccountPageList;
    }

    @GetMapping("/manger")
    @ApiOperation("获取该项目下未绑定的用户加项目自身管理员")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "proId", value = "项目", required = false, paramType = "query")
    })
    public List<TSysAccount> findMangerList(@ApiIgnore TSysAccount tSysAccount) {
        tSysAccount.setDelFlag(0);
        List<TSysAccount> tSysAccountList = new ArrayList<>();
        List<TSysAccount> tSysAccountList2 = new ArrayList<>() ;
        //获取已绑定
        if(!StringUtils.isEmpty(tSysAccount.getProId())){
            tSysAccount.setIsbind(1);
            tSysAccountList = tSysAccountService.selectAccountList(tSysAccount);
        }
        //获取未绑定
        tSysAccount.setIsbind(0);
        tSysAccountList2 = tSysAccountService.selectAccountList(tSysAccount);
        tSysAccountList.addAll(tSysAccountList2);
        return tSysAccountList;
    }

    @GetMapping("/verifyAccount")
    @ApiOperation("验证用户账号是否存在")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账号", required = true, paramType = "query")
    })
    public void findverifyAccount(@ApiIgnore TSysAccount tSysAccount) {
        tSysAccount.setDelFlag(0);
        List<TSysAccount> tSysAccountList = tSysAccountService.selectAccountList(tSysAccount);
    }

    @PutMapping("/updatePW")
    @ApiOperation("修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户Id", required = true, paramType = "path"),
            @ApiImplicitParam(name = "oldPassword", value = "旧密码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "query")
    })
    public void updatePW(@ApiIgnore TSysAccount tSysAccount, HttpServletRequest request) {


        TSysAccount sysAccount = tSysAccountService.selectByPrimaryKey(tSysAccount.getId());
        tSysAccountService.updateByPrimaryKeySelective(tSysAccount);
    }



}
