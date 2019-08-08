package com.zdzc.service;

import com.zdzc.common.PageList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.zdzc.model.TSysArea;


/**
 * Author : 李琳青
 * Date : 2019-08-07 19:16
 */
@FeignClient(value = "basic-service")
public interface FeignTSysAreaService {

    @PostMapping("/t/sys/area")
    int add(@RequestBody TSysArea tSysArea);

    @DeleteMapping("/t/sys/area")
    int delete(@RequestParam("id") String id);

    @PutMapping("/t/sys/area")
    int update(@RequestBody TSysArea tSysArea);

    @GetMapping("/t/sys/area/findById")
    TSysArea findById(@RequestParam("id") String id);

    @GetMapping("/t/sys/area")
    PageList<TSysArea> list(@RequestBody TSysArea tSysArea);


}
