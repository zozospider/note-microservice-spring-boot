package com.zozospider.autoconfiguration.configuration;

import com.zozospider.autoconfiguration.annotation.EnableHelloImportSelector;
import com.zozospider.autoconfiguration.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Configuration;

/**
 * Hello 自动装配
 *
 * @author zozo
 * @since 1.0
 */
@Configuration // Spring 模式注解
@EnableHelloImportSelector // Spring @Enable 模块装配
@ConditionalOnSystemProperty(name = "user.name", value = "Administrator") // Spring 条件装配
public class HelloAutoConfiguration {

}
