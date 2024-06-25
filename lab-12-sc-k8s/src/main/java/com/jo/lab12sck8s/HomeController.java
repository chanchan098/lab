package com.jo.lab12sck8s;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("home")
@EnableConfigurationProperties(MySQLConfig.class)
public class HomeController {

    @Autowired
    private MySQLConfig mySQLConfig;

    @GetMapping
    public String hello(@PathParam("name") String name){
        return "hello "+name;
    }

    @GetMapping("mysql-config")
    public String getMySqlConfig(){
        return mySQLConfig.toString();
    }

}
