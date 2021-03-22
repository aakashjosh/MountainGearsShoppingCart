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
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Login</title>
</head>
<body>
<c:if test="${not empty error}">
		<div class="errorblock">
			Your login attempt was not successful, try again.
			<br /> Caused :${error}
		</div>
	</c:if>

	<div class="container">
		<div class="wrapper">
			<form action="<c:url value='j_spring_security_check' />"
				method='POST'>
				<center>
					<h3 class="form-signin-heading" style='color: black'>Welcome
						Back! Please Sign In</h3>

					<hr>
					<br>
					<table class="table-bordred table-striped">
						<tr>
							<td>USER NAME:</td>
							<td col span="2"><input type='text' name='j_username'></td>
							<td>
						</tr>
						<td>&nbsp;</td>
						<tr>
							<td>PASSWORD:</td>
						<td><input type='password' name='j_password'></td>
						<td>
						</tr>

						<td>&nbsp;</td>
						<tr>
						<tr>
						
							<td>	<a href = "registerhere" class= "btn btn-primary">Register here </a></td>&nbsp;
								<td><input class="btn btn-success" type="submit"
								value="Login" /></td>
						</tr>
					</table>
					<hr>
				</center>
			</form>

		</div>
	</div>


</body>
</html>