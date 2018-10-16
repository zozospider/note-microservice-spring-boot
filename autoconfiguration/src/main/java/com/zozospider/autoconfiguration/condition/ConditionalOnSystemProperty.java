package com.zozospider.autoconfiguration.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * Java 系统属性 条件判断
 *
 * @author zozo
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty {

    /**
     * Java 系统属性名
     *
     * @return
     */
    String name();

    /**
     * Java 系统属性值
     *
     * @return
     */
    String value();

}
