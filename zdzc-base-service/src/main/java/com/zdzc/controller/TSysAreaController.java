package com.zdzc.controller;

import com.zdzc.common.BaseRequest;
import com.zdzc.model.TSysArea;
import com.zdzc.service.ITSysAreaService;
import org.springframework.web.bind.annotation.*;
import com.zdzc.common.PageList;

import javax.annotation.Resource;


/**
 * Author : 李琳青
 * Date : 2019-08-07 19:16
 */
@RestController
@RequestMapping("/t/sys/area")
public class TSysAreaController {
    @Resource
    private ITSysAreaService tSysAreaService;

    @PostMapping
    public int add(@RequestBody TSysArea tSysArea){
        return tSysAreaService.save(tSysArea);
    }

    @DeleteMapping
    public int delete(@RequestParam String Id){
       return tSysAreaService.deleteById(Id);
    }

    @PutMapping
    public int update(@RequestBody TSysArea tSysArea){
       return tSysAreaService.update(tSysArea);
    }

    @GetMapping("/findById")
    public TSysArea detail(@RequestParam("id") String id){
        return tSysAreaService.findById(id);
    }

    @GetMapping
    public PageList<TSysArea> list(@RequestBody TSysArea tSysArea,BaseRequest baseRequest) {
        return tSysAreaService.list(tSysArea,baseRequest);
    }
}
