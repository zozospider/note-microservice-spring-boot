package com.zozospider.autoconfiguration.annotation;

import com.zozospider.autoconfiguration.configuration.HelloImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 激活 Hello 模块
 *
 * @author zozo
 * @since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(HelloImportSelector.class)
public @interface EnableHelloImportSelector {

}
