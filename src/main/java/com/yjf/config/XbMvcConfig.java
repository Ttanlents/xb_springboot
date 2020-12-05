package com.yjf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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


    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/**/user/checkEmail/**")
                .excludePathPatterns("/**/user/check/**/username/**")
                .excludePathPatterns("/**/user/register/**")
                .excludePathPatterns("/**/user/sendEmailCode/**")
                .excludePathPatterns("/**/user/resetPassword/**")
                .excludePathPatterns("/**/user/doLogin/**")
                .excludePathPatterns("/**/**/user/logout/**")
                .excludePathPatterns("/**/myServlet/**")
                .excludePathPatterns("/**/toWx_login/**")
                .excludePathPatterns("/**/wx_login/**")
                .excludePathPatterns("/**/index.html")
                .excludePathPatterns("/**/forget.html")
                .excludePathPatterns("/**/register.html")
                .excludePathPatterns("/**/wxLogin.html")
                .excludePathPatterns("/**/saveWxLoginUser")
                .excludePathPatterns("/**/xb_socket/**")
                .excludePathPatterns("/**/bootstrap/**")
                .excludePathPatterns("/**/css/**")
                .excludePathPatterns("/**/fonts/**")
                .excludePathPatterns("/**/img/**")
                .excludePathPatterns("/**/favicon.ico")
                .excludePathPatterns("/**/error")
                .excludePathPatterns("/**/js/**")
                .excludePathPatterns("/**/vendor/**")
                .excludePathPatterns("/**/assets/**")
                .excludePathPatterns("/**/upload/**");
    }
}
