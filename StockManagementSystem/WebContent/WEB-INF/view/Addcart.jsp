<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
<h1 align="center" style=" font-size: 30px;"><b><i>Items Present in Cart</b></i></h1>
<br><br>
<h3 align="center">
<a href="search">Search Product</a> | <a  href="add">Add Product </a> | <a  href="addtocart">Items for cart</a> | <a  href="allproduct">All Products/Update</a> |  <a  href="Home">Home</a></h3>
<h1 align="center">${msg}</h1>
<h3 align="right" >${user} <br><br>
 <a href="logout">Logout</a></h3></h3> 
<hr>

<h3><center><table border='1'><tr><th>Product Name</th><th>Product Category</th><th>Company Name</th> <th>Quantity</th><th>Price</th><th>Cart</th></tr>
<c:forEach var="mdto" items="${mlist}">
<form action="cartadded" method="post">
<tr>
<input type="hidden" name="pid" value=" ${mdto.getPid() }">
<td><center><input type="text" disabled="disabled" name="pname" value="${mdto.getPname() }"></center></td>
<td><center> <input type="text" disabled="disabled" name="pcategory" value="${mdto.getPcategory() }"></center></td>
<td><center><input type="text" disabled="disabled" name="pcompany"  value="${mdto.getPcompany() }"></center></td>
<td><center><input type="text" name="pquantity" value=" " >${ mdto.getPquantity()}</center></td>
<td><center><input type="text" disabled="disabled" name="price" value="${mdto.getPrice() }"></center></td> 
<td><center><input type="submit" value="Addcart"></center></td>
</tr>
</form>
</c:forEach>
</table>
</center></h3>
</body>
</html>
