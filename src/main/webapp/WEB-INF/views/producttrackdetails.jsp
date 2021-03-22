<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table class="table-bordred table-striped">
<center>
<tr>
	<th>Order Id</th>
	<th>Order Date</th>
	<th>Ordered By</th>
	<th>Product name</th>
	<th>Product price</th>
	<th>product discount</th>
	<th>Quantity</th>
	<th>Total</th>
	
	
	<th></th>
</tr>
</center>
	<c:forEach items="${cart}" var="c">
	<tr>
		<td style="width:30%">${c.id}</td> 
		<td >${c.user_name}</td>
		<td>${c.product_name }</td>
		<td>${c.price }</td>
		<td >${c.discount}</td>
		<td >${c.quantity }</td>
		<td >${c.total }</td>
		
									</tr>
		
		
</c:forEach>
</table>
</body>
</html>