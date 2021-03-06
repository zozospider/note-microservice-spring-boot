package com.zozospider.springapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * {@link SpringApplication} 引导类
 *
 * @author zozo
 * @since 1.0
 */
@SpringBootApplication
public class SpringApplicationBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(SpringApplicationBootstrap.class, args);
    }

}
