package com.zozospider.springbootview.template.engine;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ThymeleafTemplateEngine {

    public static void main(String[] args) throws IOException {

        // 构建引擎
        SpringTemplateEngine engin = new SpringTemplateEngine();

        // 创造渲染上下文，设置 message
        Context context = new Context();
        context.setVariable("message", "Hello, Thymeleaf");

        // 从 classpath 读取内容
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:/templates/thymeleaf/hello-thymeleaf.html");

        // 通过文件流获取模板内容
        File file = resource.getFile();
        FileInputStream inputStream = new FileInputStream(file);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOUtils.copy(inputStream, outputStream);
        inputStream.close();
        String text = outputStream.toString("UTF-8");
        System.out.println("thymeleaf text: " + text);

        // 渲染处理
        String result = engin.process(text, context);
        System.out.println("thymeleaf result: " + result);
    }

}
