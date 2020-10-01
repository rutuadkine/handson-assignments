<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "RegisterProfile" method = "get">
		<label>
			User Id <input type = "text" name = "id">
		</label>
		<label>
			Username <input type = "text" name = "name">
		</label>
		<br />
		<label>
			Password <input type = "password" name = "pass">
		</label>
		<br />
		<label>
			Phone no <input type = "phone" name = "phone">
		</label>
		<br/>
		<label>
			Date of birth<input type = "text" name = "dob">
		</label>
		<input type = "submit" value = "Register">
		
	</form>

</body>
</html>