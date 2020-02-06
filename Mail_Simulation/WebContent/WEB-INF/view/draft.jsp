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

<h1 align="center">Draft</h1>
 <hr>	
<table style="background-color: green"; border='1' align='center'>
<tr><th>Message</th> <th>Draft</th> <th>Edit</th> </tr>
<c:forEach var="dto" items="${msg}">
<tr><td>${dto.getDraft_message()}</td><td>${dto. getDraft()}</td><td><a href="editcompose?id=${dto.getMid()}">Edit</a></td></tr>
</c:forEach>

<a   href="compose">Compose</a>|
<a   href="sentMail">Sent</a>|
<a   href="inboxMail">Inbox</a>|
<a   href="draftMail">Draft</a>|
<a   href="delMessage">DeletedMessage</a>|
<a   href="logout">Logout</a>|

</table>
</body>
</html>