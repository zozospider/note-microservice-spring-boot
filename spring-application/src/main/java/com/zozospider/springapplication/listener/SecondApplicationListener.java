package com.zozospider.springapplication.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * Second {@link ApplicationListener} 监听 {@link ContextRefreshedEvent}
 *
 * @author zozo
 * @since 1.0
 */
public class SecondApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("Second ApplicationListener: " + event.getApplicationContext().getId()
                + ", timestamp: " + event.getTimestamp());
    }

}
