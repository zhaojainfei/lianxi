package com.yushu.intecpter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 配置拦截器
@Configuration
public class CustomerWebMvcConfigurer implements WebMvcConfigurer{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 应用TestIntecpter拦截器于/api/*路径

        registry.addInterceptor(new TestIntecpter()).addPathPatterns("/api/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    // Interceptor和Filter的区别
    // 1.Filter只在tomcat启动销毁时候产生作用，而Interceptor是应用于controller的方法执行前，执行时，执行后
    // 2.Filter依赖于tomcat，而Interceptor不依赖
}
