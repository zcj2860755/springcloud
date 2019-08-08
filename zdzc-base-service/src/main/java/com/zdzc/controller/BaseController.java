package com.zdzc.controller;



import com.zdzc.common.CommonStatus;
import com.zdzc.common.Token;
import com.zdzc.enums.ExceptionEnum;
import com.zdzc.model.TSysAccount;
import com.zdzc.model.TSysProject;
import com.zdzc.service.ITSysAccountService;
import com.zdzc.service.ITSysProjectService;
import com.zdzc.utils.BaseException;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseController {

    @Resource
    protected HttpSession session;

    @Resource
    protected ITSysAccountService tSysAccountService;

    @Resource
    protected ITSysProjectService tSysProjectService;

    /**
     * 获取登陆的用户信息，未登陆报错
     * @return
     */
    protected Token getLoginUser() {
        Object obj = session.getAttribute(CommonStatus.ACCOUNT);
        if (obj == null) {
            throw new BaseException(ExceptionEnum.SYSTEM_USER_NOTLOGIN);
        }
        Token token = (Token) obj;
        //如果项目Id为0，表示超级管理员，超级管理员查询所有
        if("0".equals(token.getProId())){
            token.setProId(null);
        }
        return token;
    }

    /**
     * 获取登陆的用户信息，未登陆不报错
     * @return
     */
    protected Token getUser() {
        Object obj = session.getAttribute(CommonStatus.ACCOUNT);
        return (Token) obj;
    }

    /**
     * 清空用户信息
     */
    protected  void clearUser(){
        session.removeAttribute(CommonStatus.ACCOUNT);
    }

    /**
     * 往session中设置用户信息
     * @param token
     */
    protected  void setUser(Token token){
        session.setAttribute(CommonStatus.ACCOUNT,token);
    }

    /**
     * 获取用户具有的权限
     * @return  Map userId-用户Id userType-用户类型，projectIds-项目Id集合
     */
    protected Map<String,Object> getManageProjectIds(){
        Token token = getLoginUser();
        TSysProject tSysProject = new TSysProject();

        Map<String,Object> map = new HashMap<String,Object>();
        map.put(CommonStatus.USER_ID,token.getUserId());
        if(StringUtils.isEmpty(token.getProId())){
            map.put(CommonStatus.USER_TYPE,CommonStatus.USER_ADMIN);
            map.put(CommonStatus.PROJECTIDS,null);
            return map;
        }

        TSysAccount params= tSysAccountService.selectByPrimaryKey(token.getUserId());
        if(params.getIsbind() == 1){
            tSysProject.setId(token.getProId());
            tSysProject.setCascadeId(token.getProId());
            map.put(CommonStatus.USER_TYPE,CommonStatus.USER_MANAGER);
        }else{
            tSysProject.setId(token.getProId());
            map.put(CommonStatus.USER_TYPE,CommonStatus.USER_COMMON);
        }
        List<String> list = tSysProjectService.selectProjectByIdAndCascade(tSysProject);
        map.put(CommonStatus.PROJECTIDS,list);
        return map;
    }

}
