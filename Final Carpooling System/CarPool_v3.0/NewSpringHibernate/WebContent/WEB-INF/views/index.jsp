<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CarPool</title>
</head>
<body>

	<h1>Register Here</h1>	
	<form action="registerUser" method="POST">
	Email : <input type="text" name="email">	
	firstname : <input type="text" name="firstname"/>
	lastname : <input type="text" name="lastname"/>
	password: <input type="text" name="password"/>
	phoneno : <input type="text" name="phoneno"/>
	<input type="submit" value="submit"/>
	</form>

	
<a href="loginPage">LogIn</a>	
<br>
<strong>${invalidEmail }</strong>
<br>
<a href="users"> All users </a>

</body>
</html>