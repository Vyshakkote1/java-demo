package com.example.annotation.conf;

import com.example.annotation.Interceptor.SourceAccessInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: Xingweicheng
 * @description: TODO
 * @date: 2023/6/3 17:44
 */
@Configuration
public class InterceptorTrainConfigurer implements WebMvcConfigurer {
    @Override
     public void addInterceptors(InterceptorRegistry registry){
         registry.addInterceptor(new SourceAccessInterceptor()).addPathPatterns("/**");
     }

}
