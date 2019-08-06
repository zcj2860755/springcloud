package com.zdzc.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@FeignClient(value = "basic-service")
public interface FeignExampleService {

    @GetMapping("hello")
    String hello(@RequestParam(value = "name") String name);


}
