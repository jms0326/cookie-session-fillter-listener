package com.example.cookiesession.step5;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener // 어노테이션 달기만 한다 -> 특정 패턴으로 인식하게 X
public class SessionListener implements HttpSessionListener {
    // 리스너들의 인터페이스 타입이 있어서 그 인터페이스를 구현하면 자동이 등록이 됨

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("SessionListener.sessionCreated");
        HttpSession session = se.getSession();
        System.out.println("session.getId() = " + session.getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("SessionListener.sessionDestroyed");
        HttpSession session = se.getSession();
        System.out.println("session.getId() = " + session.getId());
    }
}