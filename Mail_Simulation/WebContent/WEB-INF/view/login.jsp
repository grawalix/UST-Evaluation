<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1 align="center">Login Column</h1>
	<hr>
	<form action="loginvalidation" method="Post">
		<div s>
			<label for="username">Username</label> <br> <input type="text"
				name="username" id="username">

		</div>

		<div >
			<label for="password">Password</label> <br> <input
				type="password" name="password" id="password">
		</div>
		<div>
			<input type="Submit" value="Login">
		</div>
		<div>
			<input type="reset" value="reset">
		</div>

   <a href="changePass">ChangePassword</a>
<a href="forget">FogotPassword</a>
	</form>



<hr>
<h4 align="right">${msg}</h4>
<a href="registration">Registration</a>|


</body>
</html>