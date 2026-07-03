package com.example.cookiesession.step2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        세션 호출
        HttpSession session = req.getSession();
//        HttpSession session = req.getSession(true); // default -> 세션이 없으면 만들어서 처리
//        HttpSession session = req.getSession(false); // 쿠키에 세션ID가 없거나, 만료되어있다면 session null값이 됨.
        // -> JSESSIONID -> 메모리에 저장된 데이터
        System.out.println("session.getId() = " + session.getId());
//        if (session != null) {
//            session.invalidate(); // 명확한 만료
//        }
        session.setAttribute("data", "my-data");
        session.setAttribute("dto", new DTO("my-dto", 1));

//        System.out.println(session.getAttribute("dto")); // object
//        DTO dto = (DTO) session.getAttribute("dto"); // 다운캐스팅이 필요

        // 1. req.getSession(true or false) - invalidate (만료)
        // 2. session.getAttribute, setAttribute
        // 2-1. sessionScope -> ${속성명} (우선순위가 req.~Attribute)
        // 2-2. attribute -> Object. -> Downcasting -> 모든 객체는 Object 업캐스팅 자연스러움
        // 3. session
        // 3-1. session 자체에 데이터를 담아서
        // 3-2. session.getId 또는 식별용 토큰/정보만을 담아서 DB 연동

        req.getRequestDispatcher("/WEB-INF/views/step02/session.jsp").forward(req, resp);
    }
}