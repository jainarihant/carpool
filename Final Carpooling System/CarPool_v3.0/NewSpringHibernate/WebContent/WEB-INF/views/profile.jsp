<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>CarPool</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
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
		<style>
			/* Set height of the grid so .sidenav can be 100% (adjust if needed) */
			.row.content {height: 400px}

			/* Set gray background color and 100% height */
			.sidenav {
			background-color:#383435;
			height:420px;
			font-size:15px;
			margin-top:-1.5%;
			}
			
			#sidenav{
			color:white;
			}
			
			
			/* On small screens, set height to 'auto' for sidenav and grid */
			@media screen and (max-width: 767px) {
			.sidenav {
			height: 100%;
			padding: 15px;
			}
			.row.content {height: auto;} 
			}
			
			body{
			overflow-y: hidden;
			overflow-x:; 
			}
		</style>
		<script>
			function edit_profile(){
					document.getElementById("name").readOnly = false;
					document.getElementById("email").readOnly = false;
					document.getElementById("contact").readOnly = false;
					document.getElementById("update_profile").disabled = false;
					}
					
					
			function close_profile(){
					document.getElementById("name").readOnly = true;
					document.getElementById("email").readOnly = true;
					document.getElementById("contact").readOnly = true;
					document.getElementById("update_profile").disabled = true;
					}
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
		<br><br>

		<div class="content">
			<div class="row" id="profile">
				<h3 class="headline"style="text-align:center"> Profile</h3> 
				<hr/>
			</div>
		</div>
		<div class="container-fluid">
			<div class="row content">
				<div class="container-fluid col-sm-12">
					<div class="container-fluid col-sm-2 sidenav" >
						<ul class="nav nav-stacked" >
							<li class="active"><a href="pratik" id="sidenav">Home</a></li>
