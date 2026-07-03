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
        Cookie[] cookies = req.getCookies(); // Spring 가보면 전용 유틸리티
        readCookies(cookies);
        // 쿠키를 보내려면
        resp.addCookie(new Cookie("firstCookie", "Hello_Cookie"));
        // 쿠키를 다양하게 만들어보자
        Cookie cookie = makeCookie();
        resp.addCookie(cookie);
        req.getRequestDispatcher("/WEB-INF/views/step01/cookie.jsp").forward(req, resp);
    }

    private Cookie makeCookie() {
        Cookie cookie = new Cookie("customCookie", "haha");
        // 1. path
        // 기본값은 cookie.setPath("/");
        // -> 다른 페이지에서도 볼 수 있다
//        cookie.setPath("/cookie"); // 이 경로에만 읽을 수 있게
        // 2. 지속시간
//        cookie.setMaxAge(-1); // 기본값
        // 세션 쿠키 -> 현재 브라우저가 켜 있는 동안
//        cookie.setMaxAge(16); // 16초 동안 유지
        // 0보다 큰 양수는 초. 60 * 60 * 24 하루. 86400
//        cookie.setMaxAge(60 * 60 * 24); // 하루 유지
//        cookie.setMaxAge(0); // 쿠키를 삭제하고 싶을 때
//        cookie.setMaxAge(86400);
        // 3. 보안
//        cookie.setHttpOnly(false);
        cookie.setHttpOnly(true);
        // document.cookie
//        cookie.setSecure(false); // http도 허용
        cookie.setSecure(true); // https만 허용 + localhost까진 허용
        // 3-2. Samesite <- CSRF => 피싱사이트 방지
//        cookie.setAttribute("SameSite", "None"); // Secure
        // 다른 출처의 요청에도 전송한다 (다른 사이트에서 Form, Fetch 등으로 전송)
//        cookie.setAttribute("SameSite", "Strict"); // 동일출처만 쿠키 전송 (Same Origin -> 프로토콜, 도메인, 포트까지 같아야 같은 오리진)
//        cookie.setAttribute("SameSite", "Lax"); // 몇몇 조건에만 조건부 허용
        // GET 요청. 유저가 링크/리다이렉트로 이동 -> 같은 출처가 아니더라도 허용.
        // https://developer.mozilla.org/ko/docs/Web/HTTP/Reference/Headers/Set-Cookie#samesitesamesite-value
        return cookie;
    }

    private void readCookies(Cookie[] cookies) {
        for (Cookie cookie : cookies) {
            System.out.println("cookie = " + cookie);
            System.out.println("cookie.getName() = " + cookie.getName()); // ***
            System.out.println("cookie.getValue() = " + cookie.getValue()); // ***
            System.out.println("cookie.getPath() = " + cookie.getPath());
            System.out.println("cookie.getDomain() = " + cookie.getDomain());
            System.out.println("cookie.getMaxAge() = " + cookie.getMaxAge());
            System.out.println("cookie.getSecure() = " + cookie.getSecure());
        }
    }
}