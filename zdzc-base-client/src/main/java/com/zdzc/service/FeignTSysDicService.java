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

    @GetMapping("/t/sys/dic/findById")
    String findById();

    @PostMapping("/t/sys/dic")
    PageList<TSysDic> list(@RequestBody TSysDic tSysDic);

    @PostMapping("/t/sys/dic")
    String add(@RequestBody TSysDic tSysDic);  //去掉也行

    @DeleteMapping("/t/sys/dic")
    String delete(TSysDic tSysDic);

    @PutMapping("/t/sys/dic")
    String update(TSysDic tSysDic);
}