<!-- 							<li><a href="checkCars" id="sidenav">My car</a></li> -->
<!-- 							<li><a id="sidenav" data-toggle="modal" data-target="#modal2">AddCar</a></li> -->
							<li><a href="bookingsByMe" id="sidenav" >Bookings</a></li>
							<li><a href="tripsByMe" id="sidenav" >Trips</a></li>

							
						</ul>
						<!-- break -->
					</div>
			<form action="updateProfile" method="POST">
					<div class="col-sm-1"></div>
					<div class="container-fluid col-sm-9">
						<div class="row">
							<div class="col-sm-2 row">
								<label for="text">Customer Name:</label>
							</div>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="name" value="${user.firstname} ${user.lastname}" readonly />
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-sm-2 row">
								<label for="text">Email ID:</label>
							</div>
							<div class="col-sm-7">
								<input type="email" class="form-control" id="email" value="${user.email}" readonly />
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-sm-2 row">
								<label for="text">Contact:</label>
							</div>
							<div class="col-sm-7">	
								<input type="text" class="form-control" id="contact" value="${user.phoneNo }" readonly />
							</div>
						</div>
						<br>
						<div class="container-fluid col-sm-9">
							<div class="col-sm-5"></div>
							<div class="col-sm-4 form-group" style="float:right"> 
							<input type="submit" class="btn btn-info" id="update_profile" value="Save" disabled onclick="close_profile()"/>
								<!-- <button type="submit" class="btn btn-info" disabled href="updateProfile"  id="update_profile">Save</button> -->
								<button type="button" class="btn btn-info" onclick="edit_profile()">Edit profile</button>
							</div>
						</div>
						</form>
						<br><br>
						<hr>
						<div class="container-fluid col-sm-9">
							<div class="container-fluid col-sm-1"></div>
							<div class="col-sm-4">
							<form action="checkDDetail" method="post"> 
								<input type="submit" class="btn btn btn-default btn-lg btn-block text-lg-center custom"  
								 id="driver" name="driver" value="Post a trip"/>
								</form>
							</div>
							<div class="col-sm-4">
							<form action="checkPDetail" method="POST">
								<input type="submit"  class="btn btn btn-default btn-lg btn-block text-lg-center custom" 
								 value="Search a trip"/>
							</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<a href="abc"> A</a>
		
		<!-- [ Modal #1 ] -->
  <div class="modal fade" id="modal1" tabindex="-1">
    <div class="modal-dialog">
     
      
 
    
      <!-- Modal content for My cars-->
    <div class="modal-content">
        <div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">&times;</button>
			<h4 class="modal-title"> Car Details</h4>
        </div>
        <div class="modal-body">
          
        <table class="table table-bordered">
    <thead>
	<tr>
		<th>Car ID</th>
		<th>Plate No</th>
        <th>Driver No</th>
    </tr>
    </thead>
    <tbody>
	
	
	<tr>
		<td></td>
        <td></td>
        <td></td>
    </tr>
	
	<tr>
        <td></td>
        <td></td>
        <td></td>
    </tr>
	<tr>
			<td></td>
			<td></td>
			<td></td>
    </tr>

</tbody>      
</table>

        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Submit</button>
        </div>
      </div>
      
    </div>
  </div>
		
			  <!-- [ Modal #2 ] -->
   <form action="registerCar" method="post">
	<div class="modal fade" id="modal2" tabindex="-1">
		<div class="modal-dialog">
		<div class="modal-content">
		<button type="button" class="close" data-dismiss="modal"><i class="icon-xs-o-md"></i></button>
		<div class="modal-header">
			<h4 class="modal-title">Register car</h4>
		</div>
		
		<div class="modal-body">
		<div class="form-group">
		  <label for="Plate.No">Plate No.:</label>
		  <input type="text" class="form-control" id="Plate.No" placeholder="Enter your Plate Number" name="plateNo" maxsize="8">
		</div>
    
		<div class="form-group">
			<label for="Color"> Color: </label>
			<input type="Color" class="form control" id="Color" placeholder="Choose color" name="carColor">
		</div>
	
		<div class="form-group">
			<label for="Preferences"> Ac/Non Ac </label>
		<div>
			<input type="text" class="form control" id="ac/nonac" placeholder="0 or 1" name="AC/nonAC">
		</div>
		</div>
	
		<div class="form-group">
			<label for="Type"> Type: </label>
				
				<div class="dropdown">
					<select class="selectpicker" name="carType">
						<option>Sedan</option>
						<option>SUV</option>
						<option>Mini</option>
						<option>Micro</option>
					</select>

				</div>
		  
        </div>
		
		
			<div class="modal-footer">
			  <input type="submit" class="btn btn-default" data-dismiss="modal" value ="Submit"></input>
			</div>
		</div>
		</div>
	</div>
	</div>
	</form>
	<!-- Modal 3 -->
<div id="myModal3" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Bookings</h4>
      </div>
      <div class="modal-body">
        <table class="table table-bordered">
    <thead>
      <tr>
        <th>Source</th>
        <th>Destination</th>
        <th>Date Time</th>
        <th>Expected Time</th>
        <th>Frequency</th>
        <th>No.ofseats</th>
      </tr>
    </thead>
    
  </table>
		
		
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>

<!--MODAL 4-->
	<div class="modal fade" id="modal4" tabindex="-1">
<div class="modal-dialog">
<div class="modal-content">
        <div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">&times;</button>
			<h4 class="modal-title">Driver Details</h4>
        </div>
        <div class="modal-body">

			<form class="form-horizontal">
				<div class="row">
					<div class="col-sm-5 row">
						<label for="text">License number:</label>
					</div>
					<div class="col-sm-7">
						<input type="text" class="form-control"  placeholder="Enter the License Nu" id="Licenno"/>
					</div>
						<br/>	`
				</div>
				<div class="row">
					<div class="col-sm-5 row">
						<label for="text">License IssueDate:</label>
					</div>
					<div class="col-sm-7">
						<input type="text" class="form-control"  placeholder="Enter the License Issue Date" id="Lic_issue"/>
					</div>
							<br/>`
				</div>
				<div class="row">
					<div class="col-sm-5 row">
						<label for="text">License Expiry Date:</label>
					</div>
					<div class="col-sm-7">
						<input type="text" class="form-control"  placeholder="Enter the License Expiry Date" id="Lic_expiry"/>
					</div>
							`
				</div>
			</form>
		</div>
			<div class="modal-footer">
			<a href="CreateTrip.html" class="btn btn-default" >Submit</a>
			</div>
		</div>
    </div>
</div>
<!--modal5-->
	<div class="modal fade" id="modal5" tabindex="-1">
	<div class="modal-dialog">
	<div class="modal-content">
        <div class="modal-header">
			<button type="button" class="close" data-dismiss="modal2">&times;</button>
			<h4 class="modal-title">Passenger Details</h4>
        </div>
        <div class="modal-body">
        <form class="form-horizontal">
			<div class="row">
					<div class="col-sm-5 row">
						<label for="text">ID Proof type:</label>
					</div>
					<div class="col-sm-7">
						<input type="text" class="form-control"  placeholder="Enter the ID proof type" id="Id_type"/>
					</div>
							`
				</div>
				<br/>
			<div class="row">
				<div class="col-sm-5 row">
					<label for="text">ID Proof number:</label>
				</div>
				<div class="col-sm-7">
					<input type="text" class="form-control"  placeholder="Enter the ID proof type" id="Id_no"/>
				</div>
			</div>			
			
		</form> 
      
		</div>
        <div class="modal-footer">
			<a href="SearchTrip.html" class="btn btn-default" >Submit</a>

        </div>
    </div>
</div>
</div>


	<footer class="text-center footer">
		<p> Copyright @ CarpoolNetworkTeam Project <a href="carpoolnet.com" data-toggle="tooltip" title="Visit CarNet">carpoolnet.com</a></p> 
	</footer> 		
																																</body>
</html>
