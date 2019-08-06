package com.zdzc.service;

import com.zdzc.common.PageList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.zdzc.model.TSysDicCategory;


/**
 * Author : 李琳青
 * Date : 2019-08-06 19:08
 */
@FeignClient(value = "basic-service")
public interface FeignTSysDicCategoryService {

    @GetMapping("/t/sys/dic/category/findById")
    //TSysDicCategory findById(@RequestParam String Id);  //启动报错 java.lang.IllegalStateException: RequestParam.value() was empty on parameter 0
    TSysDicCategory findById(@RequestBody String Id);

    @GetMapping("/t/sys/dic/category")
    PageList<TSysDicCategory> list(@RequestBody TSysDicCategory tSysDicCategory);

    @PostMapping("/t/sys/dic/category")
    int add(@RequestBody TSysDicCategory tSysDicCategory);

    @DeleteMapping("/t/sys/dic/category")
    //int delete(@RequestParam String Id);
    int delete(@RequestBody String Id);

    @PutMapping("/t/sys/dic/category")
    int update(@RequestBody TSysDicCategory tSysDicCategory);
}
