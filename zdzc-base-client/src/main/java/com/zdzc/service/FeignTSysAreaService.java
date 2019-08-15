package com.zdzc.service;

import com.zdzc.common.PageList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.zdzc.model.TSysArea;

import java.util.List;


/**
 * Author : 李琳青
 * Date : 2019-08-09 11:06
 */
@FeignClient(value = "basic-service")
public interface FeignTSysAreaService {

    @PostMapping("/area")
    int add(@RequestBody TSysArea tSysArea);

    @DeleteMapping("/area")
    int delete(@RequestParam("id") String id);

    @PutMapping("/area")
    int update(@RequestBody TSysArea tSysArea);

    @PostMapping("/area/selectProvinceCityAreaList")
    List<TSysArea> selectProvinceCityAreaList(@RequestBody TSysArea tSysArea);



}
