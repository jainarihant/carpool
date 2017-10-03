<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Welcome to CarNet</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
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

<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">

<!-- Navigation Bar section -->
<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>                        
				</button>
				<a class="navbar-brand" href="#">CarPool Network</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
			  <ul class="nav navbar-nav navbar-right">
				<li><a href="profile">HOME</a></li>
				<li><a href="logout">Logout</a></li>
			  </ul>
			</div>
		</div>
	</nav>
<div class="container-fluid" style="margin-top:80px; margin-bottom:20px;">
<div class="row">
		<h1 align="center">Rides available</h1>
		<br/>
</div>

<div class="col-sm-3"></div>
<div class="col-sm-5">
<form action="bookSeat" method="post">

<table class="table table-striped" align="center">

    <tbody>

      <tr>
        <td>Trip ID</td>
        <td>From</td>
      
        <td>To</td>
        
        <td>Date</td>
        
        <td>Spots Available</td>
        
        <td>Preferences</td>
      </tr>
      <tr>
      	<td>${trip.tripID}</td>
      	<td>${trip.startPoint }</td>
      	<td>${trip.destPoint}</td>
      	<td>${trip.dateTime} </td>
      	<td>${trip.spotsAvailable }</td>
      	<td>${trip.preferences}</td>
      </tr>
      

    </tbody>
  </table>
 	<input type="hidden" name="selectedTrip" value="${selectedTripId }"/>
 	Enter no. of Spots : <input type="number" name="spots" />
	<input type="submit" class="btn btn-info btn-md" value="BookSeat"/>
	<a href="searchTrips" style="float:right; margin-left:5px;" class="btn">Back</a>
	

</form>
${seats}
  </div>
  </div>
  <script>
	function booked(){
	alert("Booked.");
		}
  </script>


<!-- Footer -->
<footer class="text-center">
  <a class="up-arrow" href="#myPage" data-toggle="tooltip" title="TO TOP">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a><br><br>
  <p> Copyright @ CarpoolNetworkTeam Project <a href="carpoolnet.com" data-toggle="tooltip" title="Visit CarNet">carpoolnet.com</a></p> 
</footer>


</body>
</html>
