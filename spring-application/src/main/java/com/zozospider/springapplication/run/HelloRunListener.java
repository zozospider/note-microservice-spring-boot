package com.zozospider.springapplication.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Hello {@link SpringApplicationRunListener}
 *
 * @author zozo
 * @since 1.0
 */
public class HelloRunListener implements SpringApplicationRunListener {

    public HelloRunListener(SpringApplication application, String[] args) {

    }

    @Override
    public void starting() {
        System.out.println("HelloRunListener starting()...");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {

    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {

    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {

    }

    @Override
    public void started(ConfigurableApplicationContext context) {

    }

    @Override
    public void running(ConfigurableApplicationContext context) {

    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {

    }

}
