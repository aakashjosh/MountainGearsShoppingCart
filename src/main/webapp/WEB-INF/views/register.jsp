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
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="carousel.css" rel="stylesheet">

<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<!-- -------------------- -->
<meta name="viewport" content="width=device-width, initial-scale=1">



<title>Registration Page</title>
</head>
<body>
	<br />
	<br />


	<!-- --------------------------------------------------------------------------------------------- -->

	<div class="container" style='background-color: White'>
		<div class="wrapper">
			<form:form modelAttribute="userdetails">
				<center>
					<h3 class="form-signin-heading">YOU
						CAN REGISTER HERE!!</h3>

					<hr>
					<br>
					<table class ="table-bordred table-striped">
						<tr>
							<td><form:label path="user_name" >USER NAME:</form:label></td>
							<td><form:input path="user_name" /></td>
							
							
							<td><c:forEach
									items="${flowRequestContext.messageContext.getMessagesBySource('user_name')}"
									var="err">
									<div>
										<span>${err.text}</span>
									</div>
								</c:forEach></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td><form:label path="password" >Password:</form:label></td>
							<td><form:password path="password" /></td>
							<td><c:forEach
									items="${flowRequestContext.messageContext.getMessagesBySource('password')}"
									var="err">
									<div>
										<span>${err.text}</span>
									</div>
								</c:forEach></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td><form:label path="repeatpassword"
									>Repeat password:</form:label></td>
							<td><form:password path="repeatpassword" /></td>
							<td><c:forEach
									items="${flowRequestContext.messageContext.getMessagesBySource('repeatpassword')}"
									var="err">
									<div>
										<span>${err.text}</span>
									</div>
								</c:forEach></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td><form:label path="email" >Email:</form:label></td>
							<td><form:input path="email" /></td>
							<td><c:forEach
									items="${flowRequestContext.messageContext.getMessagesBySource('email')}"
									var="err">
									<div>
										<span>${err.text}</span>
									</div>
								</c:forEach></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td><form:label path="contactnumber"
									>Contact Number:</form:label></td>
							<td><form:input path="contactnumber" /></td>
							<td><c:forEach
									items="${flowRequestContext.messageContext.getMessagesBySource('contactnumber')}"
									var="err">
									<div>
										<span>${err.text}</span>
									</div>
								</c:forEach></td>

						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td><form:label path="address"
									>Address:</form:label></td>
							<td><form:input path="address" /></td>
							<td><c:forEach
									items="${flowRequestContext.messageContext.getMessagesBySource('address')}"
									var="err">
									<div>
										<span>${err.text}</span>
									</div>
								</c:forEach></td>

						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
						<tr>
							<td>&nbsp;</td>
							<td><input class="btn btn-primary" name="_eventId_submit" type="submit" value="Submit" />
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
					</table>
				</center>
			</form:form>
		</div>
	</div>
</body>
</html>