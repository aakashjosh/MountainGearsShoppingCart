<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

<title>Insert title here</title>
</head>
<body>
<h2>Add Query</h2>
  <form:form  method="POST" commandName="save_maildetails" action="savemaildetails" >
      <table class="table-bordred table-striped">
            <tr>
           <td><form:label path="emailid">Email Id:</form:label></td>
           <td><form:input path="emailid" /></td>
           <td><form:errors path="emailid" /></td>
       </tr>
       
       <tbody>
       <tr>
           <td><form:label path="subject">Subject:</form:label></td>
           <td><form:input path="subject" /></td>
           <td><form:errors path="subject" /></td>
       </tr>
         <tr>
           <td><form:label path="querytext">Query:</form:label></td>
           <td><form:input path="querytext" /></td>
           <td><form:errors path="querytext" /></td>
       </tr>
       <tr>
       <tr>
        <td>&nbsp;</td>
         <td><button type="submit" class="btn btn-success">Save</button></td>
         </tr>
         </tbody>
   </table> 
  </form:form>
</body>
</html>