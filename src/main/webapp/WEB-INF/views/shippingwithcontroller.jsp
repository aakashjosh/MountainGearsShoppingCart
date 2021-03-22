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

<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicon.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<h2>Enter Your Shipping Details</h2>
  <form:form  method="POST" commandName="save_shippingdetails" action="saveshippingdetails" >
      <table class="table-bordred table-striped">
            <tr>
           <td><form:label path="send_to">Send To:</form:label></td>
           <td><form:input path="send_to" /></td>
           <td><form:errors path="send_to" /></td>
       </tr>
       
       <tbody>
       <tr>
           <td><form:label path="Address">Address:</form:label></td>
           <td><form:input path="Address" /></td>
           <td><form:errors path="Address" /></td>
       </tr>
        <tr>
           <td><form:label path="Email">Email:</form:label></td>
           <td><form:input path="Email" /></td>
           <td><form:errors path="Email" /></td>
       </tr>
        <tr>
           <td><form:label path="contact_number">contact Number:</form:label></td>
           <td><form:input path="contact_number" /></td>
           <td><form:errors path="contact_number" /></td>
       </tr>
     <tr>
    
   
   
   
   <td>&nbsp;</td>
         <td><button type="submit" class="btn btn-success">Save</button></td>
         </tr>
         </tbody>
   

<h1>
${orderid }</h1>
  </form:form>
  <br/>
</body>
</html>