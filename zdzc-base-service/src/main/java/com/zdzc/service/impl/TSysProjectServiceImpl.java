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
        tSysProject.setId(UUIDUtils.getUUID());
        tSysProject.setCreateTime(new Date());
        //串联id
        if("0".equals(tSysProject.getParentId())){
            tSysProject.setCascadeId("0&");
        }else{
            TSysProject temp = tSysProjectMapper.selectByPrimaryKey(tSysProject.getParentId());
            tSysProject.setCascadeId(temp.getCascadeId()+temp.getId()+"&");
        }
        return tSysProjectMapper.insertSelective(tSysProject);
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
            if("0&".equals(tSysProjectPare.getCascadeId())){//顶级
                TSysProject project = new TSysProject();
                project.setId(tSysProject.getId());
                projectList = tSysProjectMapper.select(project);
            }else{
                //获取顶级的父id
                firstcascadeId = tSysProjectPare.getCascadeId().split("&")[0];
            }
        }
        // 最后的结果
        List<TSysProject> TSysProjectList = new ArrayList<TSysProject>();
        // 先找到所有的一级菜单
        for (int i = 0; i < projectList.size(); i++) {
            // 一级菜单没有parentId
            if (projectList.get(i).getParentId().equals("0")) {
                TSysProjectList.add(projectList.get(i));
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
    public PageList<TSysProject> selectParamsList(TSysProject tSysProject) {
        PageHelper.startPage(tSysProject.getPageNo(),tSysProject.getPageSize());
        return new PageList<TSysProject>(tSysProjectMapper.selectParamsBySreach(tSysProject));
    }

    @Override
    public TSysProject selectByPrimaryKey(String id) {
        List<String>  list = new ArrayList<>();
        TSysProject result = tSysProjectMapper.selectByPrimaryKey(id);
        TSysProject result2 = result;
        while (!StringUtils.isEmpty(result.getParentId()) && !"0".equals(result.getParentId())){
            TSysProject project = tSysProjectMapper.selectByPrimaryKey(result.getParentId());
            result = project;
            list.add(result.getId());
        }
        if(list.size()>0){
            Collections.reverse(list);
        }

        TSysAccount tSysAccount = new TSysAccount();
        tSysAccount.setProId(id);
        result2.setCascadeId(list.toString().replace(" ",""));
        return result2;
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

        if(StringUtils.isEmpty(tSysProject.getParentId())){
            tSysProject.setParentId("0");
        }else {
            //判断选择的父级是否是自己的子集，防止递归无法结束
            //如果是管理员编辑则有孙子级
            if (tSysProject.getId().equals(tSysProject.getParentId())) {
                throw new BaseException(ExceptionEnum.PROJECT_UPDATE_ERROR);
            }
            String parentIds = tSysProject.getCascadeId()==null?"":tSysProject.getCascadeId();
            if(parentIds.contains(tSysProject.getId())){
                throw new BaseException(ExceptionEnum.PROJECT_UPDATE_ERROR);
            }
        }
        if("0".equals(tSysProject.getParentId())){
            tSysProject.setCascadeId("0&");
        }else{
            TSysProject temp = tSysProjectMapper.selectByPrimaryKey(tSysProject.getParentId());
            tSysProject.setCascadeId(temp.getCascadeId()+temp.getId()+"&");
        }
        return tSysProjectMapper.updateByPrimaryKeySelective(tSysProject);
    }

    @Override
    public List<String> selectProjectByIdAndCascade(TSysProject tSysProject) {
        return tSysProjectMapper.selectProjectByIdAndCascade(tSysProject);
    }

    @Override
    public String selectProjectAllPath(String[] ids, String seperator) {
        return tSysProjectMapper.selectProjectAllPath(ids,seperator);
    }

    @Override
    public TSysProject selectProjectById(String id) {
        return tSysProjectMapper.selectByPrimaryKey(id);
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
