package com.jia.springboot.common.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by jia on 2018/3/9.
 */
@Component //把pojo实例化到spring容器中，相当于<bean id=""class=""/>
//关联配置文件中的属性到 Bean 中,使用此注解需要添加依赖spring-boot-configuration-processor
@ConfigurationProperties(prefix = "ds")
public class DataSourseProperties {
    private String url;

    private String driverClassName;

    private String userName;

    private String password;


    public void show() {
        System.out.println("ds.url=" + this.url);
        System.out.println("ds.driverClassName=" + this.driverClassName);
        System.out.println("ds.userName=" + this.userName);
        System.out.println("ds.password=" +this.password);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
