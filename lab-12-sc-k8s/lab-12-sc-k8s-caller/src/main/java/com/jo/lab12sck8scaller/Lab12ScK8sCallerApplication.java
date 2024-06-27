package com.jo.lab12sck8scaller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class Lab12ScK8sCallerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab12ScK8sCallerApplication.class, args);
    }

}
