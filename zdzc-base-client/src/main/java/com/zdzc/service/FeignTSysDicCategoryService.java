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

    @PostMapping("/dic/category")
    int add(@RequestBody TSysDicCategory tSysDicCategory);

    @DeleteMapping("/dic/category")
    int delete(@RequestParam("id") String id);

    @PutMapping("/dic/category")
    int update(@RequestBody TSysDicCategory tSysDicCategory);

    @GetMapping("/dic/category/findById")
    TSysDicCategory findById(@RequestParam("id") String id);

    @PostMapping("/dic/category/pageList")
    PageList<TSysDicCategory> pageList(@RequestBody TSysDicCategory tSysDicCategory,@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize);

}
