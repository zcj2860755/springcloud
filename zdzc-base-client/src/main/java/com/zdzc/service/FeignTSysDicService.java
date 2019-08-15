package com.zdzc.service;

import com.zdzc.common.PageList;
import com.zdzc.model.TSysDic;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


/**
 * Author : 李琳青
 * Date : 2019-08-06 13:41
 */
@FeignClient(value = "basic-service")
public interface FeignTSysDicService {

    @PostMapping("/dic")
    int add(@RequestBody TSysDic tSysDic);

    @DeleteMapping("/dic")
    int delete(@RequestParam("id") String id);

    @PutMapping("/dic")
    int update(@RequestBody TSysDic tSysDic);

    @PostMapping("/dic/pageList")
    PageList<TSysDic> pageList(@RequestBody TSysDic tSysDic,@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize);

}
