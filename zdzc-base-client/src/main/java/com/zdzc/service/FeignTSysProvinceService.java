package com.zdzc.service;

import com.zdzc.common.PageList;
import com.zdzc.model.TSysArea;
import com.zdzc.model.TSysCity;
import io.swagger.models.auth.In;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.zdzc.model.TSysProvince;

import java.util.List;


/**
 * Author : 李琳青
 * Date : 2019-08-07 16:42
 */
@FeignClient(value = "basic-service")
public interface FeignTSysProvinceService {

    @PostMapping("/t/sys/province")
    int add(@RequestBody TSysProvince tSysProvince);

    @DeleteMapping("/t/sys/province")
    int delete(@RequestParam("id") String id);

    @PutMapping("/t/sys/province")
    int update(@RequestBody TSysProvince tSysProvince);

    @GetMapping("/t/sys/province/findById")
    TSysProvince findById(@RequestParam("id") String id);

   /* @GetMapping("/t/sys/province")
    PageList<TSysProvince> list(@RequestBody TSysProvince tSysProvince);
*/

    @GetMapping("/t/sys/province/selectProvinceList")
    List<TSysProvince> provinceList();

    @GetMapping("/t/sys/province/selectCityList")  //掉不通到service 就是少注解  报错405
    List<TSysCity> selectCityList(@RequestParam("provinceId") Integer provinceId);

    @GetMapping("/t/sys/province/selectAreaList")  //selectAreaList 跟service不一样 就是名称不一致 报500
    List<TSysArea> selectAreaList(@RequestParam("cityId") Integer cityId);




}
