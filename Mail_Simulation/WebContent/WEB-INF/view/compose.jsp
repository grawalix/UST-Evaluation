<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Compose</h1>
	<hr>
	<form action="composemail" align="center" method="post">
		<div>
		
			<label for="to">To</label> <br> <input type="text"
				name="to" id="to">

		</div>
		<div>
			<label for="subject">Subject</label> <br>
			<textarea rows="5" cols="10" type="textarea" name="subject" id="subject"></textarea>
			
		</div>

		<div>
			<label for="msg">Message</label> <br>
			<textarea rows="10" cols="40" type="textarea" name="msg" id="msg"></textarea>
			
		</div>
		<div style="margin-top: 10px;">
			<input type="Submit" value="Send">
		</div>



	</form>



<a   href="logout">Logout</a>|



</body>
</html>