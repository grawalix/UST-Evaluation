<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Enter Registration Details</h1>
<hr>
	<form action="registrationData" align="center" method="post">
			
			<div style="background-color: green";>	<label for="username">
			
				Username</label> <br> <input type="text"name="username" id="username">
					
			</div>

			<div style="background-color: green";><label for="password">
				 
					Password</label> <br><input type="password" name="password" id="password">
			</div>

			<div>
			<div style="background-color: green";><label for="name">

				Email Id</label> <br> <input type="text" name="email" id="email">
			</div>

			<div style="background-color: green";><label for="category">

				 Age</label> <br> <input type="text" name="age" id="age">
			</div>
			<div style="background-color:green">
			<label for="">Security Question</label>
			<select style="width:150px;"name="question">
			<option value=""selected disabled>option</option>
			<option value="what is your favorite hobby">what is your favorite hobby</option>
			<option value="what is your favorite sport" >what is your favorite sport</option>
			<option value="what is your favorite sports team" >what is your favorite sports team</option>
           </select>
			</div>
			
			<div style="background-color:green">
			<label for="">Answer</label>
             <input type="text" name="answer">
			</div>

			<div>
				<button style="background-color: blue" type="submit">Sign Up</button>
			</div>

			

		</form>
<h3>${msg }</h3>
<a href="login">Login</a>|


</body>
</html>