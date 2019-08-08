package com.zdzc.service.impl;

import com.github.pagehelper.PageHelper;
import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;
import com.zdzc.dao.TSysAuthorityMapper;
import com.zdzc.enums.ExceptionEnum;
import com.zdzc.model.TSysAuthority;
import com.zdzc.service.ITSysAuthorityService;
import com.zdzc.utils.BaseException;
import com.zdzc.utils.UUIDUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @Author  zcj
 * @Description  菜单/按钮 相关信息
 * @Date 10:39 2019/8/7
 * @Param
 * @return
 **/
@Service
public class TSysAuthorityServiceImpl implements ITSysAuthorityService {
    @Resource
    private TSysAuthorityMapper tSysAuthorityMapper;

    @Override
    public int deleteByPrimaryKey(String id){
        TSysAuthority tSysAuthority = new TSysAuthority();
        tSysAuthority.setParentId(id);
        if(tSysAuthorityMapper.selectCount(tSysAuthority)>0){
            throw new BaseException(ExceptionEnum.POWER_CHILD_EXIST);
        }
        return tSysAuthorityMapper.deleteByPrimaryKey(id);
    }


    @Override
    public int insertSelective(TSysAuthority tSysAuthority) {
        tSysAuthority.setId(UUIDUtils.getUUID());
        tSysAuthority.setCreateTime(new Date());
        return tSysAuthorityMapper.insertSelective(tSysAuthority);
    }

    @Override
    public List<TSysAuthority> selectByExample() {
        // 原始的数据
        List<TSysAuthority> authorityList = tSysAuthorityMapper.selectAll();
        // 最后的结果
        List<TSysAuthority> sysAuthorityList = new ArrayList<TSysAuthority>();
        // 先找到所有的一级菜单
        for (int i = 0; i < authorityList.size(); i++) {
            // 一级菜单没有parentId
            if (authorityList.get(i).getParentId().equals("0")) {
                sysAuthorityList.add(authorityList.get(i));
            }
        }
        // 为一级菜单设置子菜单，getChild是递归调用的
        for (com.zdzc.model.TSysAuthority TSysAuthority : sysAuthorityList) {
            TSysAuthority.setChildren(getChild(TSysAuthority.getId(),authorityList));
        }
        return sysAuthorityList ;
    }

    @Override
    public PageList<TSysAuthority> selectParamsList(TSysAuthority tSysAuthority) {
        PageHelper.startPage(tSysAuthority.getPageNo(),tSysAuthority.getPageSize());
        //List<TSysAuthority>  tSysAuthorityList= tSysAuthorityMapper.selectParamsBySreach(tSysAuthority);

        return new PageList<TSysAuthority>(tSysAuthorityMapper.selectParamsBySreach(tSysAuthority));
    }

    @Override
    public TSysAuthority selectByPrimaryKey(String  id) {
        return tSysAuthorityMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TSysAuthority tSysAuthority) {
        return tSysAuthorityMapper.updateByPrimaryKeySelective(tSysAuthority);
    }

    @Override
    public List<TSysAuthority> selectListByIds(TSysAuthority tSysAuthority) {
        List<TSysAuthority>  lists = new ArrayList<>();
        // 最后的结果
        List<TSysAuthority> sysAuthorityList = new ArrayList<TSysAuthority>();
        if(!org.springframework.util.StringUtils.isEmpty(tSysAuthority.getIds()) && tSysAuthority.getIds().size()>0){
            List<String> ids = tSysAuthority.getIds();
            for(String id :  ids){
                String code = id.replace("\"","").replace("[","").replace("]","");
                TSysAuthority authority = tSysAuthorityMapper.selectByPrimaryKey(code);
                if(!org.springframework.util.StringUtils.isEmpty(authority)){
                    lists.add(authority);
                }
            }
        }
        for (int i = 0; i < lists.size(); i++) {
            // 一级菜单没有parentId
            if (lists.get(i).getParentId().equals("0")) {
                sysAuthorityList.add(lists.get(i));
            }
        }
        // 为一级菜单设置子菜单，getChild是递归调用的
        for (com.zdzc.model.TSysAuthority TSysAuthority : sysAuthorityList) {
            TSysAuthority.setChildren(getChild(TSysAuthority.getId(),lists));
        }
        return sysAuthorityList ;
    }

    @Override
    public PageList<TSysAuthority> getAllAuthList(TSysAuthority tSysAuthority) {
        PageHelper.startPage(tSysAuthority.getPageNo(),tSysAuthority.getPageSize());
        return new PageList<TSysAuthority>(tSysAuthorityMapper.selectAllAuthority(tSysAuthority));
    }

    @Override
    public List<TSysAuthority> existAuthSign(TSysAuthority tSysAuthority) {
        return tSysAuthorityMapper.selectAllAuthority(tSysAuthority);
    }

    @Override
    public List<TSysAuthority> defaultAuth(TSysAuthority tSysAuthority) {
        return tSysAuthorityMapper.defaultAuth(tSysAuthority);
    }

    /**
     * 递归查找子菜单
     *
     * @param id
     *            当前菜单id
     * @param rootTSysAuthority
     *            要查找的列表
     * @return
     */
    private List<TSysAuthority> getChild(String id, List<TSysAuthority> rootTSysAuthority) {
        // 子菜单
        List<TSysAuthority> childList = new ArrayList<>();
        for (TSysAuthority Authority : rootTSysAuthority) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (StringUtils.isNotBlank(Authority.getParentId())) {
                if (Authority.getParentId().equals(id)) {
                    childList.add(Authority);
                }
            }
        }
        for (TSysAuthority tSysAuthority : rootTSysAuthority) {
            // 把子菜单的子菜单再循环一遍
            for (TSysAuthority tSysAuthChild : childList) {// 判断该菜单id，是否是其他菜单的父id，是的话，递归继续

                if (StringUtils.isNotBlank(tSysAuthChild.getId())) {
                    if (tSysAuthChild.getId().equals(tSysAuthority.getParentId())) {
                        // 递归
                        tSysAuthChild.setChildren(getChild(tSysAuthChild.getId(), rootTSysAuthority));
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
