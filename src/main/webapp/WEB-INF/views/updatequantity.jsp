<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
 <h2>Edit Quantity</h2>
  <form:form commandName="edit_cart" action="editquntity" method="post">
      <table class="table table-bordred table-striped">
       <tr>
           <td><form:label path="id" >CART ID:</form:label></td>
           <td>${cart_id}<form:input type="hidden" path="id" value="${cart_id}"/></td>
       </tr>
 		<tr>
           <td><form:label path="product_id" >CART ID:</form:label></td>
           <td>${Product_id}<form:input type="hidden" path="product_id" value="${Product_id}"/></td>
       </tr>
 		<tr>
           <td><form:label path="product_name">product_name:</form:label></td>
           <td>${product_name}<form:input type="hidden" path="product_name" value="${product_name}"/></td>
       </tr>
       <tr>
           <td><form:label path="user_name">user_name:</form:label></td>
           <td>${username}<form:input type="hidden" path="user_name" value="${username}"/></td>
       </tr>
      
       <tr>
           <td><form:label path="discount">Discount:</form:label></td>
           <td>${cart_discount}<form:input type="hidden" path="discount" value="${cart_discount}"/></td>
       </tr> 
       <tr>
       <tr>
           <td><form:label path="price">Price:</form:label></td>
           <td>${cart_price}<form:input type="hidden" path="price" value="${cart_price}"/></td>
       </tr> 
       <tr>
           <td><form:label path="quantity">Quantity:</form:label></td>
           <td><form:input path="quantity" value="${cart_quantity}"/></td>
       </tr>
      
       <tr>
       <tr>
        <td>&nbsp;</td>
         <td><button type="submit" class="btn btn-success" value="Edit">Save</button></td>
         </tr>
   </table> 
  </form:form>
</body>
</html>