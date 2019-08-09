package com.zdzc.controller;

import com.zdzc.common.BaseRequest;
import com.zdzc.model.TSysArea;
import com.zdzc.model.TSysCity;
import com.zdzc.model.TSysProvince;
import com.zdzc.service.ITSysProvinceService;
import org.springframework.web.bind.annotation.*;
import com.zdzc.common.PageList;

import javax.annotation.Resource;
import java.util.List;


/**
 * Author : 李琳青
 * Date : 2019-08-07 16:42
 */
@RestController
@RequestMapping("/t/sys/province")
public class TSysProvinceController {
    @Resource
    private ITSysProvinceService tSysProvinceService;

    @PostMapping
    public int add(@RequestBody TSysProvince tSysProvince){
        return tSysProvinceService.save(tSysProvince);
    }

    @DeleteMapping
    public int delete(@RequestParam String Id){
       return tSysProvinceService.deleteById(Id);
    }

    @PutMapping
    public int update(@RequestBody TSysProvince tSysProvince){
       return tSysProvinceService.update(tSysProvince);
    }

    @GetMapping("/findById")
    public TSysProvince detail(@RequestParam("id") String id){
        return tSysProvinceService.findById(id);
    }

    /*@GetMapping
    public PageList<TSysProvince> list(@RequestBody TSysProvince tSysProvince,BaseRequest baseRequest) {
        return tSysProvinceService.list(tSysProvince,baseRequest);
    }*/

    @PostMapping("/selectProvinceList")
    public List<TSysProvince> provinceList() {
        return tSysProvinceService.provinceList();
    }






}
