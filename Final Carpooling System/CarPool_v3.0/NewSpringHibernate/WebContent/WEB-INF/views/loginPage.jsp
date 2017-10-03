<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User LogIn</title>
</head>
<body>

<h1>Login Here</h1>
	<form action="userLogin" method="POST">
		Username : <input type="text" name="username" placeholder="Email" />
		Password : <input type="password" name="password" placeholder="password" />
		
		<input type="submit" value="Login" />
	</form>

${invalidEmail}
${user}

<a href="index.jsp"> IndexPage </a>
</body>
</html>