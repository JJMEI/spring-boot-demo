package com.meijunjie.springboot.config;

import com.meijunjie.springboot.interceptor.I18nInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by meijunjie on 2018/9/20.
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer{

    @Bean
    public I18nInterceptor i18nInterceptor(){
        return new I18nInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(i18nInterceptor());
    }


}
