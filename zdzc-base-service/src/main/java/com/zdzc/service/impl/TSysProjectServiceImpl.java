package com.zdzc.service.impl;

import com.github.pagehelper.PageHelper;

import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;
import com.zdzc.dao.TSysAccountMapper;
import com.zdzc.dao.TSysProjectMapper;
import com.zdzc.enums.ExceptionEnum;
import com.zdzc.model.TSysAccount;
import com.zdzc.model.TSysProject;
import com.zdzc.service.ITSysProjectService;
import com.zdzc.utils.ArrayUtil;
import com.zdzc.utils.BaseException;
import com.zdzc.utils.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;


/**
 * Created by zahngchangjiang on 2018/12/14.
 */
@Service
public class TSysProjectServiceImpl implements ITSysProjectService {
    @Resource
    private TSysProjectMapper tSysProjectMapper;

    @Resource
    private TSysAccountMapper sysAccountMapper;

    @Override
    public int countByExample(TSysProject tSysProject) {
        return 0;
    }

    @Override
    public int deleteByExample(TSysProject tSysProject) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        List<String> idList = Arrays.asList(id.replace(" ","").split(","));//根据逗号分隔转化为
        TSysProject tSysProject = new TSysProject();
        int affectNum = 0;
        for(String Id :idList) {
            tSysProject.setParentId(Id);
            if (tSysProjectMapper.selectCount(tSysProject) > 0) {
                throw new BaseException(ExceptionEnum.POWER_CHILD_EXIST);
            }
            TSysAccount account = new TSysAccount();
            account.setProId(Id);
            account.setDelFlag(0);
            if(sysAccountMapper.selectCount(account)>0){
                throw new BaseException(ExceptionEnum.POWER_USER_EXIST);
            }
            affectNum = tSysProjectMapper.deleteByPrimaryKey(Id);
            if (affectNum == 0) {
                throw new BaseException(ExceptionEnum.SYSTEM_DELETE_ERROR);
            }
        }
        return affectNum;
    }

    @Override
    public int insert(TSysProject tSysProject) {
        return 0;
    }

    @Override
    public int insertSelective(TSysProject tSysProject) {
        TSysProject proParams = new TSysProject();
        proParams.setProName(tSysProject.getProName());
        if(tSysProjectMapper.selectProjectNameCount(proParams)>0){
            throw new BaseException(ExceptionEnum.PROJECT_NAME_EXIST);
        }

        //先判断该用户下面有木有绑定设备，如果有则看该设备属于哪个项目，不属于的提示要解绑 ，是否可以绑
        if(!org.springframework.util.StringUtils.isEmpty(tSysProject.getUserIds()) && tSysProject.getUserIds().length > 0){
            List<String> arrayList = new ArrayList<>();
            for(String userId : tSysProject.getUserIds()){
                userId = ArrayUtil.replace(userId);
                //TODO 与项目相关的

            }
            if(arrayList.size()>0){
                throw new BaseException(ExceptionEnum.PROJECT_ERROR.getCode(),ExceptionEnum.PROJECT_ERROR.getMsg().replace("[]",arrayList.toString()).replace("[]",""));
            }

        }
        int result = 0 ;
        tSysProject.setId(UUIDUtils.getUUID());
        tSysProject.setCreateTime(new Date());
        //串联id
        if(!StringUtils.isEmpty(tSysProject.getCascadeId()) && tSysProject.getCascadeId().length()>30){
            String caseId = tSysProject.getCascadeId().substring(0,32);
            //判断是否是顶级
            TSysProject sb =  selectByPrimaryKey(caseId);
            caseId =ArrayUtil.replace(sb.getCascadeId() +","+ tSysProject.getCascadeId());
            tSysProject.setCascadeId(caseId);
        }
        result = tSysProjectMapper.insertSelective(tSysProject);
        //选择用户，将该用户绑定到项目。   换绑
        if(!org.springframework.util.StringUtils.isEmpty(tSysProject.getUserIds()) && tSysProject.getUserIds().length > 0){
            TSysAccount account = new TSysAccount();
            account.setProId(tSysProject.getId());
            account.setIsbind(1);
            for(String userId : tSysProject.getUserIds()){
                userId = ArrayUtil.replace(userId);
                account.setId(userId);
                sysAccountMapper.updateByPrimaryKeySelective(account);
            }
        }

        return result;
    }

    @Override
    public List<TSysProject> selectByExample(TSysProject tSysProject) {
        // 原始的数据
        String cascadeId = "" ;
        String firstcascadeId = "" ;
        List<TSysProject> projectList = null;
        cascadeId = tSysProject.getCascadeId();
        //超管
        if(StringUtils.isEmpty(tSysProject.getId()) || StringUtils.isEmpty(cascadeId)){
            projectList= tSysProjectMapper.selectAll();
            if(!StringUtils.isEmpty(tSysProject.getCascadeId())){
                cascadeId = tSysProject.getCascadeId();
            }else{
                cascadeId = "";
            }
        }else if(!StringUtils.isEmpty(tSysProject) && !StringUtils.isEmpty(tSysProject.getId())){
            //不找当前项目级以及子集
            projectList = tSysProjectMapper.selectParamsNot(tSysProject);
            //排除当前项目顶父级以外的其他顶父级
            TSysProject tSysProjectPare = tSysProjectMapper.selectByPrimaryKey(tSysProject.getId());
            if(StringUtils.isEmpty(tSysProjectPare.getCascadeId())){//顶级
                TSysProject project = new TSysProject();
                project.setId(tSysProject.getId());
                projectList = tSysProjectMapper.select(project);
            }else{
                //获取顶级的父id
                firstcascadeId = tSysProjectPare.getCascadeId().substring(0,32);
            }
        }
        // 最后的结果
        List<TSysProject> TSysProjectList = new ArrayList<TSysProject>();
        // 先找到所有的一级菜单
        for (int i = 0; i < projectList.size(); i++) {
            // 一级菜单没有parentId
            if (projectList.get(i).getParentId().equals("0") && StringUtils.isEmpty(cascadeId)) {
                if(StringUtils.isEmpty(firstcascadeId)){
                    TSysProjectList.add(projectList.get(i));
                }/*else if(firstcascadeId.equals(projectList.get(i).getId())){
                    TSysProjectList.add(projectList.get(i));
                }*/

            }
            if(cascadeId.equals(projectList.get(i).getId())){
                TSysProjectList.add(projectList.get(i));
            }
        }
        // 为一级菜单设置子菜单，getChild是递归调用的
        for (TSysProject TSysProject : TSysProjectList) {
            TSysProject.setChildTSysProject(getChild(TSysProject.getId(), projectList));
        }
        return TSysProjectList ;

    }

    @Override
    public PageList<TSysProject> selectParamsList(TSysProject tSysProject, BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNo(),baseRequest.getPageSize());
        return new PageList<TSysProject>(tSysProjectMapper.selectParamsBySreach(tSysProject));
    }

    @Override
    public TSysProject selectByPrimaryKey(String id) {
        List<String>  list = new ArrayList<>();
        TSysProject result = tSysProjectMapper.selectByPrimaryKey(id);
        TSysProject result2 = result;
        while (!org.springframework.util.StringUtils.isEmpty(result.getParentId()) && !result.getParentId().equals("0")){
            TSysProject project = tSysProjectMapper.selectByPrimaryKey(result.getParentId());
            result = project;
            list.add(result.getId());
        }
        if(list.size()>0){
            Collections.reverse(list);
        }

        TSysAccount tSysAccount = new TSysAccount();
        tSysAccount.setProId(id);
        /*tSysAccount.setIsbind(1);
        result2.setUserIds(sysAccountMapper.selectProjectManger(tSysAccount));*/
        result2.setCascadeId(list.toString().replace(" ",""));
        return result2;
    }

    @Override
    public int updateByExampleSelective(TSysProject tSysProject) {
        int result = 0 ;
        result = tSysProjectMapper.updateByExampleSelective(tSysProject);
        if(!StringUtils.isEmpty(tSysProject.getUserIds()) && tSysProject.getUserIds().length > 0){

            TSysAccount account = new TSysAccount();
            account.setProId(tSysProject.getId());
            account.setIsbind(1);
            //修改先解绑已经绑定的用户
            List<TSysAccount> accountList = sysAccountMapper.select(account);
            if(!StringUtils.isEmpty(accountList)){
                for(TSysAccount sysAccount : accountList){
                    sysAccount.setIsbind(0);
                    sysAccount.setProId(null);
                    sysAccountMapper.updateByPrimaryKeySelective(account);
                }
            }
            for(String userId : tSysProject.getUserIds()){
                account.setId(userId);
                sysAccountMapper.updateByPrimaryKeySelective(account);
            }
        }
        return result;
    }

    @Override
    public int updateByExample(TSysProject tSysProject, TSysProject tSysProjectChange) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(TSysProject tSysProject) {
        //更新时，项目名唯一性校验
        TSysProject proParams = new TSysProject();
        proParams.setProName(tSysProject.getProName());
        proParams.setId(tSysProject.getId());
        if(tSysProjectMapper.selectProjectNameCount(proParams)>0){
            throw new BaseException(ExceptionEnum.PROJECT_NAME_EXIST);
        }

        //先判断该用户下面有木有绑定设备，如果有则看该设备属于哪个项目，不属于的提示要解绑 ，是否可以绑
        //TODO 是否有与项目相关的
        if(!StringUtils.isEmpty(tSysProject.getUserIds()) && tSysProject.getUserIds().length > 0) {
            List<String> arrayList = new ArrayList<>();
           /* TDeviceInfo  deviceInfo = new TDeviceInfo();
            for(String userId : tSysProject.getUserIds()){
                userId = ArrayUtil.replace(userId);
                deviceInfo.setAccountId(userId);
                deviceInfo.setDelFlag(TDeviceInfo.DEVICE_NORMAL);
                List<TDeviceInfo>   deviceInfoList = deviceInfoMapper.select(deviceInfo);
                if(!StringUtils.isEmpty(deviceInfoList) && deviceInfoList.size() > 0){
                    for(TDeviceInfo deviceInfo1 : deviceInfoList){
                        if(!StringUtils.isEmpty(deviceInfo1.getProjectId()) && !deviceInfo1.getProjectId().equals(tSysProject.getId()) && !"0".equals(deviceInfo1.getProjectId())){
                            //获取用户名
                            TSysAccount account = sysAccountMapper.selectByPrimaryKey(userId);
                            arrayList.add(CommonStatus.getResultMsg(account.getRealName()));
                            break;
                        }

                    }

                }

            }
            if(arrayList.size()>0){
                throw new BaseException(ExceptionEnum.PROJECT_ERROR.getCode(),ExceptionEnum.PROJECT_ERROR.getMsg().replace("[]",arrayList.toString()).replace("[]",""));
            }

        }
*/
        }
        int result = 0 ;
        if(StringUtils.isEmpty(tSysProject.getParentId())){
            tSysProject.setParentId("0");
        }else {
            ////判断选择的父级是否是自己的子集，防止递归无法结束
            //如果是管理员编辑则有孙子级
            if (tSysProject.getId().equals(tSysProject.getParentId())) {
                throw new BaseException(ExceptionEnum.PROJECT_UPDATE_ERROR);
            }
            if (!StringUtils.isEmpty(tSysProject.getCascadeId())) {
                String parentIds = tSysProject.getCascadeId();
                String[] parentIdArray = parentIds.split(",");
                if (parentIdArray.length > 0) {
                    for (String parentId : parentIdArray) {
                        if (tSysProject.getId().equals(parentId)) {
                            throw new BaseException(ExceptionEnum.PROJECT_UPDATE_ERROR);
                        }
                    }
                }
            }
        }
        if(!StringUtils.isEmpty(tSysProject.getCascadeId()) && tSysProject.getCascadeId().length()>30){
            String caseId = tSysProject.getCascadeId().substring(0,32);
            //判断是否是顶级
            TSysProject sb =  selectByPrimaryKey(caseId);
            caseId =ArrayUtil.replace(sb.getCascadeId() +","+ tSysProject.getCascadeId());
            tSysProject.setCascadeId(caseId);
        }
        result = tSysProjectMapper.updateByPrimaryKeySelective(tSysProject);
        TSysAccount account = new TSysAccount();
        account.setProId(tSysProject.getId());
        //先解绑
        sysAccountMapper.updateByProjectId(account);
        //再绑定
        if(!StringUtils.isEmpty(tSysProject.getUserIds()) && tSysProject.getUserIds().length > 0){
            for(String userId : tSysProject.getUserIds()){
                account.setId(userId);
                account.setIsbind(1);
                sysAccountMapper.updateByPrimaryKeySelective(account);
                //对于用户下的设备也要此操作
                // TODO

            }
        }
        return result;
    }

    @Override
    public int updateByPrimaryKey(TSysProject tSysProject) {
        return 0;
    }

    @Override
    public List<String> selectProjectByIdAndCascade(TSysProject tSysProject) {
        return tSysProjectMapper.selectProjectByIdAndCascade(tSysProject);
    }

        /**
         * 递归查找子菜单
         *
         * @param id
         *            当前菜单id
         * @param rootTSysProject
         *            要查找的列表
         * @return
         */
        private List<TSysProject> getChild(String id, List<TSysProject> rootTSysProject) {
            // 子菜单
            List<TSysProject> childList = new ArrayList<>();
            for (TSysProject TSysProject : rootTSysProject) {
                // 遍历所有节点，将父菜单id与传过来的id比较
                if (!StringUtils.isEmpty(TSysProject.getParentId())) {
                    if (TSysProject.getParentId().equals(id)) {
                        childList.add(TSysProject);
                    }
                }
            }
            for (TSysProject TSysProject : rootTSysProject) {
                // 把子菜单的子菜单再循环一遍
                for (TSysProject tSysProjectChild : childList) {// 判断该菜单id，是否是其他菜单的父id，是的话，递归继续

                    if (!StringUtils.isEmpty(tSysProjectChild.getId())) {
                        if (tSysProjectChild.getId().equals(TSysProject.getParentId())) {
                            // 递归
                            tSysProjectChild.setChildTSysProject(getChild(tSysProjectChild.getId(), rootTSysProject));
                        }
                    }
                }
            }
            // 递归退出条件
            if (childList.size() == 0) {
                return null;
            }
            return childList;
        }


}
