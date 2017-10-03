<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trip Details</title>
</head>
<body>

<h1> Happy Journey</h1>

<%-- TripID : ${trip.tripID} <br>
StartPonint : ${trip.startPoint} <br>
Destination : ${trip.destPoint} <br>
DateTime : ${trip.dateTime} <br>
Spots Available : ${trip.spotsAvailable} <br>
Preferences : ${trip.preferences} --%>
<a href="profile"> Profile </a>

<form action="logout" method="POST">
	<input type="submit" value="logout" />
</form>

</body>
</html>