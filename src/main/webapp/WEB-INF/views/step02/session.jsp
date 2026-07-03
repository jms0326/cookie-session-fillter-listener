<%-- webapp/WEB-INF/views/step02/session.jsp --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Session</title>
</head>
<body>
<h1>Session</h1>
<p>
  <%--  session.setAttribute -> sessionScope -> el 해석  --%>
  ${data} <br>
  ${dto}
</p>
</body>
</html>