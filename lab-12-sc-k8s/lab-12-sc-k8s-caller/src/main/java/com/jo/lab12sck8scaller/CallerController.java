package com.jo.lab12sck8scaller;

import com.jo.lab12sck8scaller.client.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("caller")
public class CallerController {

    @Autowired
    private ServiceClient client;

    @GetMapping
    public String caller(@PathParam("name") String name){
        try {
            return client.home(name);
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @GetMapping("mysql-config")
    public String mysqlConfig(){
        try {
            return client.mysqlConfig();
        }catch (Exception e){
            return "null from caller";
        }
    }

}
