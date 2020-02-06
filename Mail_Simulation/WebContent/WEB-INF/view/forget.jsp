<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to Forget Password</h1>
<form action="forget" align="center" method="post">
			
			<div >	<label for="email">
			
				email</label> <br> <input type="text"name="email" id="username">
					
			</div>

			
			<div>
			<div ><label for="password">

				new password</label> <br> <input type="text" name="newpassword" id="np">
			</div>
			
			<div>
			<label for="">Security Question</label>
			<select style="width:150px;"name="question">
			<option value=""selected disabled>option</option>
			<option value="what is your favorite hobby">what is your favorite hobby</option>
			<option value="what is your favorite sport" >what is your favorite sport</option>
			<option value="what is your favorite sports team" >what is your favorite sports team</option>
           </select>
			</div>
			
			<div>
			<label for="">Answer</label>
             <input type="text" name="answer">
			</div>
			
					<div>
				<button type="submit">Submit</button>
			</div>

</body>
</html>