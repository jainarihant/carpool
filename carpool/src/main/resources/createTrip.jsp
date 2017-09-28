<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Welcome to CarNet</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="css/custom.css">
  
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
        <li><a href="index.html">HOME</a></li>
        <li><a href="#band">Search For Ride <span class="glyphicon glyphicon-search"></a></li>
        <li><a href="#tour"> Post a Ride</a></li>
        <li><a href="#contact">Register</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">MORE
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Profile</a></li>
            <li><a href="#">About Us</a></li>
            <li><a href="#">Help ?</a></li> 
          </ul>
        </li>
      </ul>
    </div>
  </div>
  </div>
</nav>

<div class="container-fluid col-sm-12" style="margin-top:30px">
<div class="col-sm-6">
<h2>CREATE TRIP</h2>
  <form action="">
    <div class="form-group">
      <label for="startpoint">Start Point:</label>
      <input type="startpoint" class="form-control" id="startpoint" placeholder="Enter the start point" name="startpoint">
    </div>
  <div class="form-group">
      <label for="endpoint">End Point:</label>
      <input type="endpoint" class="form-control" id="endpoint" placeholder="Enter the end point" name="endpoint">
    </div>
  <div class="form-group">
      <label for="meetingpoints">Meeting Points:</label>
      <input type="meetingpoints" class="form-control" id="meetingpoints" placeholder="Enter the meeting points" name="meetingpoints">
    </div>
    <div class="form-group">
      <label for="datetime">Date Time:</label>
      <input type="datetime-local" class="form-control" id="datetime"  name="datetime">
    </div>
  <div class="form-group">
      <label for="frequency">Frequency:</label>
      <input type="number" class="form-control" id="frequency" placeholder="Enter the frequency of trips" name="frequency">
    </div>
  <div class="form-group">
      <label for="enddate">End Date:</label>
      <input type="date" class="form-control" id="enddate"  name="enddate">
    </div>
    <div class="form-group">
      <label for="spotsavailable">Spots Available:</label>
      <input type="number" class="form-control" id="spotsavailable" placeholder="Enter the spots available"  name="spotsavailable">
    </div>
    <div class="checkbox">
      <label><input type="checkbox" name="remember"> Remember me</label>
    </div>
	
	<div class="container">
  
 
  <button type="button" class="btn btn-info btn-md" data-toggle="modal" data-target="#myModal">My Cars</button>
		 <link href="C:\Users\Administrator\Desktop\miths project\CarRegister.html" rel="stylesheet" type="text/html">
  <button type="button" class="btn btn-info btn-md" data-toggle="modal" data-target="#myModal">Post Ride</button>
  <button type="button" class="btn btn-info btn-md" data-toggle="modal" data-target="#myModal">Cancel</button>
	
	
	
	
		</div>
    
  </form>
</div>


<div class="col-sm-6"><br><br>
<h3 style="text-align: center;"> GOOGLE MAPS</h3><br><br>
<div id="googleMap" style=""></div>
<script>
function myMap() {
var myCenter = new google.maps.LatLng(23.34,-34.456);
var mapProp = {center:myCenter, zoom:12, scrollwheel:false, draggable:false, mapTypeId:google.maps.MapTypeId.ROADMAP};
var map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
var marker = new google.maps.Marker({position:myCenter});
marker.setMap(map);
}
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBu-916DdpKAjTmJNIgngS6HL_kDIKU0aU&callback=myMap"></script>
 <!-- Set Div As your requirement -->
</div>

</div>

<div class="container" style="margin:20px">
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
function Validate()
{
var x=document.getElementById("SpotsAvailable").value;
var sp=document.getElementById("Startpoint").value;
var y=document.getElementById("Frequency").value;
var d=document.getElementById("DateTime").value;

var d1=document.getElementById("Enddate").value;

if(x>10||x<0)
{
  //document.getElementById("id1").innerHTML="INVALID INPUT";
  alert("INVALID INPUT");
  return false;
}
if(sp.match(/^[A-Za-z]+$/));
/*{
  //document.getElementById("id2").innerHTML="Invalid Startpoint";
  
  return false;
}*/
if(y<0)
{
  //document.getElementById("id6").innerHTML="INVALID INPUT";
    alert("INVALID frequency");

  return false;
}

if(d>d1)
{
  alert("Start date cant be greater than end date");
} 

</html>