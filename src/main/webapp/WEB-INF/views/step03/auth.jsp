<%-- webapp/WEB-INF/views/step03/auth.jsp --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auth</title>
</head>
<body>
<h1>Auth</h1>
<form method="post">
    <input name="username"><br>
    <input name="password" type="password"><br>
    <input type="submit">
</form>
<section>
    <p>
        ${user}
    </p>
    <p>
        ${msg}
    </p>
</section>
</body>
</html>