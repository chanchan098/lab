package com.jo.lab12sck8s;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;


//@EnableFeignClients
//@EnableDiscoveryClient
@SpringBootApplication
public class Lab12ScK8sApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab12ScK8sApplication.class, args);
    }

}
