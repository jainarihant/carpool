<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Employees</title>
</head>
<body>
<h1>List Employees</h1>
<h3><a href="add.html">Add More Employee</a></h3>

<c:if test="${!empty users}">
	<table align="left" border="1">
		<tr>
			<th>User ID</th>
			<th>Email</th>
			<th>Name</th>
			<th>Contact</th>
			<th>Username</th>
		</tr>

		<c:forEach items="${users}" var="user">
			<tr>
				<td><c:out value="${user.userID}"/></td>
				<td><c:out value="${user.email}"/></td>
				<td><c:out value="${user.firstname} ${user.lastname}"/></td>
				<td><c:out value="${user.phoneNo}"/></td>
				<td><c:out value="${user.username}"/></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>