<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
	<head>
		<title>CarPool</title>
			<meta charset="utf-8">
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
			<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
			<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
			<style type="text/css">
				#map{
				height:300%;
				width:100%;
				position:absolute;
				}
				  
			</style>
			
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
				<li><a href="Profile.html">HOME</a></li>
				<li><a href="#logout">Logout</a></li>
			  </ul>
			</div>
		</div>
	</nav>
<div class="container-fluid col-sm-12" style="margin-top:30px">
<div class="col-sm-6">

<h1>CREATE TRIP</h1>
<div class="col-sm-12">
<div class="col-sm-6">
	<form action="createNewTrip" method="POST">
		<div class="form-group">
			

		  <label for="startpoint">Start Point:</label>
		  <input type="text" class="form-control" style="width:250px" id="startpoint" placeholder="Enter the start point" name="startPoint">
		</div>
		<div class="form-group">
		
			<label for="endpoint">End Point:</label>
			<input type="text" class="form-control" style="width:250px" id="endpoint" placeholder="Enter the end point" name="endPoint">

		</div>
		</div>
		<div class="col-sm-6">
			
		<div class="form-group">
				

			<label for="meetingpoints">Meeting Point:</label>
			<input type="text" class="form-control" style="width:250px" id="meetingpoints" placeholder="Enter the meeting points" name="meetingPoint">
		</div>
		
		<button type="button"  class="btn btn-info btn-sm" style="margin-right:1000" onclick="putMarkers()" >Show On Maps</button>
		</div>
		</div>
		
		<div class="col-sm-12">
		<div class="col-sm-6">
		
		<div class="form-group">
		  <label for="datetime">StartDate:</label>
		  <input type="text" class="form-control" style="width:250px" id="datetime"  placeholder="yyyy-mm-dd  hh:mm:ss" name="startDate">
		</div>
		<div class="form-group">
		<div class="">
		  <label for="frequency">Frequency : </label><br>
		  <input type="radio" name="freq" /> OneTime<br>
		  <input type="radio" name="freq" /> Daily<br>
		  <input type="radio" name="freq" /> Weekly
		</div>
		</div>
		<div class="form-group">
		  <label for="date">End Date:</label>
		  <input type="text" class="form-control" style="width:250px" placeholder="yyyy-mm-dd HH:MM:SS" id="enddate"  name="endDate">
		</div>
		<div class="form-group">
		  <label for="spotsavailable">Spots Available:</label>
		  <input type="number" class="form-control" style="width:250px" id="spotsavailable" placeholder="Enter the spots available"  name="spotsAvailable">
		</div>
		
		<div class="checkbox">
			
			<label for="checkbox">Preferences:</label>
			<div class="col-sm-12">
			<div class="col-sm-7">
			<label><input type="checkbox" name="remember" > AC/Non-AC</label><br/>
			<label><input type="checkbox" name="remember"> Smoking</label><br/>
			<label><input type="checkbox" name="remember"> Luggage</label>
			</div>
			</div>
		</div>

		<div class="container">
	  
	 
		
		<input type="submit" class="btn btn-info btn-md" value="Post Ride" />
		<input type="reset" class="btn btn-info btn-md"value="Reset"/>
			
		</div>
		</div>
		</div>
	</form>
</div>


<div class="col-sm-6"><br><br>
<h3 style="text-align: center;"> GOOGLE MAPS</h3><br><br>
<div id="map"></div>
    <script>
      var map;
      function initMap() {
        // Constructor creates a new map - only center and zoom are required.
        geocoder = new google.maps.Geocoder();
        var latlng = new google.maps.LatLng(12.973922, 77.569183);
        map = new google.maps.Map(document.getElementById('map'), {
          center: latlng,
          zoom: 13
        });
      }
     function putMarkers(){
     	codeAddress();
     	codeDestination();
     	codeMeeting();
     }
    function codeAddress() {
    var address = document.getElementById('startpoint').value;
    geocoder.geocode( { 'address': address}, function(results, status) {
      if (status == google.maps.GeocoderStatus.OK) {
        map.setCenter(results[0].geometry.location);
        var marker = new google.maps.Marker({
            map: map,
            position: results[0].geometry.location
        });
      } else {
        alert('Geocode was not successful for the following reason: ' + status);
      }
    });
  }
  function codeMeeting() {
    var address = document.getElementById('meetingpoints').value;
    geocoder.geocode( { 'address': address}, function(results, status) {
      if (status == google.maps.GeocoderStatus.OK) {
        map.setCenter(results[0].geometry.location);
        var marker = new google.maps.Marker({
            map: map,
            position: results[0].geometry.location
        });
      } else {
        alert('Geocode was not successful for the following reason: ' + status);
      }
    });
  }
   function codeDestination() {
    var address = document.getElementById('endpoint').value;
    geocoder.geocode( { 'address': address}, function(results, status) {
      if (status == google.maps.GeocoderStatus.OK) {
        map.setCenter(results[0].geometry.location);
        var marker = new google.maps.Marker({
            map: map,
            position: results[0].geometry.location
        });
      } else {
        alert('Geocode was not successful for the following reason: ' + status);
      }
    });
  }
    </script>

</div>
		

</div>






        </div>
    <div class="modal-footer">
		
		
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


<script type="text/javascript">
function enddate(input){
var validformat=/^\d{4}\/\d{2}\/\d{2}$/ //Basic check for format validity
var returnval=false
if (!validformat.test(input.value))
alert("Invalid Date Format. Please correct and submit again.")
else{ //Detailed check for valid date ranges
var yearfield=input.value.split("-")[0]
var monthfield=input.value.split("-")[1]
var dayfield=input.value.split("-")[2]
var dayobj = new Date(yearfield, monthfield-1, dayfield)
if ((dayobj.getMonth()+1!=monthfield)||(dayobj.getDate()!=dayfield)||(dayobj.getFullYear()!=yearfield))
alert("Invalid Day, Month, or Year range detected. Please correct and submit again.")
else {
 alert ('Correct date');
returnval=true }
}
if (returnval==false) input.select()
return returnval
}
 
</script>	

<script async defer
        src=
        "https://maps.googleapis.com/maps/api/js?libraries=geometry,drawing&key=AIzaSyCjOCV-6ZOrWQgYCh_hSYsANT2hcDFkZME&v=3&callback=initMap">

    </script>
</html>


