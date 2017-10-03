<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add A New Car</title>
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
		</div>
		<br><br><div class="col-sm-12"></div>
<h1> Adding a Car for Driver </h1>
Driver Licence No : ${driver.licenceNO} <br> <br>
Licence Issue Date : ${driver.lic_issueDate} <br> <br>
Licence Expiry Date : ${driver.lic_expiryDate} <br> <br>

<div class="containr">
<div class="col-sm-6" style="width:50%;">
<form method="POST" action="registerCar">
	   		<table class="table table-striped">
			    <tr>
			        <td>Plate Number:</td>
			        <td><input type="text" name="plateNo"></td>
			    </tr>
			    <tr>
					<td>Ac/Nonac:</td>
					<td><input type="text" name="AC/nonAc" placeholder="0=AC/1=Non_AC"></td>
			    </tr>
			    <tr>
					<td>Car Color:</td>
					<td><input type="text" name="carColor"></td>
			    </tr>
			    <tr>
					<td>Car Type:</td>
					<td><input type="text" name="carType"></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		</form>
		
		</div>
		</div>
		
</body>
</html>