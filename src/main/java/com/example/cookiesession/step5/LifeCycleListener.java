package com.example.cookiesession.step5;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener // 어노테이션 달기만 한다 -> 특정 패턴으로 인식하게 X
public class LifeCycleListener implements ServletContextListener {
    // 리스너들의 인터페이스 타입이 있어서 그 인터페이스를 구현하면 자동이 등록이 됨

    // ServletContextListener
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        System.out.println("LifeCycleListener.contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("LifeCycleListener.contextDestroyed");
    }
}