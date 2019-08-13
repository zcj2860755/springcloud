package com.zdzc.controller;

import com.zdzc.common.BaseRequest;
import com.zdzc.model.TManagerUnit;
import com.zdzc.service.ITManagerUnitService;
import org.springframework.web.bind.annotation.*;
import com.zdzc.common.PageList;

import javax.annotation.Resource;


/**
 * Description : 单位管理API接口
 * Author : 李琳青
 * Date : 2019-08-13 16:18
 */
@RestController
@RequestMapping("/manager/unit")
public class TManagerUnitController {
    @Resource
    private ITManagerUnitService tManagerUnitService;

    @PostMapping
    public int add(@RequestBody TManagerUnit tManagerUnit){
        return tManagerUnitService.save(tManagerUnit);
    }

    @DeleteMapping
    public int delete(@RequestParam("id") String id){
       return tManagerUnitService.deleteById(id);
    }

    @PutMapping
    public int update(@RequestBody TManagerUnit tManagerUnit){
       return tManagerUnitService.update(tManagerUnit);
    }

    @GetMapping("/findById")
    public TManagerUnit detail(@RequestParam("id") String id){
        return tManagerUnitService.findById(id);
    }

    @PostMapping("/pageList")
    public PageList<TManagerUnit> pageList(@RequestBody TManagerUnit tManagerUnit,BaseRequest baseRequest) {
        return tManagerUnitService.pageList(tManagerUnit,baseRequest);
    }
}
