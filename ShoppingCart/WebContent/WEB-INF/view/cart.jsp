<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart Info</title>
</head>
<body>
<a href="http://localhost:8083/HibernateValidationJSP/product">Continue Shopping</a>
	<table cellpadding="2" cellspacing="2" border="1">
		

		<br>

		<tr>
			<th>Option</th>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Sub Total</th>
		</tr>
		<c:set var = "sum" value="0"></c:set> 
		<c:forEach var="it" items="${sessionScope.cart }">
 		<c:set var="sum" value="${sum + it.product.price * it.quantity  }"></c:set> 
			<tr>
				<td align="center"><a href="ShoppingCartController?id=${it.product.id }&action=delete"
				 onclick="return confirm('Are you sure?')">Delete</a></td>
				<td>${ it.product.id }</td>
				<td>${ it.product.name }</td>
				<td>${ it.product.price}</td>
				<td>${ it.quantity }</td>
				<td>${ it.product.price * it.quantity }</td>
				
			</tr>

		</c:forEach>
		<tr>
		 	<td colspan="5" align="right">Sum</td>
		 	<td>${sum }</td> 
		</tr>
	</table>
</body>
</html>