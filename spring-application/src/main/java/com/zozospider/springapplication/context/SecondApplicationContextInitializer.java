package com.zozospider.springapplication.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

/**
 * SecondApplicationContextInitializer
 *
 * @author zozo
 * @since 1.0
 */
public class SecondApplicationContextInitializer implements ApplicationContextInitializer, Ordered {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("Second ApplicationContextInitializer: " + applicationContext.getId());
    }

    /**
     * 实现 Ordered 接口，进行排序，并指定为低级别
     *
     * @return
     */
    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }

}
