package com.zdzc.controller;

import com.zdzc.common.BaseRequest;
import com.zdzc.model.TSysParams;
import com.zdzc.service.ITSysParamsService;
import org.springframework.web.bind.annotation.*;
import com.zdzc.common.PageList;

import javax.annotation.Resource;


/**
 * Description :
 * Author : zhuqilong
 * Date : 2019-08-13 14:02
 */
@RestController
@RequestMapping("/sys/params")
public class TSysParamsController {
    @Resource
    private ITSysParamsService tSysParamsService;

    @PostMapping("/add")
    public int add(@RequestBody TSysParams tSysParams){
        return tSysParamsService.save(tSysParams);
    }

    @DeleteMapping
    public int delete(@RequestParam("id") String id){
       return tSysParamsService.deleteById(id);
    }

    @PutMapping
    public int update(@RequestBody TSysParams tSysParams){
       return tSysParamsService.update(tSysParams);
    }

    @GetMapping("/findById")
    public TSysParams detail(@RequestParam("id") String id){
        return tSysParamsService.findById(id);
    }

    @PostMapping("/pageList")
    public PageList<TSysParams> pageList(@RequestBody TSysParams tSysParams,
        @RequestParam(value="pageNo",defaultValue="1") Integer pageNo,@RequestParam(value="pageSize",defaultValue="10") Integer pageSize) {
        return tSysParamsService.pageList(tSysParams,pageNo,pageSize);
    }
}
