package com.zdzc.service;


import com.zdzc.common.PageList;
import com.zdzc.common.Token;
import com.zdzc.model.TSysAccount;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@FeignClient(value = "basic-service")
public interface FeignTSysAccountService {

    /**
     * @Author  zcj
     * @Description 用户新增
     * @Date 10:05 2019/8/9
     * @Param [tSysAccount]
     * @return void
     **/
    @PostMapping("/account")
    void add(@RequestBody TSysAccount tSysAccount);



    /**
     * @Author  zcj
     * @Description 用户登录
     * @Date 10:06 2019/8/9
     * @Param [tSysAccount]
     * @return com.zdzc.common.Token
     **/
    @PostMapping("/account/login")
    @ApiOperation("用户登录")
    Token login(@RequestBody TSysAccount tSysAccount);


    /**
     * @Author  zcj
     * @Description 用户退出
     * @Date 10:08 2019/8/9
     * @Param [tSysAccount]
     * @return void
     **/
    @PostMapping("/account/logout")
    void logout(@ApiIgnore TSysAccount tSysAccount) ;


    /**
     * @Author  zcj
     * @Description 删除
     * @Date 10:08 2019/8/9
     * @Param [ids, id]
     * @return void
     **/
    @DeleteMapping("/account/deleteAccount")
    void delete(@RequestParam(value="ids[]",required = false) String[] ids, @RequestParam(value="ids",required = false)String[] id);


    /**
    *
     * @Author  zcj
     * @Description 更新
     * @Date 10:09 2019/8/9
     * @Param [tSysAccount]
     * @return void
     **/
    @PutMapping("/account")
    void update(@RequestBody TSysAccount tSysAccount);


    /**
    *
     * @Author  zcj
     * @Description 获取详情
     * @Date 10:09 2019/8/9
     * @Param [id]
     * @return com.zdzc.model.TSysAccount
     **/
    @GetMapping("/account/{id}")
    TSysAccount detail(@PathVariable(value = "id") String id) ;


    /**
    *
     * @Author  zcj
     * @Description 分页查询
     * @Date 10:10 2019/8/9
     * @Param [tSysAccount]
     * @return com.zdzc.common.PageList<com.zdzc.model.TSysAccount>
     **/
    @PostMapping("/account/list")
    PageList<TSysAccount> list(@RequestBody TSysAccount tSysAccount) ;



    /**
    *
     * @Author  zcj
     * @Description 获取该项目下未绑定的用户加项目自身管理员
     * @Date 10:11 2019/8/9
     * @Param [tSysAccount]
     * @return java.util.List<com.zdzc.model.TSysAccount>
     **/
    @PostMapping("/account/manger")
    List<TSysAccount> findMangerList(@RequestBody TSysAccount tSysAccount);



    /**
    *
     * @Author  zcj
     * @Description 验证用户账号是否存在
     * @Date 10:11 2019/8/9
     * @Param [tSysAccount]
     * @return void
     **/
    @PostMapping("/account/verifyAccount")
    void findverifyAccount(@RequestBody TSysAccount tSysAccount);



    /**
    *
     * @Author  zcj
     * @Description 修改密码
     * @Date 10:12 2019/8/9
     * @Param [tSysAccount]
     * @return void
     **/
    @PutMapping("/account/updatePW/{id}")
    void updatePW(@PathVariable(value = "id") String id,@RequestBody TSysAccount tSysAccount);


    /**
    *
     * @Author  zcj
     * @Description 查询启用的用户
     * @Date 10:12 2019/8/9
     * @Param [projectId]
     * @return java.util.List<com.zdzc.model.TSysAccount>
     **/
    @GetMapping("/account/ableUserList")
    List<TSysAccount> list(@RequestParam("projectId") String projectId,@RequestParam("uuid") String uuid);


}
