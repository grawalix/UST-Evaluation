<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Changed Password here</h1>
<form action="changePass" align="center" method="post">
			
			<div >	<label for="email">
			
				email</label> <br> <input type="text"name="email" id="username">
					
			</div>

			<div ><label for="password">
				 
					oldpassword</label> <br><input type="password" name="oldpassword" id="op">
			</div>

			<div>
			<div ><label for="password">

				new password</label> <br> <input type="text" name="newpassword" id="np">
			</div>
					<div>
				<button type="submit">Submit</button>
			</div>

</body>
</html>