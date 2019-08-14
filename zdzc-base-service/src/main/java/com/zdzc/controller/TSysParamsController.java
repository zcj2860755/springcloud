package com.zdzc.controller;

import com.zdzc.common.BaseRequest;
import com.zdzc.enums.ExceptionEnum;
import com.zdzc.model.TSysParams;
import com.zdzc.service.ITSysParamsService;
import com.zdzc.utils.BaseException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.zdzc.common.PageList;

import javax.annotation.Resource;


/**
 * Description :
 * Author : zhuqilong
 * Date : 2019-08-13 14:02
 */
@RestController
@RequestMapping("/sys/params")
public class TSysParamsController {
    @Resource
    private ITSysParamsService tSysParamsService;

    @PostMapping("/add")
    public int add(@RequestBody TSysParams tSysParams){
        checkParams(tSysParams);
        return tSysParamsService.save(tSysParams);
    }

    /**
     * @Author  zhuqilong
     * @Description 系统参数参数校验
     * @Date 14:25 2019/8/13
     * @Param
     * @return
     */
    public void checkParams(TSysParams tSysParams){
        if(StringUtils.isEmpty(tSysParams.getParamsValue())){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSVALUE_NULL);
        }

        if(StringUtils.isEmpty(tSysParams.getParamsName())){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSNAME_NULL);
        }

        if(StringUtils.isEmpty(tSysParams.getParamsKey())){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSKEY_NULL);
        }
    }

    @DeleteMapping
    public int delete(@RequestParam("id") String id){
        if(StringUtils.isEmpty(id)){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSID_NULL);
        }
       return tSysParamsService.deleteById(id);
    }

    @PutMapping
    public int update(@RequestBody TSysParams tSysParams){
       checkParams(tSysParams);
        if(StringUtils.isEmpty(tSysParams.getId())){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSID_NULL);
        }
       return tSysParamsService.update(tSysParams);
    }

    @GetMapping("/findById")
    public TSysParams detail(@RequestParam("id") String id){
        if(StringUtils.isEmpty(id)){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSID_NULL);
        }
        return tSysParamsService.findById(id);
    }

    @PostMapping("/pageList")
    public PageList<TSysParams> pageList(@RequestBody TSysParams tSysParams,
        @RequestParam(value="pageNo",defaultValue="1") Integer pageNo,@RequestParam(value="pageSize",defaultValue="10") Integer pageSize) {
        return tSysParamsService.pageList(tSysParams,pageNo,pageSize);
    }
}
