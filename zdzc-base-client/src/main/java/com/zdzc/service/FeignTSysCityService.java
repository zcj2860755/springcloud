package com.zdzc.service;

import com.zdzc.common.PageList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.zdzc.model.TSysCity;

import java.util.List;


/**
 * Author : 李琳青
 * Date : 2019-08-07 18:42
 */
@FeignClient(value = "basic-service")
public interface FeignTSysCityService {

    @PostMapping("/t/sys/city")
    int add(@RequestBody TSysCity tSysCity);

    @DeleteMapping("/t/sys/city")
    int delete(@RequestParam("id") String id);

    @PutMapping("/t/sys/city")
    int update(@RequestBody TSysCity tSysCity);

    @GetMapping("/t/sys/city/findById")
    TSysCity findById(@RequestParam("id") String id);

    @GetMapping("/t/sys/city")
    PageList<TSysCity> list(@RequestBody TSysCity tSysCity);

    @GetMapping("/t/sys/province/selectCityList")
    List<TSysCity> selectCityList(Integer provinceId);

}
