package com.jo.lab12sck8sservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class Lab12ScK8sServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab12ScK8sServiceApplication.class, args);
    }

}
