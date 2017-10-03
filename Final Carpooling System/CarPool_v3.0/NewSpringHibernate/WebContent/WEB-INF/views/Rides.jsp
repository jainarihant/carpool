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
<form action="trips" method="post">
<c:if test="${!empty trips}">
<table class="table table-striped" align="center">

    <tbody>
    <c:forEach items="${trips}" var="trip">
      <tr>
        <td>Trip ID</td>
        <td>From</td>
      
        <td>To</td>
        
        <td>Date</td>
        
        <td>Spots reserved</td>
        
        <td>Preferences</td>
      </tr>
      <tr>
      	<td><input name="submittype" type="submit" value="${trip.tripID}"/></td>
      	<td><c:out value="${trip.startPoint }"></c:out></td>
      	<td><c:out value="${trip.destPoint }"></c:out></td>
      	<td><c:out value="${trip.dateTime }"></c:out></td>
      	<td><c:out value="${trip.spotsAvailable }"></c:out></td>
      	<td><c:out value="${trip.preferences}"></c:out></td>
      </tr>
      
      </c:forEach>
    </tbody>
  </table>
 
	<input type="submit" class="btn btn-info btn-md" value="Confirm"/>
	<a href="searchTrips" style="float:right; margin-left:5px;" class="btn">Back</a>

  </c:if>

</form>
  </div>
  </div>

<div class="modal fade" id="modal1" tabindex="-1">
<div class="modal-dialog">
<div class="modal-content">
        <div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">

			<form class="form-horizontal">
				<div class="row">
					<div class="col-sm-5 row">
						<label for="text">Enter number of spots to reserve</label>
					</div>
					<div class="col-sm-7">
						<input type="text" class="form-control"  placeholder="Enter spots to reserve" id="Licenno"/>
					</div>
						<br/>	`
				</div>
				
				
			</form>
		</div>
			<div class="modal-footer">
			<a href="Profile.html" class="btn btn-default" >Submit</a>
			</div>
		</div>
    </div>
</div>

<!-- Footer -->
<footer class="text-center">
  <a class="up-arrow" href="#myPage" data-toggle="tooltip" title="TO TOP">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a><br><br>
  <p> Copyright @ CarpoolNetworkTeam Project <a href="carpoolnet.com" data-toggle="tooltip" title="Visit CarNet">carpoolnet.com</a></p> 
</footer>


</body>
</html>
