<%-- webapp/WEB-INF/views/step01/cookie.jsp --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cookie</title>
</head>
<body>
<h1>Cookie</h1>
<p>
    ${cookie.get("firstCookie").value}
</p>
</body>
</html>