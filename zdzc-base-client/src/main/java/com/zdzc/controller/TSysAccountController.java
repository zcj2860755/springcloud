package com.zdzc.controller;

import com.zdzc.common.PageList;
import com.zdzc.common.Token;
import com.zdzc.enums.ExceptionEnum;
import com.zdzc.model.TSysAccount;
import com.zdzc.service.FeignTSysAccountService;
import com.zdzc.utils.BaseException;
import com.zdzc.utils.ObjectUtils;
import com.zdzc.utils.rsa.MD5;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author  zcj
 * @Description // 用户相关
 * @Date 15:47 2019/8/8
 **/
@RestController
@RequestMapping("/account")
@Api(description="用户接口API")
public class TSysAccountController {
    @Resource
    private FeignTSysAccountService feignTSysAccountService;


    @PostMapping()
    @ApiOperation("新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账号", required = true, paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = false, paramType = "query"),
            @ApiImplicitParam(name = "realName", value = "用户名", required = true, paramType = "query"),
            @ApiImplicitParam(name = "tel", value = "联系电话", required = true, paramType = "query"),
            @ApiImplicitParam(name = "roleId", value = "角色id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "uuid", value = "用户token", required = true, paramType = "query")

    })
    public void add(@ApiIgnore TSysAccount tSysAccount){
        if(StringUtils.isEmpty(tSysAccount.getUuid())){
            throw new BaseException(ExceptionEnum.SYSTEM_USER_TOKEN);
        }
        if(StringUtils.isEmpty(tSysAccount.getRealName())){
            throw new BaseException(ExceptionEnum.USER_REALNAME_NULL);
        }

        if(StringUtils.isEmpty(tSysAccount.getAccount())){
            throw new BaseException(ExceptionEnum.USER_ACCOUNT_NULL);
        }

        if(StringUtils.isEmpty(tSysAccount.getRoleId())){
            throw new BaseException(ExceptionEnum.USER_ROLEID_NULL);

        }

        if(StringUtils.isEmpty(tSysAccount.getTel())){
            throw new BaseException(ExceptionEnum.USER_PHONE_NULL);
        }
        feignTSysAccountService.add(tSysAccount);

    }
    @PostMapping("/login")
    @ApiOperation("用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账号", required = true, paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "timestamp", value = "当前时间戳", required = false, paramType = "query")
    })
    public Token login(@ApiIgnore TSysAccount tSysAccount, HttpServletRequest request){
        return feignTSysAccountService.login(tSysAccount);
    }

    @PostMapping("/logout")
    @ApiOperation("用户退出")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", required = false, paramType = "query"),
            @ApiImplicitParam(name = "uuid", value = "用户token", required = true, paramType = "query")
    })
    public void logout(@ApiIgnore TSysAccount tSysAccount, HttpServletRequest request) {
        feignTSysAccountService.logout(tSysAccount);
    }

    @DeleteMapping("/deleteAccount")
    @ApiOperation("删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "用户主键",allowMultiple = true, required = true, paramType = "query")
    })
    public void delete(@RequestParam(value="ids[]",required = false) String[] ids, @RequestParam(value="ids",required = false)String[] id)  {
        if(ObjectUtils.isEmpty(ids) && ObjectUtils.isEmpty(id)){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSIDS_NULL);
        }
        feignTSysAccountService.delete(ids,id);

    }

    @PutMapping
    @ApiOperation("更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uuid", value = "用户token", required = true, paramType = "query"),
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
        if(StringUtils.isEmpty(tSysAccount.getId())){
            throw new BaseException(ExceptionEnum.USER_ID_NULL);
        }

        if(StringUtils.isEmpty(tSysAccount.getRealName())){
            throw new BaseException(ExceptionEnum.USER_REALNAME_NULL);
        }

        if(StringUtils.isEmpty(tSysAccount.getAccount())){
            throw new BaseException(ExceptionEnum.USER_ACCOUNT_NULL);
        }

        if(StringUtils.isEmpty(tSysAccount.getRoleId())){
            throw new BaseException(ExceptionEnum.USER_ROLEID_NULL);
        }

        if(StringUtils.isEmpty(tSysAccount.getStatus())){
            throw new BaseException(ExceptionEnum.USER_STATUS_NULL);
        }

        if(StringUtils.isEmpty(tSysAccount.getTel())){
            throw new BaseException(ExceptionEnum.USER_PHONE_NULL);
        }

        if(StringUtils.isEmpty(tSysAccount.getPassword())){
            tSysAccount.setPassword(null);
        }else{
            tSysAccount.setPassword(MD5.getMD5Str(tSysAccount.getPassword()));
        }
        feignTSysAccountService.update(tSysAccount);


    }

    @GetMapping("/{id}")
    @ApiOperation("获取详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户Id", required = true, paramType = "path")
    })
    public TSysAccount detail(@PathVariable String id) {
        if(ObjectUtils.isEmpty(id)){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSID_NULL);
        }

        return  feignTSysAccountService.detail(id);
    }

    @GetMapping("/list")
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示", required = false, paramType = "query"),
            @ApiImplicitParam(name = "searchContent", value = "查询内容", required = false, paramType = "query"),
            @ApiImplicitParam(name = "uuid", value = "用户token", required = true, paramType = "query")
    })
    public PageList<TSysAccount> list(@ApiIgnore TSysAccount tSysAccount) {
        return feignTSysAccountService.list(tSysAccount);
    }

    @GetMapping("/manger")
    @ApiOperation("获取该项目下未绑定的用户加项目自身管理员")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "proId", value = "项目", required = false, paramType = "query"),
            @ApiImplicitParam(name = "uuid", value = "用户token", required = true, paramType = "query")
    })
    public List<TSysAccount> findMangerList(@ApiIgnore TSysAccount tSysAccount) {

        return feignTSysAccountService.findMangerList(tSysAccount);
    }

    @GetMapping("/verifyAccount")
    @ApiOperation("验证用户账号是否存在")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账号", required = true, paramType = "query")
    })
    public void findverifyAccount(@ApiIgnore TSysAccount tSysAccount) {
        feignTSysAccountService.findverifyAccount(tSysAccount);

    }

    @PutMapping("/updatePW/{id}")
    @ApiOperation("修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户Id", required = true, paramType = "path"),
            @ApiImplicitParam(name = "oldPassword", value = "旧密码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "uuid", value = "用户token", required = true, paramType = "query")
    })
    public void updatePW(@ApiIgnore TSysAccount tSysAccount, HttpServletRequest request) {
        if(StringUtils.isEmpty(tSysAccount.getId())){
            throw new BaseException(ExceptionEnum.USER_ID_NULL);
        }

        if(StringUtils.isEmpty(tSysAccount.getOldPassword())){
            throw new BaseException(ExceptionEnum.USER_OLDPASSWORD_NULL);
        }

        if(StringUtils.isEmpty(tSysAccount.getPassword())){
            throw new BaseException(ExceptionEnum.USER_NEWPASSWORD_NULL);
        }
        feignTSysAccountService.updatePW(tSysAccount.getId(),tSysAccount);


    }

    @GetMapping("/ableUserList")
    @ApiOperation("查询启用的用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "projectId", value = "项目Id", required = false, paramType = "query"),
            @ApiImplicitParam(name = "uuid", value = "用户token", required = true, paramType = "query")
    })
    public List<TSysAccount> list(String projectId,String uuid) {
        return feignTSysAccountService.list(projectId,uuid);
    }

}
