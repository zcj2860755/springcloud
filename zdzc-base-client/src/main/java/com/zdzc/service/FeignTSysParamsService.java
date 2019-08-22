package com.zdzc.service;

import com.zdzc.common.PageList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.zdzc.model.TSysParams;


/**
 * Author : zhuqilong
 * Date : 2019-08-13 14:02
 */
@FeignClient(value = "basic-service")
public interface FeignTSysParamsService {

    /**
     * @Author  zhuqilong
     * @Description 权限新增
     * @Date 15:43 2019/8/21
     * @Param
     * @return
    */
    @PostMapping("/sys/params/add")
    int add(@RequestBody TSysParams tSysParams);

    /**
     * @Author  zhuqilong
     * @Description 权限删除
     * @Date 15:43 2019/8/21
     * @Param
     * @return
    */
    @DeleteMapping("/sys/params")
    int delete(@RequestParam("id") String id);

    /**
     * @Author  zhuqilong
     * @Description 权限修改
     * @Date 15:43 2019/8/21
     * @Param
     * @return
    */
    @PutMapping("/sys/params")
    int update(@RequestBody TSysParams tSysParams);

    /**
     * @Author  zhuqilong
     * @Description 权限获取详情
     * @Date 15:43 2019/8/21
     * @Param
     * @return
    */
    @GetMapping("/sys/params/findById")
    TSysParams findById(@RequestParam("id") String id);

    /**
     * @Author  zhuqilong
     * @Description 分页查询
     * @Date 15:43 2019/8/21
     * @Param
     * @return
    */
    @PostMapping("/sys/params/pageList")
    PageList<TSysParams> pageList(@RequestBody TSysParams tSysParams,
        @RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize);


}
