<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Mountain Gears</title>
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
<link rel = "stylesheet" href="WEB-INF/resources/NewFile.css">
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
			<a class="navbar-brand" rel="home" href="#">
						<img style="max-width: 150px; margin-top: -7px;"
							src="https://jimbierly.files.wordpress.com/2014/09/mountain-gear-logo2.png">
				</a>
			</div>
			<ul class="nav navbar-nav">
				<li ><a href="home">Home</a></li>
								<li> <a href="trackord">
					Track order 
					</a>
</li>
<li> <a href="contactusher">
					Contact Us 
					</a>
</li>
				<li class="dropdown">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">Explore Items<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><c:forEach items="${category}" var="category">
								<li><a href="<c:url value='categoryproduct?name=${category.category_name}' />">${category.category_name}</a> </li>
						</c:forEach></li>
						</ul></li>
			
 	
<c:if test="${loggedinuser == 'admin' }">
					
					<li> <a href="admin">
					Manage 
					</a>
</li>


		
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
<!-- src="https://www.skotcher.com/wall/1d8908a532825c0c617678a5f4bef189/camping-galaxy-milky-way-night-stars-tent.jpg" -->
	<div id="myCarousel" class="carousel slide">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>

		</ol>
		<div class="carousel-inner" style="width: 2625px; height: 555px;">
			<div class="item active">
			
				<img
					
					src="https://c1.staticflickr.com/4/3851/14350833587_a1f1d2d4c9_b.jpg"
					width="1800" height="555">
				<div class="container">
					<div class="carousel-caption"></div>
				</div>
			</div>
			<div class="item">
				<img
					src="http://img08.deviantart.net/b364/i/2012/127/1/1/mountaineering_panorama_by_zwoing-d47dw52.png"
					width="1400" height="555">
				<div class="container">
					<div class="carousel-caption"></div>
				</div>
			</div>
			<div class="item">
				<img
					src="http://img08.deviantart.net/fdaa/i/2012/030/7/6/traveling_by_zwoing-d498a25.jpg"
					width="1500" height="555">
				<div class="container">
					<div class="carousel-caption"></div>
				</div>
			</div>
		</div>

	

		<!-- Controls -->
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
			<i class="glyphicon glyphicon-chevron-left"></i>
		</a> <a class="right carousel-control" href="#myCarousel"
			data-slide="next"> <i class="glyphicon glyphicon-chevron-right"></i>
		</a>
	</div>
	<br>
	
				
					

					

	<div class="container-fluid bg-3 text-center">
		<h3>Backpacks For Mountain Climbing</h3>
		<br>
		<div class="row">
			<div class="col-sm-4">
				
				<img
					src="https://images-eu.ssl-images-amazon.com/images/I/41DD33GCpcL._AC_UL320_SR214,320_.jpg"
					class="img-responsive" width="300px", height="100px" alt="Image">
			</div>
			<div class="col-sm-4">
				
				<img
					src="https://images-eu.ssl-images-amazon.com/images/I/410eCZlFrTL._AC_UL320_SR214,320_.jpg"
					class="img-responsive" width="300px", height="100px" alt="Image">
			</div>
			<div class="col-sm-4">
				
				<img
					src="https://images-na.ssl-images-amazon.com/images/I/4119f757aUL._SY445_.jpg"
					class="img-responsive" width="300px", height="100px" alt="Image">
			</div>
		</div>
	</div>
	<center><a   class="btn btn-success" href="<c:url value='/categoryproduct?name=Packs/Luggages' />">View More</a><center>



	<div class="container-fluid bg-3 text-center">
		<h3>Sleepingbags</h3>
		<br>
		<div class="row">
			<div class="col-sm-4">
				
				<img src="http://www.v12outdoor.com/shopimages/products/normal/HyperLaminaFlame-HyperBlue.jpg"
					class="img-responsive"  width="300px", height="100px" alt="Bags">
			</div>
			<div class="col-sm-4">
				
				<img src="https://images-eu.ssl-images-amazon.com/images/I/41juWqptnfL._AC_UL320_SR214,320_.jpg"
					class="img-responsive"  width="300px", height="100px" alt="Bags">
			</div>
			<div class="col-sm-4">
			
				<img src="http://tesco.scene7.com/is/image/tesco/534-6909_PI_1000223MN?wid=493&ht=538"
					class="img-responsive" width="300px", height="100px" alt="Bags">
			</div>
		</div>
	</div>
	<br>
	<br>
	<center><a   class="btn btn-success" href="<c:url value='/categoryproduct?name=Sleeping Bags' />">View More</a><center>
	<h1>
	
	</h1>
	<div class="container-fluid bg-3 text-center">
		<h3>Ligth weight Tents</h3>
		<br>
		<div class="row">
			<div class="col-sm-4">
			
				<img
					src="https://images-na.ssl-images-amazon.com/images/I/31TCc6gdBEL._SY300_.jpg"
					class="img-responsive" width="300px", height="100px" alt="Image">
			</div>
			<div class="col-sm-4">
		
				<img
					src="http://tesco.scene7.com/is/image/tesco/359-1604_PI_1000223MN?wid=493&ht=538"
					class="img-responsive" width="300px", height="100px" alt="Image">
			</div>
			<div class="col-sm-4">
				
				<img
					src="http://tesco.scene7.com/is/image/tesco/237-5192_PI_1000223MN?wid=493&ht=538"
					class="img-responsive" width="300px", height="100px" alt="Image">
			</div>
		</div>
	</div>
