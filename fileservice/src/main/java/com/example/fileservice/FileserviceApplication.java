package com.example.fileservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FileserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FileserviceApplication.class, args);
    }
}
