<%-- webapp/index.jsp --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>기본 경로와 연결</title>
</head>
<body>
<p>
    ${cookie.getOrDefault("customCookie", "읽을 수 없음")}
</p>
</body>
</html>