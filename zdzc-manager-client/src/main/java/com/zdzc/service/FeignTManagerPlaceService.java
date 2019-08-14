package com.zdzc.service;

import com.zdzc.common.PageList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.zdzc.model.TManagerPlace;


/**
 * Author : 李琳青
 * Date : 2019-08-13 16:17
 */
@FeignClient(value = "manager-service")
public interface FeignTManagerPlaceService {

    @PostMapping("/manager/place")
    int add(@RequestBody TManagerPlace tManagerPlace);

    @DeleteMapping("/manager/place")
    int delete(@RequestParam("id") String id);

    @PutMapping("/manager/place")
    int update(@RequestBody TManagerPlace tManagerPlace);

    @PutMapping("manager/place/updateFreezeStatus")
    int updateFreezeStatus(@RequestParam("id") Integer id);

    @GetMapping("/manager/place/findById")
    TManagerPlace findById(@RequestParam("id") String id);

    @PostMapping("/manager/place/pageList")
    PageList<TManagerPlace> pageList(@RequestBody TManagerPlace tManagerPlace);


}
