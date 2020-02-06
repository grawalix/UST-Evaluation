<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center" >Delete</h1>
 <hr>
<table style="background-color:green"border='1' align="center">
<tr><th>Message</th> <th>from</th><th>Status</th></tr>
<c:forEach var="dto" items="${msg}">
<tr><td>${dto.getInbox()}</td><td>${dto.getSentBy()}</td><td>${dto.getStatus()}</td></tr>
</c:forEach>
</table>

<a   href="compose">Compose</a>|
<a   href="sentMail">Sent</a>|
<a   href="inboxMail">Inbox</a>|
<a   href="draftMail">Draft</a>|
<a   href="delMessage">DeletedMessage</a>|
<a   href="logout">Logout</a>|
</body>
</html>