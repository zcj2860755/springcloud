package com.zdzc.controller;

import com.zdzc.enums.ExceptionEnum;
import com.zdzc.model.TManagerPlace;
import com.zdzc.model.TSysDicCategory;
import com.zdzc.service.FeignTManagerPlaceService;
import com.zdzc.utils.BaseException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;
import com.zdzc.common.PageList;

/**
 * Description : 场所管理API接口
 * Author : 李琳青
 * Date : 2019-08-13 16:17
 */
@RestController
@RequestMapping("/manager/place")
@Api(description = "场所管理API接口")
public class TManagerPlaceController {
    @Resource
    private FeignTManagerPlaceService feigntManagerPlaceService;

    @PostMapping
    @ApiOperation("新增")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "场所名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "type", value = "场所性质", required = true, paramType = "query"),
            @ApiImplicitParam(name = "address", value = "场所地址", required = true, paramType = "query"),
            @ApiImplicitParam(name = "areaId", value = "所属区域", required = true, paramType = "query"),
            @ApiImplicitParam(name = "unitId", value = "所属单位", required = true, paramType = "query"),
            @ApiImplicitParam(name = "areaSize", value = "场所面积", required = true, paramType = "query"),
            @ApiImplicitParam(name = "manager", value = "负责人id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "managerTelephone", value = "负责人电话", required = true, paramType = "query"),
            @ApiImplicitParam(name = "fireTelephone", value = "消防室电话", required = true, paramType = "query"),
            @ApiImplicitParam(name = "isMain", value = "是否独立主机 0.是 1.否", required = true, paramType = "query"),
            @ApiImplicitParam(name = "lon", value = "场所坐标-lon经度", required = true, paramType = "query"),
            @ApiImplicitParam(name = "lat", value = "场所坐标-lat纬度", required = true, paramType = "query"),
            @ApiImplicitParam(name = "adminAreaId", value = "adminAreaId", required = true, paramType = "query"),
            @ApiImplicitParam(name = "createUser", value = "创建者", required = false, paramType = "query"),
    })
    public int add(@ApiIgnore TManagerPlace tManagerPlace){
        checkParams(tManagerPlace);
        return feigntManagerPlaceService.add(tManagerPlace);
    }


    @DeleteMapping
    @ApiOperation("删除")  //场所下有设备不允许删除？？
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query")
    })
    public int delete(String id){
        if(StringUtils.isEmpty(id)){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSID_NULL);
        }
        return feigntManagerPlaceService.delete(id);
    }

    @PutMapping
    @ApiOperation("更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "name", value = "场所名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "type", value = "场所性质", required = true, paramType = "query"),
            @ApiImplicitParam(name = "address", value = "场所地址", required = true, paramType = "query"),
            @ApiImplicitParam(name = "areaId", value = "所属区域", required = true, paramType = "query"),
            @ApiImplicitParam(name = "unitId", value = "所属单位", required = true, paramType = "query"),
            @ApiImplicitParam(name = "areaSize", value = "场所面积", required = true, paramType = "query"),
            @ApiImplicitParam(name = "manager", value = "负责人id", required = true, paramType = "query"),
            @ApiImplicitParam(name = "managerTelephone", value = "负责人电话", required = true, paramType = "query"),
            @ApiImplicitParam(name = "fireTelephone", value = "消防室电话", required = true, paramType = "query"),
            @ApiImplicitParam(name = "isMain", value = "是否独立主机 0.是 1.否", required = true, paramType = "query"),
            @ApiImplicitParam(name = "lon", value = "场所坐标-lon经度", required = true, paramType = "query"),
            @ApiImplicitParam(name = "lat", value = "场所坐标-lat纬度", required = true, paramType = "query"),
            @ApiImplicitParam(name = "adminAreaId", value = "adminAreaId", required = true, paramType = "query"),
            @ApiImplicitParam(name = "updateUser", value = "编辑者", required = false, paramType = "query"),
    })
    public int update(@ApiIgnore TManagerPlace tManagerPlace){
        if(StringUtils.isEmpty(tManagerPlace.getId())){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSID_NULL);
        }
        checkParams(tManagerPlace);
        return feigntManagerPlaceService.update(tManagerPlace);
    }

    @GetMapping("/findById")
    @ApiOperation("获取详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query")
    })
    public TManagerPlace detail(String id){
        if(StringUtils.isEmpty(id)){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSID_NULL);
        }
        return feigntManagerPlaceService.findById(id);
    }

    @PutMapping("/updateFreezeStatus")
    @ApiOperation("冻结/解冻")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键id", required = true, paramType = "query"),
    })
    public int updateFreezeStatus(@ApiIgnore Integer id){
        if(StringUtils.isEmpty(id)){
            throw new BaseException(ExceptionEnum.SYSTEM_PARAMSID_NULL);
        }
        return feigntManagerPlaceService.updateFreezeStatus(id);
    }


    @PostMapping("/pageList")
    @ApiOperation("分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNo", value = "页数，默认1", required = false, paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页展示，默认10，传0查全部", required = false, paramType = "query"),
            @ApiImplicitParam(name = "keyWords", value = "查询内容", required = false, paramType = "query"),
            @ApiImplicitParam(name = "mark", value = "0.查询所有 1.场所编号 2.场所名称", required = true, paramType = "query"),
            @ApiImplicitParam(name = "type", value = "场所性质", required = false, paramType = "query"),
            @ApiImplicitParam(name = "unitId", value = "所属单位", required = false, paramType = "query"),
    })
    public PageList<TManagerPlace> pageList(@ApiIgnore TManagerPlace tManagerPlace,@RequestParam(value="pageNo",defaultValue="1") Integer pageNo,@RequestParam(value="pageSize",defaultValue="10") Integer pageSize) {
        if(StringUtils.isEmpty(tManagerPlace.getMark())){
            throw new BaseException(ExceptionEnum.PARAM_IS_NOT_NULL);
        }
        return feigntManagerPlaceService.pageList(tManagerPlace,pageNo,pageSize);
    }



    /**
     * @Description : 参数校验
     */
    public void checkParams(TManagerPlace tManagerPlace){
        if(StringUtils.isEmpty(tManagerPlace.getName())){
            throw new BaseException(ExceptionEnum.PLACE_NAME_NULL);
        }
        if(StringUtils.isEmpty(tManagerPlace.getType())){
            throw new BaseException(ExceptionEnum.PLACE_TYPE_NULL);
        }
        if(StringUtils.isEmpty(tManagerPlace.getAddress())){
            throw new BaseException(ExceptionEnum.PLACE_ADDRESS_NULL);
        }
        if(StringUtils.isEmpty(tManagerPlace.getAreaId())){
            throw new BaseException(ExceptionEnum.PLACE_OF_AREA_NULL);
        }
        if(StringUtils.isEmpty(tManagerPlace.getUnitId())){
            throw new BaseException(ExceptionEnum.PLACE_UNIT_NULL);
        }
        if(StringUtils.isEmpty(tManagerPlace.getAreaSize())){
            throw new BaseException(ExceptionEnum.PLACE_MM_NULL);
        }
        if(StringUtils.isEmpty(tManagerPlace.getManager())){
            throw new BaseException(ExceptionEnum.MANAGER_NULL);
        }
        if(StringUtils.isEmpty(tManagerPlace.getManagerTelephone())){
            throw new BaseException(ExceptionEnum.MANAGER_TEL_NULL);
        }
        if(StringUtils.isEmpty(tManagerPlace.getFireTelephone())){
            throw new BaseException(ExceptionEnum.FIRE_TEL_NULL);
        }
        if(StringUtils.isEmpty(tManagerPlace.getIsMain())){
            throw new BaseException(ExceptionEnum.IS_MAIN_NULL);
        }
        if(StringUtils.isEmpty(tManagerPlace.getLon())){
            throw new BaseException(ExceptionEnum.PLACE_LON_NULL);
        }
        if(StringUtils.isEmpty(tManagerPlace.getLat())){
            throw new BaseException(ExceptionEnum.PLACE_LAT_NULL);
        }
        if(StringUtils.isEmpty(tManagerPlace.getAdminAreaId())){
            throw new BaseException(ExceptionEnum.ADMIN_AREA_ID_MULL);
        }
    }




}
