<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align:center">details sent</h1>
<table style="background-color: green"border='1' align='center'>

<tr><th>sent</th> <th>message</th></tr>
<c:forEach var="dto" items="${msg}">
<tr><td>${dto.getSent()}</td><td>${dto.getInbox()}</td></tr>
</c:forEach>
</table>
<hr>
<a   href="compose">Compose</a>|
<a   href="sentMail">Sent</a>|
<a   href="inboxMail">Inbox</a>|
<a   href="draftMail">Draft</a>|
<a   href="delMessage">DeletedMessage</a>|
<a   href="logout">Logout</a>
</body>
</html>