<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<link type="text/css" rel="stylesheet" href="src/main/webapp/WEB-INF/resources/css/sample.css" />
<title>Contact Us</title>
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
									href="<c:url value='categoryproduct?name=${category.category_name}' />">${category.category_name}</a>
								</li>
						</c:forEach></li>
						</ul></li>

			</ul>
 <ul>		
<c:if test="${isadmin == true}">
					
					<li> <a id ="adminpage1" href="adminpag">
					Manage 
					</a>
					
					
					
					</c:if>
					</ul>
	<ul class="nav nav navbar-nav navbar-right">
	<c:choose>
				<c:when test="${empty loggedinuser or loggedout==true}">
					<li>
						<a id="SIGN IN" href="securelogin"><span class="glyphicon glyphicon-log-in"></span>&nbsp;&nbsp;SIGN IN</a>
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
<!-- -------------------------------------------------------------------------------------------------- -->

<img src="http://ecx.images-amazon.com/images/I/81LmkUY3lLL._SL1500_.jpg" style="height: 400px; width: 1355px;">
<center>
		<h1 class="header1 paddingtop">Welcome to Mountain Gear</h1>
	
	</center>
	<hr>
	<!-- Start Contact 1 -->
    <section class="content-block contact-1">
		<div class="container text-center">
			
			<div class="col-sm-10 col-sm-offset-1">
				
				<div class="underlined-title">
					<div class="editContent">
		        		<h1>Get in Touch</h1>
					</div>
		        	<hr>
		        	<div class="editContent">
		        		<h2>We would be glad to talk about your queries..</h2>
					</div>
	        	</div>
				<div class="editContent">
				<div>		<span class="fa fa-map-marker"></span>162 Queen's Mews, Covent Garden, New Zealand, LO2 4ON</div>
						<div><span class="fa fa-phone"></span>+49 (0) 1234 1238</div>
					<div>	<span class="fa fa-envelope"></span><a href="/">mountaingear.com</a></div>
				</div>
				
				<div class="form-container">
					<form class="forms" action="contactus" method="post">
						<div class="row">
							<div class="col-sm-4">
								<div class="form-group">
									<input type="text" value="" placeholder="Name" class="form-control">
								</div>
							</div>
							<div class="col-sm-4">
								<div class="form-group">
									<input type="text" value="" placeholder="Email" class="form-control">
								</div>
							</div>
							<div class="col-sm-4">
								<div class="form-group">
									<input type="text" value="" placeholder="Phone" class="form-control">
								</div>
							</div>
						</div><!-- /.row -->
						<div class="form-group">
							<textarea class="form-control" rows="3" placeholder="Message" id="textArea"></textarea>
							<div class="editContent">
								<p class="small muted">Once we receive your message we will respond as soon as possible.</p>
							</div>
						</div>
						<div class="form-group">
							<a href="#" class="btn btn-primary">Send</a>
						</div>
					</form>
				</div><!-- /.form-container -->
			
			</div><!-- /.col-sm-10 -->
				
		</div><!-- /.container -->
	</section><!-- /.content-block -->
	<!--// END Contact 1 -->
	
</body>
</html>