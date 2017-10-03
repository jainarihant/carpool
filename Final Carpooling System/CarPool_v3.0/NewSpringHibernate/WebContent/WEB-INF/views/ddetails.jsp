<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DriverDetails</title>
</head>
<body>

<h1> User Details</h1>
<table>
	<tr>
		<td> UserID : </td> <td> ${user.userID}</td>
	</tr>
	<tr>
		<td>Name : </td> <td>${user.firstname} ${user.lastname}</td>
	</tr>
	<tr>
		<td> Email : </td> <td> ${user.email}</td>
	</tr>
	<tr>
		<td> Contact : </td> <td> ${user.phoneNo}</td>
	</tr>
</table>

<form method="POST" action="addDDetails">
	   		<table>
			    <tr>
			        <td>License Number:</td>
			        <td><input type="text" name="licenseNumber"></td>
			    </tr>
			    <tr>
					<td>License Issue Date:</td>
					<td><input type="text" name="licenseIssue" placeholder="YYYY/MM/DD" /></td>
			    </tr>
			    <tr>
					<td>License Expiry date:</td>
					<td><input type="text" name="licenseExpiry" placeholder="YYYY/MM/DD" /></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		</form>
		
		
		<br><br>
<form action="logout" method="POST">
	<input type="submit" value="logout" />
</form>
</body>

</html>