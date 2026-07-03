package com.example.cookiesession.step5;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;

@WebListener // 어노테이션 달기만 한다 -> 특정 패턴으로 인식하게 X
public class RequestListener implements ServletRequestListener {
    // 리스너들의 인터페이스 타입이 있어서 그 인터페이스를 구현하면 자동이 등록이 됨


    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
        System.out.println("RequestListener.requestInitialized");
        System.out.println("RequestURI = " + req.getRequestURI());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
        System.out.println("RequestListener.requestDestroyed");
        System.out.println("RequestURI = " + req.getRequestURI());
    }
}