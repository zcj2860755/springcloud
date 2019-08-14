package com.zdzc.service;

import com.zdzc.common.PageList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.zdzc.model.TManagerUnit;


/**
 * Author : 李琳青
 * Date : 2019-08-13 16:18
 */
@FeignClient(value = "manager-service")
public interface FeignTManagerUnitService {

    @PostMapping("/manager/unit")
    int add(@RequestBody TManagerUnit tManagerUnit);

    @DeleteMapping("/manager/unit")
    int delete(@RequestParam("id") String id);

    @PutMapping("/manager/unit")
    int update(@RequestBody TManagerUnit tManagerUnit);

    @GetMapping("/manager/unit/findById")
    TManagerUnit findById(@RequestParam("id") String id);

    @PostMapping("/manager/unit/pageList")
    PageList<TManagerUnit> pageList(@RequestBody TManagerUnit tManagerUnit);


}
