<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="carousel.css" rel="stylesheet">

<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<!-- -------------------- -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<link type="text/css" rel="stylesheet"
	href="src/main/webapp/WEB-INF/resources/css/login.css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/holder/2.9.1/holder.min.js"></script>

<title>Confirm Shipping</title>
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


	<br />
	<br />


	<!-- --------------------------------------------------------------------------------------------- -->

	<div class="container" style='background-color: TEAL'>
		<div class="wrapper">
				<form:form modelAttribute="shippingdetails">
				<center>
					<h3 class="form-signin-heading" style='color: DarkGrey'>Please confirm your details</h3>

					<hr>
					<br>
					
					
				<form:label path="send_to"> Recepient:</form:label>${shippingdetails.send_to}
					<br />
				<br />
				<form:label path="email">Email:</form:label>${shippingdetails.email}
					<br />
				<br />
				<form:label path="contact_number">Contact Number #:</form:label>${shippingdetails.contact_number}
					<br />
				<br />
				<form:label path="address">Address :</form:label>${shippingdetails.address}
					<br />
				<br />
				
				<form:label path="mode_of_payment">Mode of payment :</form:label>${shippingdetails.mode_of_payment}
					<br />
				<br />
				<input name="_eventId_edit" type="submit" value="Edit" />
				<input name="_eventId_submit" type="submit" value="Confirm Details" />
				
				<br />
				</center>
			</form:form>
		</div>
	</div>
</body>
</html>