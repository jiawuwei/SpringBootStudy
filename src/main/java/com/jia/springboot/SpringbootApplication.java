package com.jia.springboot;

import com.jia.springboot.common.filter.TimeFilter;
import com.jia.springboot.common.listener.ListenerTest;
import com.jia.springboot.common.servlet.ServletTest;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;


/**
 * springboot 启动类
 * Created by jia on 2018/3/9.
 */
@EnableCaching //生效ehcache缓存
@SpringBootApplication
public class SpringbootApplication implements ServletContextInitializer{

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);
        //context.getBean(WebConfig.class).show();
        //context.getBean(DataSourseProperties.class).show();

    }

    /**
     * Servlet、Filter、Listener配置的另一种方式
     * @param servletContext
     * @throws ServletException
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //配置servlet
        servletContext.addServlet("servLetTest",new ServletTest()).addMapping("/servletTest");
        //配置过滤器
        servletContext.addFilter("timeFilter",new TimeFilter()).
                addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),true,"/*");

        //配置监听器
        servletContext.addListener(new ListenerTest());

    }
}
