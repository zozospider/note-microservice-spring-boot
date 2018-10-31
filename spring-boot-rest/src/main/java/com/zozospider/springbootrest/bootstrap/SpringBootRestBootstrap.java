package com.zozospider.springbootrest.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.zozospider.springbootrest")
public class SpringBootRestBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestBootstrap.class, args);
    }

}
