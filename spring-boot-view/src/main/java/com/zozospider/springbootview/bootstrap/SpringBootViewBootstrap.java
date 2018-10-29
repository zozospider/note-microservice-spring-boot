package com.zozospider.springbootview.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 视图 引导类
 *
 * @author zozo
 * @since 1.0
 */
@SpringBootApplication(scanBasePackages = "com.zozospider.springbootview")
public class SpringBootViewBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootViewBootstrap.class, args);
    }

}
