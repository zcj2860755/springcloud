package com.zdzc.controller;

import com.zdzc.common.CommonStatus;
import com.zdzc.common.PageList;
import com.zdzc.common.Token;
import com.zdzc.enums.ExceptionEnum;
import com.zdzc.model.TSysAccount;
import com.zdzc.model.TSysProject;
import com.zdzc.model.TSysRole;
import com.zdzc.model.TSysRoleAuthority;
import com.zdzc.service.ITSysAccountService;
import com.zdzc.service.ITSysProjectService;
import com.zdzc.service.ITSysRoleAuthorityService;
import com.zdzc.service.ITSysRoleService;
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
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @Author  zcj
 * @Description // 用户相关
 * @Date 15:47 2019/8/8
 **/
@RestController
@RequestMapping("/account")
@Api(description="用户接口API")
public class TSysAccountController extends BaseController {
    @Resource
    private ITSysAccountService tSysAccountService;

    @Resource
    private ITSysRoleAuthorityService tSysRoleAuthorityService;

    @Resource
    private ITSysRoleService sysRoleService;

    @Resource
    private ITSysProjectService tSysProjectService;

    @PostMapping()
    @ApiOperation("新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账号", required = true, paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = false, paramType = "query"),
            @ApiImplicitParam(name = "realName", value = "用户名", required = true, paramType = "query"),
            @ApiImplicitParam(name = "tel", value = "联系电话", required = true, paramType = "query"),
            @ApiImplicitParam(name = "roleId", value = "角色id", required = true, paramType = "query")

    })
    public void add(@ApiIgnore TSysAccount tSysAccount){
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

        String passWord = CommonStatus.DEFAULTPASSWORD;
        if(StringUtils.isEmpty(tSysAccount.getPassword())){
            passWord = MD5.getMD5Str(passWord);
        }else{
            passWord = MD5.getMD5Str(tSysAccount.getPassword());
        }
        tSysAccount.setPassword(passWord);
        tSysAccount.setProId(getLoginUser().getProId());
        int result = tSysAccountService.insert(tSysAccount);
        if(result == -1){
            throw new BaseException(ExceptionEnum.SYSTEM_ADD_ERROR_RESON);
        }
    }
    @PostMapping("/login")
    @ApiOperation("用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "account", value = "账号", required = true, paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "query")
    })
    public Token login(@ApiIgnore TSysAccount tSysAccount, HttpServletRequest request){
        HttpSession session = request.getSession();
        Token token = new Token();
        tSysAccount.setPassword(MD5.getMD5Str(tSysAccount.getPassword()));
        Map<String,Object> result= tSysAccountService.login(tSysAccount);

        if(result.get("isLogin").equals(1)){
            throw new BaseException(ExceptionEnum.SYSTEM_LOGIN_ERROR_RESON2);
        }
        if(result.get("isLogin").equals(2)){
            throw new BaseException(ExceptionEnum.SYSTEM_LOGIN_ERROR_DJ);
        }
        if(result.get("isLogin").equals(-1)){
            throw new BaseException(ExceptionEnum.SYSTEM_LOGIN_ERROR_RESON);
        }
        if(result.get("isLogin").equals(0)){
            TSysAccount userInfo=(TSysAccount)result.get("userInfo");
            session.setMaxInactiveInterval(-1);
            token.setUuid(session.getId());
            token.setUserId(userInfo.getId());
            token.setRealName(userInfo.getRealName());
            token.setProId(userInfo.getProId());
            token.setRoleId(userInfo.getRoleId());
            TSysAccount account = new TSysAccount();
            account.setId(userInfo.getId());
            account.setLastloginTime(new Date());
            tSysAccountService.updateByPrimaryKey(account);
            //根据用户角色,获取权限集合
            TSysRoleAuthority roleAuthority = new TSysRoleAuthority();
            roleAuthority.setRoleId(userInfo.getRoleId());
            Set<String>  authIds = tSysRoleAuthorityService.selectRoleList(roleAuthority);
            if(authIds == null || authIds.size()==0){
                throw new BaseException(ExceptionEnum.USER_ROLE_NOPOWER);
            }
            token.setSignSet(authIds);
            session.setAttribute(CommonStatus.ACCOUNT,token);
        }
        return token;
    }

    @PostMapping("/logout")
    @ApiOperation("用户退出")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", required = false, paramType = "query")
    })
    public void logout(@ApiIgnore TSysAccount tSysAccount, HttpServletRequest request) {
        clearUser();
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
        TSysAccount account = new TSysAccount();
        account.setIds(ids==null?id:ids);
        int result = tSysAccountService.deleteByPrimaryKey(account);
        if(result==0){
            throw new BaseException(ExceptionEnum.SYSTEM_DELETE_ERROR);
        }
        if(result==-1){
            throw new BaseException(ExceptionEnum.SYSTEM_DELETE_ERROR_RESON);
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

        TSysAccount account = tSysAccountService.selectByPrimaryKey(tSysAccount.getId());
        tSysAccountService.updateByPrimaryKeySelective(tSysAccount);
        //当用户修改自身的角色和账号时，需要清空session
        if(tSysAccount.getId().equals(getLoginUser().getUserId()) && (
            (!StringUtils.isEmpty(tSysAccount.getAccount()) && !tSysAccount.getAccount().equals(account.getAccount())) ||
            (!StringUtils.isEmpty(tSysAccount.getRoleId()) && !tSysAccount.getRoleId().equals(account.getRoleId()))
            )){
            clearUser();
            throw new BaseException(ExceptionEnum.USER_UPDATE_NEEDLOGIN);
        }
        Token token = getLoginUser();
        //冻结自身用户清空session
        if(tSysAccount.getId().equals(getLoginUser().getUserId()) && 1 == tSysAccount.getStatus()){
            clearUser();
            throw new BaseException(ExceptionEnum.USER_UPDATE_NEEDLOGIN);
        }
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
        TSysAccount account =  tSysAccountService.selectByPrimaryKey(id);
        TSysRoleAuthority roleAuthority = new TSysRoleAuthority();
        roleAuthority.setRoleId(account.getRoleId());
        Set<String>  authIds = tSysRoleAuthorityService.selectRoleList(roleAuthority);
        account.setAuthIds(authIds);
        return  account;
    }

    @GetMapping("/list")
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示", required = false, paramType = "query"),
            @ApiImplicitParam(name = "searchContent", value = "查询内容", required = false, paramType = "query")
    })
    public PageList<TSysAccount> list(@ApiIgnore TSysAccount tSysAccount) {
        tSysAccount.setDelFlag(0);
        Token token =getLoginUser();

        Map<String,Object> map = getManageProjectIds();
        String userType = map.get(CommonStatus.USER_TYPE).toString();
        List<String> list = (List<String>) map.get(CommonStatus.PROJECTIDS);
        if(CommonStatus.USER_MANAGER.equals(userType)){
            tSysAccount.setProjectIds(list);
        }else if(CommonStatus.USER_COMMON.equals(userType)){
            tSysAccount.setId(token.getUserId());
        }

        PageList<TSysAccount> tSysAccountPageList = tSysAccountService.selectAccountPageList(tSysAccount);
        List<TSysAccount> sysAccountList = tSysAccountPageList.getList();
        List<TSysAccount> resultList = new ArrayList<TSysAccount>();
        for(TSysAccount sysAccount : sysAccountList){
            if(!StringUtils.isEmpty(sysAccount)) {
                TSysRole role = sysRoleService.selectByPrimaryKey(sysAccount.getRoleId());
                if (!StringUtils.isEmpty(role)) {
                    sysAccount.setRoleName(role.getRoleName());
                }
                resultList.add(sysAccount);
            }
        }
        tSysAccountPageList.setList(resultList);
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
        tSysAccount.setProId(getLoginUser().getProId());
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
        if(!StringUtils.isEmpty(tSysAccountList) && tSysAccountList.size()>0){
            throw new BaseException(ExceptionEnum.SYSTEM_ADD_ERROR_RESON);
        }
    }

    @PutMapping("/updatePW")
    @ApiOperation("修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户Id", required = true, paramType = "path"),
            @ApiImplicitParam(name = "oldPassword", value = "旧密码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "query")
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


        TSysAccount sysAccount = tSysAccountService.selectByPrimaryKey(tSysAccount.getId());
        if(sysAccount.getPassword().equals(MD5.getMD5Str(tSysAccount.getOldPassword())) && !StringUtils.isEmpty(tSysAccount.getPassword())){
            tSysAccount.setPassword(MD5.getMD5Str(tSysAccount.getPassword()));
        }else{
            throw new BaseException(ExceptionEnum.SYSTEM_UPDATE_ERROR_RESON);
        }
        clearUser();
        tSysAccountService.updateByPrimaryKeySelective(tSysAccount);
    }

    @GetMapping("/ableUserList")
    @ApiOperation("查询启用的用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "projectId", value = "项目Id", required = false, paramType = "query")
    })
    public List<TSysAccount> list(String projectId) {
        Token token = getLoginUser();
        TSysAccount tSysAccount = new TSysAccount();
        Map<String,Object> map = getManageProjectIds();
        String userType = map.get(CommonStatus.USER_TYPE).toString();
        List<String> list = (List<String>) map.get(CommonStatus.PROJECTIDS);
        //设备编辑时，查询启用的用户

        //设备新增是查询，启用用户
        if(!StringUtils.isEmpty(projectId)){
            if(CommonStatus.USER_MANAGER.equals(userType)){
                tSysAccount.setProjectIds(list);
            }else if(CommonStatus.USER_COMMON.equals(userType)){
                tSysAccount.setId(token.getUserId());
            }
        }
        tSysAccount.setDelFlag(0);
        tSysAccount.setStatus(0);
        return tSysAccountService.selectAccountAbleList(tSysAccount);
    }

}
