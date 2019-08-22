package com.zdzc.controller;



import com.zdzc.common.CommonStatus;
import com.zdzc.common.Token;
import com.zdzc.enums.ExceptionEnum;
import com.zdzc.model.TSysAccount;
import com.zdzc.model.TSysProject;
import com.zdzc.redis.RedisService;
import com.zdzc.service.ITSysAccountService;
import com.zdzc.service.ITSysProjectService;
import com.zdzc.utils.BaseException;
import com.zdzc.utils.EncryUtil;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseController {

    @Resource
    protected ITSysAccountService tSysAccountService;

    @Resource
    protected ITSysProjectService tSysProjectService;

    @Resource
    private RedisService redisService;

    /**
     * 获取登陆的用户信息，未登陆报错
     * @return
     */
    protected Token getLoginUser(String uuid) {
        if(redisService.exists(uuid)){
            Token token  = (Token) redisService.get(uuid);
            //如果项目Id为0，表示超级管理员，超级管理员查询所有
            if("0".equals(token.getProId())){
                token.setProId(null);
            }
            return token;
        }else{
            throw new BaseException(ExceptionEnum.SYSTEM_USER_NOTLOGIN);
        }
    }

    /**
     * 获取登陆的用户信息，未登陆不报错
     * @return
     */
    protected Token getUser(String uuid) {
        Token token  = (Token) redisService.get(uuid);
        return token;
    }

    /**
     * 清空用户信息
     */
    protected  void clearUser(String uuid){
        redisService.remove(uuid);
    }

    /**
     * 获取用户具有的权限
     * @return  Map userId-用户Id userType-用户类型，projectIds-项目Id集合
     */
    protected Map<String,Object> getManageProjectIds(String uuid){
        Token token = getLoginUser(uuid);
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

    protected String generateAccessToken(String appId,String appKey,String timestamp) {
        if(StringUtils.isEmpty(appKey)){
            appKey = CommonStatus.ZDZCACCOUNT;
        }
        String tokenNew = EncryUtil.getMd5Str(appId + appKey + timestamp);//根据传参重新生成token
        return tokenNew;
    }


}
