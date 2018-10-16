package com.zozospider.autoconfiguration.bootstrap;

import com.zozospider.autoconfiguration.repository.MyFirstLevelRepository;
import com.zozospider.autoconfiguration.repository.MySecondLevelRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.zozospider.autoconfiguration.repository")
public class RepositoryBootstrap {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // 查找 Bean
        MyFirstLevelRepository myFirstLevelRepository = context.getBean("myFirstLevelRepository", MyFirstLevelRepository.class);
        MySecondLevelRepository mySecondLevelRepository = context.getBean("mySecondLevelRepository", MySecondLevelRepository.class);

        System.out.println("myFirstLevelRepository Bean: " + myFirstLevelRepository);
        System.out.println("mySecondLevelRepository Bean: " + mySecondLevelRepository);

        // 关闭上下文
        context.close();

    }

}
