package com.gunner.config;

import com.gunner.intercepter.ApiInterceptor;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Msater Zg on 2017/4/5.
 * 拦截器管理工具//不知道什么用！！！
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //多个拦截器组成一个拦截器链
        // addPathPatterns用于添加拦截规则
        // excludePathPatterns用户排除拦截
        System.out.println("进入拦截器配置器");
        InterceptorRegistration iRegistration=registry.addInterceptor(new ApiInterceptor());
        iRegistration.addPathPatterns("/user/**"); //对来自/user/**              这个链接来的请求进行拦截
        //super.addInterceptors(registry);
    }
}