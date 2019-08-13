package com.zdzc.service;

import com.zdzc.common.PageList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.zdzc.model.UnitInfo;


/**
 * Author : 李琳青
 * Date : 2019-08-13 10:21
 */
@FeignClient(value = "manager-service")
public interface FeignUnitInfoService {

    @PostMapping("/unit/info")
    int add(@RequestBody UnitInfo unitInfo);

    @DeleteMapping("/unit/info")
    int delete(@RequestParam("id") String id);

    @PutMapping("/unit/info")
    int update(@RequestBody UnitInfo unitInfo);

    @GetMapping("/unit/info/findById")
    UnitInfo findById(@RequestParam("id") String id);

    @PostMapping("/unit/info/pageList")
    PageList<UnitInfo> pageList(@RequestBody UnitInfo unitInfo);


}
