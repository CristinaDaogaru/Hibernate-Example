<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.util.*" %>
<%@ page import = "com.entities.*" %>
<%@ page import = "com.model.*"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shipping cart</title>
</head>
<body>
<%ProductModel product = new ProductModel(); %>

	<table cellpadding="2" cellspacing="2" border="1">
<!-- 		<a href="account?action=register">Register</a> -->

		<br>

		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Buy</th>
		</tr>

		<c:forEach var="p" items="<%=product.findAll() %>">
			<tr>
				<td>${ p.id}</td>
				<td>${ p.name }</td>
				<td>${ p.price }</td>
				<td align = "center"><a href="ShoppingCartController?id=${p.id }&action=ordernow">Order Now</a></td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>