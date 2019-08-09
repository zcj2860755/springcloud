package com.zdzc.service;

import com.zdzc.common.PageList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.zdzc.model.TSysArea;

import java.util.List;


/**
 * Author : 李琳青
 * Date : 2019-08-07 19:16
 */
@FeignClient(value = "basic-service")
public interface FeignTSysAreaService {

    @PostMapping("/area")
    int add(@RequestBody TSysArea tSysArea);

    @DeleteMapping("/area")
    int delete(@RequestParam("id") String id);

    @PutMapping("/area")
    int update(@RequestBody TSysArea tSysArea);

    @GetMapping("/area/findById")
    TSysArea findById(@RequestParam("id") String id);

    @GetMapping("/area/pageList")
    PageList<TSysArea> list(@RequestBody TSysArea tSysArea);


    @PostMapping("/area/selectAreaList")
    List<TSysArea> selectAreaList(@RequestParam("cityId") Integer cityId);


}
