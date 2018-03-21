package com.jia.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by jia on 2018/3/9.
 * 不同开发环境可以使用不同的bean，只需要在applica.properties
 * 中指定sprin.profiles.active的值即可
 */
@Configuration
public class BeanConfiguration {
    @Bean
    @Profile("dev")
    public Runnable test1(){
        System.out.println("dev-bean");
        return null;
    }
    @Bean
    @Profile("test")
    public Runnable test2(){
        System.out.println("使用的是：common-bean");
        return null;
    }
    @Bean
    @Profile("prod")
    public Runnable test3(){
        System.out.println("prod-bean");
        return null;
    }
}

