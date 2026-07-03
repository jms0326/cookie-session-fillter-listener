package com.example.cookiesession.step4;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("AuthFilter.init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("AuthFilter.doFilter");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response; // 내가 찾던게 없으면 타입탓
        HttpSession session = req.getSession();
        if (req.getRequestURI().startsWith("/filter")) { // startsWith (접두사)
            // 인증 검사를 하겠다
            if (session.getAttribute("user") == null) {
                resp.sendRedirect("/auth");
            }
            // /filter -> 로그인을 해야 볼 수 있음
            if (req.getRequestURI().contains("premium")) {
                // 인가 검사를 하겠다
                if (!session.getAttribute("grade").equals("premium")) {
                    resp.sendRedirect("/auth");
                }
            }
        }

        chain.doFilter(request, response); // chain을 다음으로 넘겨주지 않으면 원래 가려던 곳으로 못감
    }

    @Override
    public void destroy() {
        System.out.println("AuthFilter.destroy");
    }
}