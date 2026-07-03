package com.example.cookiesession.step3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/free")
public class FreeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("user") == null) {
            // 로그인이 필요한 상태
            resp.sendRedirect("/auth"); // auth로 보내버림
            return;
        }
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("유저면 무료로 사용 가능한 페이지");
    }
}