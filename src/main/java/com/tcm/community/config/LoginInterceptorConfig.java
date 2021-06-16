package com.tcm.community.config;

import com.tcm.community.controller.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginInterceptorConfig implements WebMvcConfigurer {//config LoginInterceptor

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {//register interceptor
        //registry.addInterceptor(loginInterceptor);//intercept all request
        //exclude some paths
        registry.addInterceptor(loginInterceptor).addPathPatterns("/user");
                //.excludePathPatterns("/*/*.css","/*/*.js","/*/*.png","/*/*.jpg","/*/*.jpeg","/*/*.html");
    }
}