<center><a   class="btn btn-success" href="<c:url value='/categoryproduct?name=Tents' />">View More</a><center>
	
	<h2>
		<center>Companies we are linked with</center>
	</h2>
	<div id="myCarousel" class="carousel slide text-center"
		data-ride="carousel">
		<!-- Indicators -->
		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<h4>
					<img
						src="http://sterlingmills.com/wp-content/uploads/2013/06/mountain-warehouse-logo-300x190.png"
					width="100" height="75"></span>
				</h4>
			</div>
			<div class="item">
				<h4>
					<img src="https://mark.trademarkia.com/services/logo.ashx?sid=85743848"
					width="100" height="75"></span>
				</h4>
			</div>
			<div class="item">
				<h4>
					<img
						src="http://static.wixstatic.com/media/398ec6_9e3adad5d8844eb59d8e9bb2465f2ed9.gif"
					width="100" height="75"></span>
				</h4>
			</div>
		</div>
		
		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	</div>
	
	
			
		<div class="container-fluid bg-grey">
  <h2 class="text-center">CONTACT</h2>
  <div class="row">
    <div class="col-sm-5">
      <p>Contact us and we'll get back to you within 24 hours.</p>
      <p><span class="glyphicon glyphicon-map-marker"></span> Chicago, US</p>
      <p><span class="glyphicon glyphicon-phone"></span> +00 1515151515</p>
      <p><span class="glyphicon glyphicon-envelope"></span> mountaingear@gmail.com</p>
    </div>
    <div class="col-sm-7">
      <div class="row">
        <div class="col-sm-6 form-group">
          <input class="form-control" id="name" name="name" placeholder="Name" type="text" required>
        </div>
        <div class="col-sm-6 form-group">
          <input class="form-control" id="email" name="email" placeholder="Email" type="email" required>
        </div>
      </div>
      <textarea class="form-control" id="comments" name="comments" placeholder="Comment" rows="5"></textarea><br>
      <div class="row">
        <div class="col-sm-12 form-group">
          <a class="btn btn-default pull-right" href="comment" type="submit">Send</button>
        </div>
      </div>
    </div>
  </div>
</div>




<div class="jumbotron">
      <div class="container">
		<div class="page-header ">
  			<h1 class="text-center">FAQ <br><small> You have questions,we have answers.</small></h1>
          <div class="well well-sm entete"></div>
		</div>
<br><br>
        
      
      <div class="panel-group" id="accordion">
  <div class="panel panel-default">
    <div class="panel-heading">
      <h4 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion" href="#collapseFour">
I have a question and need help advice for my next trip to Alaska. Can I contact you to get any help?        </a>
      </h4>
    </div>
    <div id="collapseFour" class="panel-collapse collapse ">
      <div class="panel-body">
Yes, we are reachable by email. Our preferred way of answering questions is through Email only. We will answer ASAP      </div>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading">
      <h4 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion" href="#collapseFive">
What should be I prepared for if I am planning my next trip to Pantagonia?        </a>
      </h4>
    </div>
    <div id="collapseFive" class="panel-collapse collapse">
      <div class="panel-body">
       Just be prepared for Cold And Wilderness. You can try some tents that are available on our website that are made to resist extreme climatic condition and makes you comfortable and feel like your own home. Enjoy Cheers!! </div>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading">
      <h4 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion" href="#collapseSix">
Do you offer replacement if I find package not worthy?        </a>
      </h4>
    </div>
    <div id="collapseSix" class="panel-collapse collapse">
      <div class="panel-body">
Yes, you can my friend! The product can be replaced within first week of purchase only..... </div>
    </div>
  </div>
      
      
      
</div>      
</div>
  </div>
	
	
	
	
</body>
</html>