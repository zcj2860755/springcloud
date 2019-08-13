package com.zdzc.controller;

import com.zdzc.common.BaseRequest;
import com.zdzc.model.PlaceInfo;
import com.zdzc.service.IPlaceInfoService;
import org.springframework.web.bind.annotation.*;
import com.zdzc.common.PageList;

import javax.annotation.Resource;


/**
 * Description :
 * Author : 李琳青
 * Date : 2019-08-12 19:47
 */
@RestController
@RequestMapping("/place/info")
public class PlaceInfoController {
    @Resource
    private IPlaceInfoService placeInfoService;

    @PostMapping
    public int add(@RequestBody PlaceInfo placeInfo){
        return placeInfoService.save(placeInfo);
    }

    @DeleteMapping
    public int delete(@RequestParam("id") String id){
       return placeInfoService.deleteById(id);
    }

    @PutMapping
    public int update(@RequestBody PlaceInfo placeInfo){
       return placeInfoService.update(placeInfo);
    }

    @PutMapping("/updateFreezeStatus")
    public int updateFreezeStatus(@RequestParam("id") Integer id){
       return placeInfoService.updateFreezeStatus(id);
    }

    @GetMapping("/findById")
    public PlaceInfo detail(@RequestParam("id") String id){
        return placeInfoService.findById(id);
    }

    @PostMapping("/pageList")
    public PageList<PlaceInfo> pageList(@RequestBody PlaceInfo placeInfo,BaseRequest baseRequest) {
        return placeInfoService.pageList(placeInfo,baseRequest);
    }
}
