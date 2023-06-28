package com.cque.nanshanluntan.config;

import com.cque.nanshanluntan.common.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * 拦截器配置类：把自定义拦截器注入
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Resource
    MyInterceptor myInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] patterns = {
                "/users/login",
                "/users/register",
        };
        // 配置不被拦截的请求
        registry.addInterceptor(myInterceptor)
                .excludePathPatterns(patterns);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        /**
         * .allowCredentials()
         * 设置是否允许客户端发送 cookie 信息(保证 Session 一致性)
         */
        registry.addMapping("*").allowCredentials(true);
    }
}
