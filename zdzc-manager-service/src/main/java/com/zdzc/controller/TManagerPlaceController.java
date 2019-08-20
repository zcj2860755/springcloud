package com.zdzc.controller;

import com.zdzc.common.BaseRequest;
import com.zdzc.model.TManagerPlace;
import com.zdzc.service.ITManagerPlaceService;
import org.springframework.web.bind.annotation.*;
import com.zdzc.common.PageList;

import javax.annotation.Resource;


/**
 * Description : 场所管理API接口
 * Author : 李琳青
 * Date : 2019-08-13 16:17
 */
@RestController
@RequestMapping("/manager/place")
public class TManagerPlaceController {
    @Resource
    private ITManagerPlaceService tManagerPlaceService;

    @PostMapping
    public int add(@RequestBody TManagerPlace tManagerPlace){
        return tManagerPlaceService.save(tManagerPlace);
    }

    @DeleteMapping
    public int delete(@RequestParam("id") String id){
       return tManagerPlaceService.deleteById(id);
    }

    @PutMapping
    public int update(@RequestBody TManagerPlace tManagerPlace){
       return tManagerPlaceService.update(tManagerPlace);
    }

    @PutMapping("/updateFreezeStatus")
    public int updateFreezeStatus(@RequestParam("id") Integer id){
        return tManagerPlaceService.updateFreezeStatus(id);
    }

    @GetMapping("/findById")
    public TManagerPlace detail(@RequestParam("id") String id){
        return tManagerPlaceService.findById(id);
    }

    @PostMapping("/pageList")
    public PageList<TManagerPlace> pageList(@RequestBody TManagerPlace tManagerPlace,@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize) {
        return tManagerPlaceService.pageList(tManagerPlace,pageNo,pageSize);
    }
}
