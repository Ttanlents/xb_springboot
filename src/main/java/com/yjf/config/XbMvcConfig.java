package com.yjf.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 余俊锋
 * @date 2020/12/2 9:57
 * @Description
 */
@Configuration  //配置springMvc 静态资源映射   继承WebMvcConfigurerSupport不会走yml中的EnableAutoConfiguration
public class XbMvcConfig implements WebMvcConfigurer {

    @Value("${file.requestPath}")
    private String requestPath;

    @Value("${file.dir}")
    private String dir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(requestPath).addResourceLocations("file:///" + dir);
    }
}
