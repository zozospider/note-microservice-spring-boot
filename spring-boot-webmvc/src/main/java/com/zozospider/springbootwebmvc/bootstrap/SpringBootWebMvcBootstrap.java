package com.zozospider.springbootwebmvc.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Web MVC 引导类
 *
 * @author zozo
 * @since 1.0
 */
@SpringBootApplication(scanBasePackages = "com.zozospider.springbootwebmvc")
public class SpringBootWebMvcBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebMvcBootstrap.class, args);
    }

}
