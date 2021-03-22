<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body bgcolor="#E6E6FA">
<table class="table-bordred table-striped">
<center>
<tr>
	<th>Order Id</th>

	<th col width="5%">Ordered By</th>
	<th col width="40%">Product name</th>
	<th col width="10%">Product price</th>
	<th col width="5%">product discount</th>
	<th col width="10%">Quantity</th>
	<th col width="20%">Total</th>
	
	<th></th>
	<th></th>
</tr>
</center>
	<c:forEach items="${cartlist}" var="c">
	<tr>
		<td >${c.id}</td> 
		<td >${c.user_name}</td>
		<td>${c.product_name }</td>
		<td>${c.price }</td>
		<td >${c.discount}</td>
		<td style="width:80%">${c.quantity }</td>
		<td >${c.total }</td>
		
	<td>	
<div class="container">
  

  <div class="progress" style = "width:100px">
    <div class="progress-bar progress-bar-striped active"  role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width:90%">
 Dispatched
    </div>
  </div>
</div>
		</td>
									</tr>
		
		
</c:forEach>
</table>
</body>
</html>