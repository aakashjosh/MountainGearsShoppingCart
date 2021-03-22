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
	
	<title>Manage product</title>
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

	
	<center>

		<br /> <br />
		<div class="container" style='background-color: White'>
			<div class="wrapper">
				<h3 class="form-signin-heading" style='color: Grey'>ADD
					PRODUCT</h3>
				<hr>
				<form:form method="POST" commandName="save_product"
					action="saveproduct" enctype="multipart/form-data">
					<table "table table-bordred table-striped">
						<tr>
							<td><form:label path="product_id">Product ID:</form:label></td>
							<td><form:input path="product_id" /></td>
							<td><form:errors path="product_id" /></td>
						</tr>
						<td>&nbsp;</td>
						<tr>
							<td><form:label path="product_name">Product Name:</form:label></td>
							<td><form:input path="product_name" /></td>
							<td><form:errors path="product_name" /></td>
						</tr>
						<td>&nbsp;</td>

              <tr>
				<td><form:label path="category">Category:</form:label></td>
				<td><select name="category">
						<c:forEach items="${category}" var="category">
    					<option value="${category.category_name}">${category.category_name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>				<td>&nbsp;</td>
						<tr>
				<td><form:label path="supplier_id">Supplier:</form:label></td>
				<td><select name="supplier_id">
						<c:forEach items="${supplier}" var="supplier">
    					<option value="${supplier.supplier_name}">${supplier.supplier_name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>	
						<td>&nbsp;</td>
						<tr>
							<td><form:label path="product_description">Description:</form:label></td>
							<td><form:input path="product_description" /></td>
							<td><form:errors path="product_description" /></td>
						</tr>
						<td>&nbsp;</td>
						<tr>
							<td><form:label path="product_price">Price:</form:label></td>
							<td><form:input path="product_price" /></td>
							<td><form:errors path="product_price" /></td>
						</tr>
						<td>&nbsp;</td>
						<tr>
							<td><form:label path="product_discount">Discount:</form:label></td>
							<td><form:input path="product_discount" /></td>
							<td><form:errors path="product_discount" /></td>
						</tr>
						<td>&nbsp;</td>
						<tr>
							<td><form:label path="product_file">Image: </form:label></td>
							<td><input type="file" name="product_file" /></td>
							<td><form:errors path="product_file" /></td>
						</tr>
						<tr>
						<td>${path }</td>
						</tr>
						<td>&nbsp;</td>
						<tr>
							<td>&nbsp;</td>
							<td><input class="btn btn-success" type="submit"
								value="SAVE PRODUCT" /></td>
						</tr>
						<td>&nbsp;</td>
					</table>
				</form:form>
				<hr>
				<br />
				<table class="table" align="center">
					<thead>
						<tr>
							<th>Product ID</th>
							<th>Product Name</th>
							<th>Category</th>
							<th>Supplier</th>
							<th>Description</th>
							<th>Price</th>
							<th>Discount</th>
							<th>Image</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${product}" var="product">
							<tr>
								<td>${product.product_id}</td>
								<td>${product.product_name}</td>
								<td>${product.category}</td>
								<td>${product.supplier_id}</td>
								<td>${product.product_description}</td>
								<td>${product.product_price}</td>
								<td>${product.product_discount}</td>
								<td><img src="<c:out value='${product.product_image}' />" width="150px"
									height="150px"></td> 

								<td><a class= "btn btn-primary" 
									href="<c:url value='/updateproduct?id=${product.product_id}' />">Edit</a></td>
								<td><a class= "btn btn-danger" 
									href="<c:url value='/deleteproduct/${product.product_id}' />">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</center>

</body>
</html>