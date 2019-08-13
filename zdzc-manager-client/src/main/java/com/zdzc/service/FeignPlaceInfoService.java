package com.zdzc.service;

import com.zdzc.common.PageList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.zdzc.model.PlaceInfo;


/**
 * Author : 李琳青
 * Date : 2019-08-12 19:47
 */
@FeignClient(value = "manager-service")
public interface FeignPlaceInfoService {

    @PostMapping("/place/info")
    int add(@RequestBody PlaceInfo placeInfo);

    @DeleteMapping("/place/info")
    int delete(@RequestParam("id") String id);

    @PutMapping("/place/info")
    int update(@RequestBody PlaceInfo placeInfo);

    @PutMapping("/place/info/updateFreezeStatus")
    int updateFreezeStatus(@RequestParam("id") Integer id);

    @GetMapping("/place/info/findById")
    PlaceInfo findById(@RequestParam("id") String id);

    @PostMapping("/place/info/pageList")
    PageList<PlaceInfo> pageList(@RequestBody PlaceInfo placeInfo);


}
