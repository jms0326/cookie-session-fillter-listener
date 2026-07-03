package com.example.cookiesession.step3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/premium")
public class PremiumServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("user") == null) {
            // 로그인이 필요
            session.setAttribute("msg", "Login이 필요합니다");
            resp.sendRedirect("/auth"); // auth로 보내버림
            return;
        }
        if (!session.getAttribute("grade").equals("premium")) {
            // premium 등급이 필요
            session.setAttribute("msg", "돈을 내세요");
            resp.sendRedirect("/auth"); // auth로 보내버림
            return;
        }
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("프리미엄 유저만 사용 가능한 페이지");
    }
}