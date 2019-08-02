package com.zdzc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin2.server.internal.EnableZipkinServer;

@EnableDiscoveryClient
@EnableZipkinServer
@SpringBootApplication( exclude = {DataSourceAutoConfiguration.class})
public class ZipkinApplication{
    private static Logger logger = LoggerFactory.getLogger(ZipkinApplication.class);

    public static void main( String[] args )
    {
        SpringApplication.run(ZipkinApplication.class,args);
    }


}
