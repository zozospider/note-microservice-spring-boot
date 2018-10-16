package com.zozospider.overview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.zozospider.overview")
public class OverviewApplication {

    public static void main(String[] args) {

        SpringApplication.run(OverviewApplication.class, args);

    }

}
