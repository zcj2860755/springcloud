package com.zdzc.service;


import com.zdzc.common.BaseRequest;
import com.zdzc.common.PageList;
import com.zdzc.model.TSysRole;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@FeignClient(value = "basic-service")
public interface FeignTSysRoleService {
    /**
     * @Author  zcj
     * @Description //添加角色信息
     * @Date 13:20 2019/8/7
     * @Param [tSysRole]
     * @return void
     **/
    @PostMapping("/role")
    void add(@RequestBody TSysRole tSysRole);

    /**
     * @Author  zcj
     * @Description 删除
     * @Date 13:44 2019/8/7
     * @Param [id]
     * @return void
     **/
    @DeleteMapping("/role/{id}")
    void delete(@PathVariable(value = "id") String id);
    /**
     * @Author  zcj
     * @Description 更新
     * @Date 13:44 2019/8/7
     * @Param [tSysRole]
     * @return void
     **/
    @PutMapping("/role")
    void update(@RequestBody TSysRole tSysRole);
    /**
     * @Author  zcj
     * @Description 获取详情
     * @Date 13:43 2019/8/7
     * @Param [id]
     * @return com.zdzc.model.TSysRole
     **/
    @GetMapping("/role/{id}")
    TSysRole detail(@PathVariable(value = "id") String id);
    /**
     * @Author  zcj
     * @Description 分页查询
     * @Date 13:41 2019/8/7
     * @Param [tSysRole, baseRequest]
     * @return com.zdzc.common.PageList<com.zdzc.model.TSysRole>
     **/
    @PostMapping(value = "/role/pageList")
    PageList<TSysRole> list(@RequestBody TSysRole tSysRole);
    /**
     * @Author  zcj
     * @Description 获取用户角色
     * @Date 13:40 2019/8/7
     * @Param [tSysRole, request]
     * @return java.util.List<com.zdzc.model.TSysRole>
     **/
    @PostMapping("/role/getUserRole")
    List<TSysRole> getUserRole(@RequestBody TSysRole tSysRole);
    /**
     * @Author  zcj
     * @Description //获取所有角色
     * @Date 13:40 2019/8/7
     * @Param []
     * @return java.util.List<com.zdzc.model.TSysRole>
     **/
    @GetMapping("/role/findAllRole")
    List<TSysRole> findAllRole();
    /**
     * @Author  zcj
     * @Description 判断角色是否重复
     * @Date 13:39 2019/8/7
     * @Param [tSysRole]
     * @return void
     **/
    @PostMapping("/role/existRoleSign")
    void getUserRoleName(@RequestBody TSysRole tSysRole);


}
