<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>All Users</h3>
<!--  ol>

<c:forEach items="${profileListKey}" var = "u">
         <li>Id: ${u.profile_id}, Name: ${u.name}, Password: ${u.password}, Phone: ${u.phone}, DOB: ${u.dob}</li>
      </c:forEach>

</ol-->

<table >
<thead>
<tr>
<th>Profile id</th>
<th>Name</th>
<th>Password</th>
<th>Phone no</th>
<th>Date of birth</th>
</tr>
</thead>
<tbody>
	<c:forEach items="${profileListKey}" var = "u">
	<tr><td>${u.profile_id}</td>
	<td>${u.name}</td>
	<td>${u.password}</td>
	<td>${u.phone}</td>
	<td>${u.dob}</td>
	</tr>
	
      </c:forEach>
</tbody>



</table>
	
	
	

</body>
</html>