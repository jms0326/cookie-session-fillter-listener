package com.example.cookiesession.step1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        readCookies(cookies);

        req.getRequestDispatcher("/WEB-INF/views/step01/cookie.jsp").forward(req, resp);
    }

    private void readCookies(Cookie[] cookies) {
        for(Cookie cookie : cookies) {
            System.out.println("cookie = " + cookie);
        }
    }
}
