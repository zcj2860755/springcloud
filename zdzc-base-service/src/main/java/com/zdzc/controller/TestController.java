package com.zdzc.controller;

import com.zdzc.model.TSysDic;
import com.zdzc.service.ITSysDicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(description = "智慧消防API接口")
public class TestController {


  /*  @Resource
    private ITSysDicService sysDicService;

    @RequestMapping("/test")
    @ApiOperation("测试数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名称", required = true, paramType = "query")})
    public List<TSysDic> test(@RequestParam String name) {
        return sysDicService.findTest();
    }

    @RequestMapping("/add")
    @ApiOperation("测试数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名称", required = true, paramType = "query")})
    public int add(@RequestParam String name) {
        TSysDic dic = new TSysDic();
        dic.setCategoryId("39ea8d47fb944f239577a5a22d4385ee");
        dic.setId("39ea8d47fb944f239577a5a22d4385ef");
        dic.setDicKey("test");
        dic.setDicValue(12);
        dic.setIsEnable(0);
        dic.setSortNo(1);
        dic.setRemark("test");
        return sysDicService.add(dic);
    }
*/
}
