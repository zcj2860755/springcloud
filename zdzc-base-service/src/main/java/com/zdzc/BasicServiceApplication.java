package com.zdzc;


import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.zdzc.dao")
public class BasicServiceApplication{

    public static void main(String[] args) {
        SpringApplication.run(BasicServiceApplication.class, args);
    }

}
