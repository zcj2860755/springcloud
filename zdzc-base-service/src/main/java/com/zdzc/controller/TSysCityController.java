package com.zdzc.controller;

import com.zdzc.common.BaseRequest;
import com.zdzc.model.TSysCity;
import com.zdzc.service.ITSysCityService;
import org.springframework.web.bind.annotation.*;
import com.zdzc.common.PageList;

import javax.annotation.Resource;


/**
 * Author : 李琳青
 * Date : 2019-08-07 18:42
 */
@RestController
@RequestMapping("/t/sys/city")
public class TSysCityController {
    @Resource
    private ITSysCityService tSysCityService;

    @PostMapping
    public int add(@RequestBody TSysCity tSysCity){
        return tSysCityService.save(tSysCity);
    }

    @DeleteMapping
    public int delete(@RequestParam String Id){
       return tSysCityService.deleteById(Id);
    }

    @PutMapping
    public int update(@RequestBody TSysCity tSysCity){
       return tSysCityService.update(tSysCity);
    }

    @GetMapping("/findById")
    public TSysCity detail(@RequestParam("id") String id){
        return tSysCityService.findById(id);
    }

    @GetMapping
    public PageList<TSysCity> list(@RequestBody TSysCity tSysCity,BaseRequest baseRequest) {
        return tSysCityService.list(tSysCity,baseRequest);
    }
}
