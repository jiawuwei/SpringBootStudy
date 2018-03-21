package com.jia.springboot.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by jia on 2018/3/12.
 */
public class ListenerTest implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //System.out.println("---监听器初始化---");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        //System.out.println("---监听器销毁---");
    }
}
