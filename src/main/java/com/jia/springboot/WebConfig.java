package com.jia.springboot;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.jia.springboot.common.interceptor.TimeInterceptor;
import com.jia.springboot.common.listener.ListenerTest;
import com.jia.springboot.common.servlet.ServletTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

/**
 * 配置类
 * Created by jia on 2018/3/9.
 * 读取配置文件有两种方法：使用 @Value 注解和 Environment 对象。
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
    @Value("${ds.userName}")
    private String userName; //value注解可以将配置文件的属性注入到bean中特定的成员变量
    @Resource
    private Environment environment;
    @Resource
    private TimeInterceptor timeInterceptor; //注入拦截器
    public void show() {
        System.out.println("userName:" + this.userName);
        System.out.println("password:" + this.environment.getProperty("ds.password"));
    }

    /**
     * 配置fastjson
     *
     * @return
     */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
        return new HttpMessageConverters(converter);
    }

    /**
     * 注册servlet
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new ServletTest(), "/servletTest");
    }
    /**
     * 注册过滤器,此方式适用于使用第三方的过滤器，也可在过滤器类中添加@Component注解
     */
     /*   @Bean
        public FilterRegistrationBean timeFilter() {
            FilterRegistrationBean registrationBean = new FilterRegistrationBean();

            TimeFilter timeFilter = new TimeFilter();
            registrationBean.setFilter(timeFilter);

            List<String> urls = new ArrayList<String>();
            //对*//*下所有路径都过滤，过滤其响应时间
            urls.add("*//*");
            registrationBean.setUrlPatterns(urls);

            return registrationBean;
        }*/

    /**
     * 注册监听器
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean<ListenerTest> servletListenerRegistrationBean(){
        return new ServletListenerRegistrationBean<ListenerTest>(new ListenerTest());
    }
    /**
     * 注册拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }

    /**
     * 粗粒度
     * 允许跨域请求方式一
     * @return
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/fastjson/**")
                        .allowedOrigins("http://localhost:8089");// 允许 8088 端口访问
            }
        };
    }
    /**
     * 粗粒度
     * 允许跨域请求方式二
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/fastjson/**")
                .allowedOrigins("http://localhost:8088");// 允许 8088 端口访问
    }
}
