<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Welcome to Login Success Page</h3>
	<p>${userKey.userId} Login Successful</p>
	<!--  p>Id: ${userKey.userId}, Name : ${userKey.username}, Phone: ${userKey.phone}</p-->
	<form action="UpdatePhone" method="post">
	Phone no<input type="phone" name="updatephone">
	<input type="submit" value="Update Phone no">
	</form>
	
	<form action="UpdatePassword" method="post">
	Password<input type="text" name="updatepwd">
	<input type="submit" value="Update Password">
	</form>
	
	<form action="Search" method="post">
	User ID <input type="text" name="idsearch">
	<input type="submit" value="Search">
	</form>
	
	<form action="FetchAll" method="post">
	<input type="submit" value="FetchAll">
	</form>
	
</body>
</html>