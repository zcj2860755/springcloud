package com.zdzc.controller;

import com.zdzc.model.TSysParams;
import com.zdzc.service.FeignExampleService;
import com.zdzc.service.FeignTestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author  zcj
 * @Description //TODO
 * @Date 19:17 2019/7/30
 * @Param
 * @return
 **/
@RestController
@Api("智慧消防消费者API接口")
public class ConsumerController {

    @Value("${spring.application.name}")
    String applicationName;

    @Resource
    private FeignExampleService feignExampleService;

    @Resource
    private FeignTestService feignTestService;

    @GetMapping("/hello/{name}")
    @ApiOperation("测试数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名称", required = true, paramType = "query")})
    public String index(@PathVariable String name) {
        return feignExampleService.hello(name+", from "+applicationName);
    }

    @GetMapping("/hellotest/{name}")
    @ApiOperation("测试数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名称", required = true, paramType = "query")})
    public String index2(@PathVariable String name) {
        return feignTestService.hello2(name+", from "+applicationName);
    }


    @GetMapping("/test/{name}")
    @ApiOperation("测试数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名称", required = true, paramType = "query")})
    public String test(@PathVariable String name) {
        return feignTestService.test(name+", from "+applicationName);
    }



    @GetMapping("/test/body")
    public void test(TSysParams tSysParams){
        System.out.println(tSysParams.getId());
        System.out.println(tSysParams.getRemark());
    }

}
