<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1  align="center"> Welcome to Mail Menu</h1>
<h4 align="right">${dto.getUsername()}</h4>

<hr>
<h4 align="right">${msg}</h4>


		
<a   href="compose">Compose</a>|
<a   href="sentMail">Sent</a>|
<a   href="inboxMail">Inbox</a>|
<a   href="draftMail">Draft</a>|
<a   href="delMessage">DeletedMessage</a>|
<a   href="logout">Logout</a>|
<hr>

<hr>
</body>
</html>