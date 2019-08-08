package com.zdzc.service;

import com.zdzc.common.PageList;
import com.zdzc.model.TSysDic;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


/**
 * Author : 李琳青
 * Date : 2019-08-06 13:41
 */
@FeignClient(value = "basic-service")
public interface FeignTSysDicService {

    @PostMapping("/t/sys/dic")
    int add(@RequestBody TSysDic tSysDic);

    @DeleteMapping("/t/sys/dic")
    int delete(@RequestParam("id") String id);

    @PutMapping("/t/sys/dic")
    int update(@RequestBody TSysDic tSysDic);

    @GetMapping("/t/sys/dic/findById")
    TSysDic findById(@RequestParam("id") String id);

    @PostMapping("/t/sys/dic/pageList")
    PageList<TSysDic> pageList(@RequestBody TSysDic tSysDic);

}
