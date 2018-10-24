package com.zozospider.springwebmvc.servlet.support;

import com.zozospider.springwebmvc.config.DispatcherServletConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Spring Web MVC 自动装配 默认实现
 *
 * @author zozo
 * @since 1.0
 */
public class DefaultAnnotationConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // web.xml
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    // DispatcherServlet配置类（com.zozospider.springwebmvc.config.DispatcherServletConfiguration）
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{DispatcherServletConfiguration.class};
    }

    /*<servlet-mapping>
        <servlet-name>app</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>*/
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
