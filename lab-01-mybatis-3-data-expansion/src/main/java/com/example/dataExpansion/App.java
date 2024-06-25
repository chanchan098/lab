package com.example.dataExpansion;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.dataExpansion.mapper")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
