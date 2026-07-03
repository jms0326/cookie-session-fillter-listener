package com.example.cookiesession.step4;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

// 1. @WebFilter -> 패턴으로 사용하는게 권장
// 2. implements
@WebFilter("/*") // / -> 접두사로하는 요청을 다 받아주겠다
//@WebFilter({"/filter/*", "/session/*"})
public class EncodingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("EncodingFilter.init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("EncodingFilter.doFilter");
        // ServletRequest -> HttpServletRequest
        HttpServletRequest req = (HttpServletRequest) request; // 다운캐스팅
        System.out.println("RequestURI = " + req.getRequestURI());

        // 인코딩 처리
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("인코딩 처리 완료");

        chain.doFilter(request, response); // chain을 다음으로 넘겨주지 않으면 원래 가려던 곳으로 못감
    }

    @Override
    public void destroy() {
        System.out.println("EncodingFilter.destroy");
    }
}