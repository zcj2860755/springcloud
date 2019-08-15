package com.zdzc.service;

import com.zdzc.common.PageList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.zdzc.model.TManagerArea;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;


/**
 * Author : 李琳青
 * Date : 2019-08-13 17:48
 */
@FeignClient(value = "manager-service")
public interface FeignTManagerAreaService {

    @PostMapping("/manager/area")
    int add(@RequestBody TManagerArea tManagerArea);

    @DeleteMapping("/manager/area")
    int delete(@RequestParam("id") String id);

    @PutMapping("/manager/area")
    int update(@RequestBody TManagerArea tManagerArea);

    @GetMapping("/manager/area/findById")
    TManagerArea findById(@RequestParam("id") String id);

    @PostMapping("/manager/area/pageList")
    List<TManagerArea> pageList();


}
