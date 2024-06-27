package com.jo.lab12sck8scaller.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "lab-12-sc-k8s-service")
public interface ServiceClient {

    @GetMapping("/home?name={name}")
    String home(@PathVariable("name") String name);

    @GetMapping("/home/mysql-config")
    String mysqlConfig();
}
