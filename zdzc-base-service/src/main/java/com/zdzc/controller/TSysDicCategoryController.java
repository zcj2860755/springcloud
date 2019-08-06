package com.zdzc.controller;

import com.zdzc.common.BaseRequest;
import com.zdzc.model.TSysDicCategory;
import com.zdzc.service.ITSysDicCategoryService;
import org.springframework.web.bind.annotation.*;
import com.zdzc.common.PageList;

import javax.annotation.Resource;


/**
 * Author : 李琳青
 * Date : 2019-08-06 19:08
 */
@RestController
@RequestMapping("/t/sys/dic/category")
public class TSysDicCategoryController {
    @Resource
    private ITSysDicCategoryService tSysDicCategoryService;

    @PostMapping
    public void add(@RequestBody TSysDicCategory tSysDicCategory){
        tSysDicCategoryService.save(tSysDicCategory);
    }

    @DeleteMapping
    public void delete(@RequestParam String Id){
        tSysDicCategoryService.deleteById(Id);
    }

    @PutMapping
    public void update(@RequestBody TSysDicCategory tSysDicCategory){
        tSysDicCategoryService.update(tSysDicCategory);
    }

    @GetMapping("findById")
    public TSysDicCategory detail(@RequestParam String Id){
        return tSysDicCategoryService.findById(Id);
    }

    @GetMapping
    public PageList<TSysDicCategory> list(@RequestBody TSysDicCategory tSysDicCategory,BaseRequest baseRequest) {
        return tSysDicCategoryService.list(tSysDicCategory,baseRequest);
    }
}
