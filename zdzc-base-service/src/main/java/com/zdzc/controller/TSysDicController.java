package com.zdzc.controller;

import com.zdzc.common.PageList;
import com.zdzc.enums.ExceptionEnum;
import com.zdzc.model.TSysDic;
import com.zdzc.service.ITSysDicService;
import com.zdzc.utils.BaseException;
import com.zdzc.utils.oss.OSSUnit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;


/**
 * Author : 李琳青
 * Date : 2019-08-06 13:41
 */
@RestController
@RequestMapping("/dic")
@Api(description="数据字典接口API")
public class TSysDicController {
    @Resource
    private ITSysDicService tSysDicService;

    @PostMapping
    @ApiOperation("新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "categoryId", value = "类别id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "dicKey", value = "字典编码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "dicValue", value = "字典名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "isEnable", value = "是否启用(0-关闭 1-启用)", required = true, paramType = "query"),
            @ApiImplicitParam(name = "sortNo", value = "排序", required = true, paramType = "query"),
            @ApiImplicitParam(name = "remark", value = "描述", required = true, paramType = "query"),
    })
    public int add(@RequestBody TSysDic tSysDic){
        if(StringUtils.isEmpty(tSysDic.getCategoryId())){
            throw new BaseException(ExceptionEnum.DIC_CATEGORY_NULL);
        }
        checkParams(tSysDic);
        return tSysDicService.insert(tSysDic);
    }

    /**
     * @Description : 参数校验
     */
    public void checkParams(TSysDic tSysDic){
        if(StringUtils.isEmpty(tSysDic.getDicKey())){
            throw new BaseException(ExceptionEnum.DIC_KEY_NULL);
        }
        if(StringUtils.isEmpty(tSysDic.getDicValue())){
            throw new BaseException(ExceptionEnum.DIC_VABLE_NULL);
        }
        if(StringUtils.isEmpty(tSysDic.getIsEnable())){
            throw new BaseException(ExceptionEnum.DIC_ENABLE_NULL);
        }
        if(StringUtils.isEmpty(tSysDic.getSortNo())){
            throw new BaseException(ExceptionEnum.DIC_SORT_NULL);
        }
    }


    @DeleteMapping
    @ApiOperation("删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query")
    })
    public int delete(@RequestParam("id") String id){
        if(StringUtils.isEmpty(id)){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSID_NULL);
        }
        return tSysDicService.delete(id);
    }

    @PutMapping
    @ApiOperation("更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "categoryId", value = "类别id", required = false, paramType = "query"),
            @ApiImplicitParam(name = "dicKey", value = "字典编码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "dicValue", value = "字典名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "isEnable", value = "是否启用(0-关闭 1-启用)", required = true, paramType = "query"),
            @ApiImplicitParam(name = "sortNo", value = "排序", required = true, paramType = "query"),
            @ApiImplicitParam(name = "remark", value = "描述", required = true, paramType = "query"),
    })
    public int update(@RequestBody TSysDic tSysDic){
        if(StringUtils.isEmpty(tSysDic.getId())){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSID_NULL);
        }
        checkParams(tSysDic);
        return tSysDicService.update(tSysDic);
    }


    @GetMapping("/findById")
    @ApiOperation("获取详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query")
    })
    public TSysDic detail(@RequestParam("id") String id){
        if(StringUtils.isEmpty(id)){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSID_NULL);
        }
        return tSysDicService.findById(id);
    }



    @PostMapping("/pageList")
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示", required = false, paramType = "query"),
            @ApiImplicitParam(name = "categoryId", value = "类别id", required = true, paramType = "query")
    })
    public PageList<TSysDic> pageList(@RequestBody TSysDic tSysDic, @RequestParam(value="pageNo",defaultValue="1") Integer pageNo, @RequestParam(value="pageSize",defaultValue="10") Integer pageSize) {
        if(StringUtils.isEmpty(tSysDic.getCategoryId())){
            throw new BaseException(ExceptionEnum.DIC_CATEGORY_NULL);
        }
        return tSysDicService.list(tSysDic,pageNo,pageSize);
    }


    @GetMapping("getDicByDicKey")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dicKey", value = "父类Key", required = false, paramType = "query")
    })
    public List<TSysDic> getDicByDicKey(@RequestParam String dicKey){
        if(StringUtils.isEmpty(dicKey)){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSKEY_NULL);
        }
        return tSysDicService.getDicByDicKey(dicKey);
    }


/*
    @PostMapping("/test")
    public int kkkk (@RequestBody MultipartFile image) {
        String imgName = "images";
        String OSS_FILE_DIR = "test";

        try {
            StringBuffer imgUrl = OSSUnit.getImgUrl(image, imgName, OSS_FILE_DIR);
            String toString = imgUrl.toString();
            System.out.println("图片路径为:"+toString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }*/




}
