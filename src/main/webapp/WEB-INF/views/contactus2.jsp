<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="sendemailtoclient">
  User Name:<br>
  <input type="text" name="cname" >
  <br>
  Email:<br>
  <input type="text" name="email" >
  <br>
   Subject:<br>
  <input type="text" name="subject" >
  <br>
   Message:<br>
  <input type="text" name="message" >
  <br>
  <input type="submit" value="Submit">
</form>
</body>
</html>