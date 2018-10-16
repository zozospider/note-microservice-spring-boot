package com.zozospider.autoconfiguration.configuration;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Hello {@link ImportSelector} 实现
 *
 * @author zozo
 * @since 1.0
 */
public class HelloImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{HelloConfiguration.class.getName()};
    }

}
