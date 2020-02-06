<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1 >Sign up</h1>
<fieldset style="width:350px;">

<form action="MangerRegistration"  method="post" >
<pre>
<h3 style="font-family:Times-Roman; "><b>
User Name:	    <input style="width: 200px" type="text" name="mname"  required="required" ><br>
Mobile No:	    <input style="width: 200px" type="tel" name="mnumber"   maxlength="10" ><br>
Email Id: 	    <input style="width: 200px"  type="email" name="email"  required="required"><br>
Password: 	    <input style="width: 200px"  type="password" name="password"  required="required"><br><br>
<input  type="submit" value="Sign Up">   |  <a  href="Login">Login</a> 
 </b></h3> 
</pre>
</form>
<h3 align="center">${msg }</h3>
</fieldset>
</center>
</body>
</html>