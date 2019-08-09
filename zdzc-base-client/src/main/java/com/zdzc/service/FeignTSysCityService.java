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

    @PostMapping("/city")
    int add(@RequestBody TSysCity tSysCity);

    @DeleteMapping("/city")
    int delete(@RequestParam("id") String id);

    @PutMapping("/city")
    int update(@RequestBody TSysCity tSysCity);

    @GetMapping("/city/findById")
    TSysCity findById(@RequestParam("id") String id);

    @GetMapping("/city")
    PageList<TSysCity> list(@RequestBody TSysCity tSysCity);

    @PostMapping("/city/selectCityList")  //掉不通到service 就是少注解  报错405
    List<TSysCity> selectCityList(@RequestParam("provinceId") Integer provinceId);

}
