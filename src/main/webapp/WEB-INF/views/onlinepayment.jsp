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




 <td><h3><i>Enter your Swiss Bank Account Details..... We advice to make online payment for high encrypted, fast and safe banking transaction.... Cheers!!!  </i></h3>
         
        





  <form:form  method="POST" commandName="save_shippingdetailsonline" action="validateonlinetransaction" >
      <table class="table-bordred table-striped">
            <tr>
           <td><form:label path="card_number">Enter the 16 digit number that is printed on your card:</form:label></td>
           <td><form:input path="card_number" /></td>
           <td><form:errors path="card_number" /></td>
       </tr>
       
       <tbody>
       <tr>
           <td><form:label path="cvv">Enter 3 digit CVV Number:</form:label></td>
           <td><form:input path="cvv" /></td>
           <td><form:errors path="cvv" /></td>
       </tr>
         <tr>
           <td><form:label path="password_for_card">Enter your banking password:</form:label></td>
           <td><form:input path="password_for_card" /></td>
           <td><form:errors path="password_for_card" /></td>
       </tr>
         <tr>
           <td><form:label path="captcha">Enter the captcha:</form:label></td>
           <td><form:input path="captcha" /></td>
           <td><form:errors path="captcha" /></td>
       </tr>
        <tr>
           <td><form:label path="user_of_card">Enter the User Name Written On Your Card:</form:label></td>
           <td><form:input path="user_of_card" /></td>
           <td><form:errors path="user_of_card" /></td>
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