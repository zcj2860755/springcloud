package com.zdzc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "智慧消防生产者API接口")
public class ProducerController {


    @Value("${server.port}")
    String port;

    @RequestMapping("/hello")
    @ApiOperation("测试数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名称", required = true, paramType = "query")})
    public String hello(@RequestParam String name) {
        return "hello "+name+"，from "+ port+ " this is new world";
    }

    @RequestMapping("/hello2")
    @ApiOperation("测试数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "名称", required = true, paramType = "query")})
    public String hello2(@RequestParam String name) {
        return "hello2 "+name+"，from "+ port+ " this is 2 world";
    }

}
