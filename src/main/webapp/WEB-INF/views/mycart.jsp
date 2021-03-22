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
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>My Cart</title>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header"></div>

			<ul class="nav navbar-nav">
				<li class="active"><a href="home">Home</a></li>
				<li><a href="#"></a></li>
				<a class="navbar-brand" rel="home" href="#">
						<img style="max-width: 150px; margin-top: -7px;"
							src="https://jimbierly.files.wordpress.com/2014/09/mountain-gear-logo2.png">
				</a>

				<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">Explore Items<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><c:forEach items="${category}" var="category">
								<li><a
									href="<c:url value='/?name=${category.category_name}' />">${category.category_name}</a>
								</li>
						</c:forEach></li>
						</ul></li>

			</ul>
			

	<ul class="nav nav navbar-nav navbar-right">
	<c:choose>
				<c:when test="${empty loggedinuser or loggedout==true}">
					<li>
						<a id="SIGN IN" href="loginhere"><span class="glyphicon glyphicon-log-in"></span>&nbsp;&nbsp;SIGN IN</a>
						</li>
					<li>
						<a id="Register" href="registerhere"><span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;REGISTER</a>
						</li>
				</c:when>	
				<c:when test="${!empty loggedinuser}">
				<li> <a id="loggedin" href="#">WELCOME ${loggedinuser}</a>
					</li>
				<li> <a id="logout" href="logout"> <span class="glyphicon glyphicon-log-out"></span>&nbsp;&nbsp;LOGOUT</a>
					</li>
				
					
					
					<li> <a id="cart" href="add_cart"><span class="glyphicon glyphicon-shopping-cart"></span>&nbsp;&nbsp;cart(${cartsize})</a>
					</li>
				</c:when>
			</c:choose>
	</ul>
			


		</div>
	</nav>
<table class="table-bordred table-striped">
<center>
<tr>

	<th>Product name</th>
	<th>Product price</th>
	<th>product discount</th>
	<th>Quantity</th>
	<th>Total</th>
	<th>Operation</th>
	
</tr>
</center>
	<c:forEach items="${cartlist}" var="c">
	<tr>
		<td style="width:30%">${c.product_name}</td> 
		<td >${c.price}</td>
		<td >${c.discount}</td>
		<td >${c.quantity }</td>
		<td >${c.total }</td>
		<td style="width:10%"><a class="btn btn-danger" href="<c:url value='/deletecart?id=${c.id}' />">Delete</a></td>
		<td style="width:10%"><a class="btn btn-warning" href="<c:url value='/updatequantity?id=${c.id}' />">Edit Quantity</a></td>
									</tr>
		
		
</c:forEach>
<tr>
								<td colspan="7" ><a href="welcome"
									class="btn btn-warning" role="button">Continue Shopping</a> 
										<a href="userdetailshere" class="btn btn-info" role="button">Proceed</a></td>
												
							</tr>
</table>

<p>Grand Total = ${grandtotal}</p>
<a href="shippingrequest" class="btn btn-info" role="button">Proceed</a></td>
</body>
</html>