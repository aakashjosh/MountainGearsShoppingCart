<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html>
<head>
<title>Manage Category</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicon.css" rel="stylesheet">

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

<h2>Create New Category</h2>
  <form:form  method="POST" commandName="save_category" action="savecategory" >
      <table class="table-bordred table-striped">
            <tr>
           <td><form:label path="category_id">Category ID:</form:label></td>
           <td><form:input path="category_id" /></td>
           <td><form:errors path="category_id" /></td>
       </tr>
       
       <tbody>
       <tr>
           <td><form:label path="category_name">Category Name:</form:label></td>
           <td><form:input path="category_name" /></td>
           <td><form:errors path="category_name" /></td>
       </tr>
       
       <tr>
       <tr>
        <td>&nbsp;</td>
         <td><button type="submit" class="btn btn-success">Save</button></td>
         </tr>
         </tbody>
   </table> 
  </form:form>
  <br/>

  <table class="table" align="center">
      <thead>
        <tr>
          <th>Category Id</th>
          <th>Category Name</th>
          <th>Edit Category</th>
          <th>Delete Category</th>
        </tr>
      </thead>
      <tbody>
		<c:forEach items="${category}" var="category">
			<tr>
				<td col width="50%" >${category.category_id}</td>
				<td style="width:70%">${category.category_name}</td>
				<td><a class= "btn btn-primary" href="<c:url value='/updatecategory?id=${category.category_id}' />">Edit</a></td>
				<td><a class= "btn btn-danger" href="<c:url value='/deletecategory/${category.category_id}' />">Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>
    </table>	 


</body>
</html>