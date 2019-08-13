package com.zdzc.controller;

import com.zdzc.common.BaseRequest;
import com.zdzc.model.UnitInfo;
import com.zdzc.service.IUnitInfoService;
import org.springframework.web.bind.annotation.*;
import com.zdzc.common.PageList;

import javax.annotation.Resource;


/**
 * Description :
 * Author : 李琳青
 * Date : 2019-08-13 10:21
 */
@RestController
@RequestMapping("/unit/info")
public class UnitInfoController {
    @Resource
    private IUnitInfoService unitInfoService;

    @PostMapping
    public int add(@RequestBody UnitInfo unitInfo){
        return unitInfoService.save(unitInfo);
    }

    @DeleteMapping
    public int delete(@RequestParam("id") String id){
       return unitInfoService.deleteById(id);
    }

    @PutMapping
    public int update(@RequestBody UnitInfo unitInfo){
       return unitInfoService.update(unitInfo);
    }

    @GetMapping("/findById")
    public UnitInfo detail(@RequestParam("id") String id){
        return unitInfoService.findById(id);
    }

    @PostMapping("/pageList")
    public PageList<UnitInfo> pageList(@RequestBody UnitInfo unitInfo,BaseRequest baseRequest) {
        return unitInfoService.pageList(unitInfo,baseRequest);
    }
}
