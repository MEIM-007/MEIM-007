package com.example.goodservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.example.goodservice.db.dao")
@EnableDiscoveryClient
@EnableFeignClients
public class GoodserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodserviceApplication.class, args);
    }

}
