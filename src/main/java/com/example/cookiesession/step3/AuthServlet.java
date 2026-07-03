package com.example.cookiesession.step3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/step03/auth.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // username : admin
        // password : 1234
        if ("admin".equals(username) && "1234".equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", username);
            session.setAttribute("grade", "free");
//            req.setAttribute("msg", "Login success"); // redirect 시 req.attribute를 전달 X.
            session.setAttribute("msg", "Login success (free)");
        }
        if ("admin2".equals(username) && "1234".equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", username);
            session.setAttribute("grade", "premium");
            session.setAttribute("msg", "Login success (premium)");
        }
        resp.sendRedirect("/auth"); // 빈 접속 요청으로 인식
        // 1. 세션
        // 2. 쿠키
        // 3. 주소창(쿼리스트링)
    }
}