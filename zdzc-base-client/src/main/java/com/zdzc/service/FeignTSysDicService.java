package com.zdzc.service;

import com.zdzc.common.PageList;
import com.zdzc.model.TSysDic;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Author : 李琳青
 * Date : 2019-08-06 13:41
 */
@FeignClient(value = "base-service")
public interface FeignTSysDicService {

    @PostMapping("/dic")
    int add(@RequestBody TSysDic tSysDic);

    @DeleteMapping("/dic")
    int delete(@RequestParam("id") String id);

    @PutMapping("/dic")
    int update(@RequestBody TSysDic tSysDic);

    @GetMapping("/dic/findById")
    TSysDic findById(@RequestParam("id") String id);

    @PostMapping("/dic/pageList")
    PageList<TSysDic> pageList(@RequestBody TSysDic tSysDic,@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize);

    /**
     * @Author  zhuqilong
     * @Description 通过父类key查询字典小磊
     * @Date 15:44 2019/8/21
     * @Param
     * @return
    */
    @GetMapping("/dic/getDicByDicKey")
    List<TSysDic> getDicByDicKey(@RequestParam("dicKey") String dicKey);

}
