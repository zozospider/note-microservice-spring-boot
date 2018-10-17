package com.zozospider.springapplication.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * FirstApplicationContextInitializer
 *
 * @param <C>
 * @author zozo
 * @since 1.0
 */
@Order(Ordered.HIGHEST_PRECEDENCE) // 进行排序，并指定为高级别
public class FirstApplicationContextInitializer<C extends ConfigurableApplicationContext>
        implements ApplicationContextInitializer<C> {

    @Override
    public void initialize(C applicationContext) {
        System.out.println("First ApplicationContextInitializer: " + applicationContext.getId());
    }

}
