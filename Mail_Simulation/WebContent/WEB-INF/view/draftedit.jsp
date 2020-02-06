<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">compose mail here</h1>
<div style="text-align:center">
<fieldset style="background-color:lightblue";border='1' width=200px>
<form action="editcomp", method="get">

<div>
		
			<label for="to">To</label> <br> <input type="text" value="${dto.getDraft()}"
				name="to" id="to">

		</div>
		<div>
		
			<label for="id"></label> <br> 
			<input type="hidden" value="${dto.getMid()}"
				name="id" id="to">

		</div>
		<div>
			<label for="subject">Subject</label> <br>
			<input rows="5" cols="10" type="textarea" name="subject" id="subject" value="${dto.getSubject()}"></textarea>
			
		</div>

		<div>
			<label for="msg">Message</label> <br>
			<input rows="10" cols="40" type="textarea"  value="${dto.getDraft_message()}"name="msg" id="msg"></textarea>
			
		</div>
		<div style="margin-top: 10px;">
			<input type="Submit" value="Send">
		</div>

</div>
</form></fieldset>

<a   href="compose">Compose</a>|
<a   href="sentMail">Sent</a>|
<a   href="inboxMail">Inbox</a>|
<a   href="draftMail">Draft</a>|
<a   href="delMessage">DeletedMessage</a>|
<a   href="logout">Logout</a>
</body>
</html>