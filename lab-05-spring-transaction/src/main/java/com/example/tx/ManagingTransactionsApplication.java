package com.example.tx;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(exclude={DruidDataSourceAutoConfigure.class})
public class ManagingTransactionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagingTransactionsApplication.class, args);
    }

}
