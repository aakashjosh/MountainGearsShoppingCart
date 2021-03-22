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
	<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Product</title>
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
	
  <div class="container" style='background-color: White'>	
	<div class="wrapper">
  <h3 class="form-signin-heading" style='color:Grey'>EDIT Product</h3>
  <hr>
  <form:form commandName="edit_product" action="editproduct" method="POST" enctype="multipart/form-data">
      <table>
       <tr>
           <td><form:label path="product_id">Product ID:</form:label></td>
           <td><form:input path="product_id" value="${product.getProduct_id()}"/></td>
       </tr><td>&nbsp;</td>
       <tr>
           <td><form:label path="product_name">Product Name:</form:label></td>
           <td><form:input path="product_name" value="${product.getProduct_name()}"/></td>
       </tr> <td>&nbsp;</td>
       <tr>
           <td><form:label path="category">Category ID:</form:label></td>
           <td><form:input path="category" value="${product.getCategory()}"/></td>
       </tr> <td>&nbsp;</td>
       <tr>
           <td><form:label path="supplier_id">Supplier ID:</form:label></td>
           <td><form:input path="supplier_id" value="${product.getSupplier_id()}"/></td>
       </tr> <td>&nbsp;</td>
       <tr>
           <td><form:label path="product_description">Description:</form:label></td>
           <td><form:input path="product_description" value="${product.getProduct_description()}"/></td>
       </tr> <td>&nbsp;</td>
       <tr>
           <td><form:label path="product_price">Price:</form:label></td>
           <td><form:input path="product_price" value="${product.getProduct_price()}"/></td>
       </tr> <td>&nbsp;</td>
       <tr>
           <td><form:label path="product_discount">Discount:</form:label></td>
           <td><form:input path="product_discount" value="${product.getProduct_discount()}"/></td>
       </tr> <td>&nbsp;</td>
       <tr>
          <td><form:label path="product_file">Image:</form:label></td>
           <td><input type="file" name="product_file" /></td>
           <td><img src="${product.getProduct_image()}" height="150px" width="150px"></td>
       </tr> <td>&nbsp;</td>
       <tr>
       <tr>
        <td>&nbsp;</td>
         <td><input class="btn btn-primary" type="submit" value="Edit Product"/></td>
         </tr>
         <td>&nbsp;</td>
   </table> 
  </form:form>
  <br/>
 </center>

</body>
</html>