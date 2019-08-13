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

    @PostMapping("/sys/params/add")
    int add(@RequestBody TSysParams tSysParams);

    @DeleteMapping("/sys/params")
    int delete(@RequestParam("id") String id);

    @PutMapping("/sys/params")
    int update(@RequestBody TSysParams tSysParams);

    @GetMapping("/sys/params/findById")
    TSysParams findById(@RequestParam("id") String id);

    @PostMapping("/sys/params/pageList")
    PageList<TSysParams> pageList(@RequestBody TSysParams tSysParams,
        @RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize);


}
