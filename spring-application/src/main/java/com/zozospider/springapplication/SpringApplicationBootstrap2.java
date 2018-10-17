package com.zozospider.springapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * {@link SpringApplication} 引导类
 *
 * @author zozo
 * @since 1.0
 */
public class SpringApplicationBootstrap2 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfiguration.class, args);
    }

    @SpringBootApplication
    public static class ApplicationConfiguration {

    }

}
