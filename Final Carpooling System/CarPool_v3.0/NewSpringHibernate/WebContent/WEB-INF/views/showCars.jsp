<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> MyCars </title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
   		<%@include file="css/custom.css" %>
   </style>
  
  	<script>
		<%@include file="js/angular/angular.min.js" %>
		<%@include file="js/angular/app.js" %>
		<%@include file="js/angular/login_controller.js" %>
  	</script>
</head>
<body>
<div class="row">
			<nav class="navbar navbar-default navbar-fixed-top">
				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>                        
						</button>
						<a class="navbar-brand" href="pratik">CarPool Network</a>
					</div>
					<div class="collapse navbar-collapse" id="myNavbar" >
						<ul class="nav navbar-nav navbar-right" >
							<li><a href="logout">Logout</a></li>
							
						</ul>
					</div>
				</div>
			</nav>
		</div><br><br>
		<div class="col-sm-12"></div>
<h1> Registered Driver Details </h1>
Driver Licence No : ${driver.licenceNO} <br> <br>
Licence Issue Date : ${driver.lic_issueDate} <br> <br>
Licence Expiry Date : ${driver.lic_expiryDate} 

<div class="container">
<c:if test="${!empty cars}">
	<table align="left" border="1" class="table table-bordered">
		<tr>
			<th>Car ID</th>
			<th>PlateNo</th>
			<th>Color</th>
			<th>Type</th>
			<th>AC/Non_AC</th>
		</tr>

		<c:forEach items="${cars}" var="car">
			<tr>
				<td><c:out value="${car.carID}"/></td>
				<td><c:out value="${car.plateNO}"/></td>
				<td><c:out value="${car.color}"/></td>
				<td><c:out value="${car.type}"/></td>
				<td><c:out value="${car.AC_Non_AC}"/></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</div>
<a href="checkCars"> Show My Cars</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="addCar" > Add New Car </a> <br><br>


<form action="createTrip" method="POST">
	Enter CarID for Posting a Trip : <input type="text" name="carID" placeholder="CarID" />
	<input type="submit" value="Done" />
</form>
${noCars}



<form action="logout" method="POST">
	<input type="submit" value="logout" />
</form>
</body>
</html>