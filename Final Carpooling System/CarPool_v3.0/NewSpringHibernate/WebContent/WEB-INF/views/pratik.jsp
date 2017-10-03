<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  
<!DOCTYPE html>
<html lang="en" ng-app="myApp">
<head>
  <title>Welcome to CarNet</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="https://fonts.googleapis.com/css?family=Anton" rel="stylesheet">
  <%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css"> --%>
   <style>
   		<%@include file="css/custom.css" %>
   </style>
  
  	<script>
		<%@include file="js/angular/angular.min.js" %>
		<%@include file="js/angular/app.js" %>
		<%@include file="js/angular/login_controller.js" %>
  	</script>
	  <script>
		function myFunction1() {
	    	document.getElementById("otp").style.display = "block";
			document.getElementById("login").style.display = "block";
			document.getElementById("register").style.display = "none";	
		}
	</script>

</head>

<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50" >
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
        <!--<li><a href="index.html">HOME</a></li>-->
		<li><a role="button"  href="#myModal" >Sign Up</a></li>
       <li><a role="button"  href="#myModal" >Login</a></li>

       
        <li class="dropdown">  
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">MORE
          <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Profile</a></li>
            <!--<li><a href="#">About Us</a></li><li>-->
			<a href="#contact">Contact Us</a></li>
            <!--<li><a href="#">Help </a></li> -->
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>


<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <!-- <li data-target="#myCarousel" data-slide-to="2"></li> -->
    </ol>


    <div class="carousel-inner" role="listbox" style="height:auto;">
      <div class="item active">
        <img src="https://i.ytimg.com/vi/4ueSMaappmk/maxresdefault.jpg" alt="Pune" width="1200" height="300">
        <div class="container carousel-content">
        		Welcome To CarNet
        </div>
        <div class="carousel-caption">
          <h3>Welcome</h3>
          <p>We assure your safety and security</p>
        </div>      
      </div>

      <div class="item">
        <img src="https://i.ytimg.com/vi/kdMo2tnw7-8/maxresdefault.jpg" alt="Mumbai" width="1200" height="300">
        <div class="container carousel-content">
        	<h1 style="color:white;top:50%;"> Network of Cars </h1>
        </div>
        <div class="carousel-caption">
          <h3 style="color:black;">Welcome</h3>
          <p style="color:black;">We assure your safety and security</p>
        </div>      
      </div>
    
      
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>

<br>
<br>
<br>





<Section id="myModal">
	<br><br>
	<div class="col-sm-12">
		<div class="col-sm-6">
			<h3 style="text-align:center" id="font"> Login</h3>
			
		</div>
		<div class="col-sm-6">
			<h3 style="text-align:center"id="font"> Sign-UP</h3>
			
		</div>
		
		<br><hr>
		
	</div>

	<div class="container-fluid col-sm-12">
		<div class="container-fluid col-sm-5">
			 <div ng-controller="regController as ctrl">
			 
				<form action="userLogin" name="regForm" ng-submit="ctrl.submit()" method="POST">
		
					<div class="form-group">
						<div class="row">
							<label>Email:</label>
								<input type="text" class="form-control" id="email" placeholder="Enter your Email" name="username" maxlength="30" required ng-model="ctrl1.user.email" ng-pattern="re_email">
								<div ng-show="regForm.$dirty">
									<span style="color:red" ng-show="regForm.email.$touched && regForm.email.$error.required">You can't leave this empty.</span>
									<span style="color:red" ng-show="regForm.email.$touched && regForm.email.$error.pattern">Invalid Email ID.</span>
								</div>
			
						</div>
							<br>
						<div class="row">
						
						
						</div>
						<label>Password:</label>
						<div class="row">
							<input type="password"  class="form-control" id="pwd" placeholder="Enter password" name="password">
						</div>
						<div class="row">
							<a href="#" style="float:right">Forgot Password?</a>
						</div>
							<br>
						<div class="row" style="float:right">
							<input type="submit" class="btn  btn-info btn-default" value="Login" />
						</div>
						
					</div>
					
				</form>
			</div>
		</div>
		<div class="col-sm-1"></div>
		<div class="col-sm-1 vl" ></div>
		
		<div class="container-fluid col-sm-4" >
			 <div ng-controller="regController as ctrl">
			 	
				<form action="registerUser" name="regForm" ng-submit="ctrl.submit()" method="post">
		
					<div class="form-group">
						<div class="row">
							<label>FirstName:</label>
							<input type="text" class="form-control"  name="firstname" id="FirstName" placeholder="Enter FirstName"    
								required ng-model="ctrl1.user.fname" ng-pattern="re_text">
									<div ng-show="regForm.$dirty">
										<span style="color:red" ng-show="regForm.fn.$touched && regForm.fn.$error.required">You can't leave this empty.</span>
										<span style="color:red" ng-show="regForm.fn.$touched && regForm.fn.$error.pattern">Please use only letters.</span>
									</div>
									
						</div>
						<br>
						
						<div class="row">
							<label>LastName:</label>
							<input type="text" class="form-control" id="lnInput" placeholder="Enter LastName" name="lastname"  
							required ng-model="ctrl1.user.lname" ng-pattern="re_text">
							<div ng-show="regForm.$dirty">
									<span style="color:red" ng-show="regForm.ln.$touched && regForm.ln.$error.required">You can't leave this empty.</span>
									<span style="color:red" ng-show="regForm.ln.$touched && regForm.ln.$error.pattern">Please use only letters.</span>
							</div>
						</div>
						<br>
					<div ng-controller="test">
						<div class="row">
						
						
							<label>Password:</label>
							<input type="password" class="form-control" ng-minlength="6" ng-maxlength="15" name="password" id="password" required ng-init="password_error_show=0"	ng-change="changepassword()" placeholder="Password" name="myPassword" ng-model="password" ng-pattern="re_password" class="form-control" />
				
				
								<div ng-show="!passvalidation">
					
									<span style="color:red"ng-show="regForm.password.$touched && regForm.password.$invalid ">please enter valid password</span>
									</div>
									
					
								<div ng-show="regForm.$dirty">
										<span style="color:red" ng-show="regForm.password.$touched && regForm.password.$error.required">You can't leave this empty.</span>
										<span style="color:red" ng-show="regForm.password.$touched && regForm.password.$error.minlength">Please use between 6 and 15 characters.</span>
										<span style="color:red" ng-show="regForm.password.$touched && regForm.password.$error.pattern">Must contain one lower &amp; uppercase letter, and one non-alpha character &nbsp&nbsp(a number or a symbol.)</span>	
								</div>
						</div>
						<br>
						
						<div class="row">
							
							
							<label>Confirm Password:</label>
						
								<input type="password"  class="form-control" name="password" id="cpassword" ng-change="confirmPassword()" ng-model="cpassword" placeholder="Confirm password" name="cpassword" 
								maxlength="30" required ng-model="ctrl1.user.cpassword" ng-init="cpassword_error_show=0"
								ng-focus="cpassword_error_show=1" ng-change="cpassword_error_show=cpassword_error_show+1;changepassword()" ng-minlength="6" ng-match="password" ng-change="confirmPassword()" ng-model="cpassword">
						
									<div ng-show="regForm.$dirty">
										<span style="color:red" ng-show="regForm.cpassword.$touched && !confirmPasswordMatches ">Password Mismatch</span>
									</div>
					
									<div ng-show="regForm.$dirty">
										<span style="color:red" ng-show="regForm.cpassword.$touched && regForm.cpassword.$error.required">You can't leave this empty.</span>
									</div>
							
						</div>
						<br>
						<div class="row">
							<label>Email:</label>
							<input type="text" class="form-control" id="email" placeholder="Enter your Email" name="email" maxlength="30" required ng-model="ctrl1.user.email" ng-pattern="re_email">
					
							<div ng-show="regForm.$dirty">
								<span style="color:red" ng-show="regForm.email.$touched && regForm.email.$error.required">You can't leave this empty.</span>
								<span style="color:red" ng-show="regForm.email.$touched && regForm.email.$error.pattern">Invalid Email ID.</span>
								
							</div>
							
						</div>
						<br>
						<div class="row">
							<label>Phone Number:</label>
						
							<input type="text" class="form-control"  placeholder="Enter Phone Number" name="phoneno"
								maxlength="30" required ng-model="ctrl1.user.mob" ng-pattern="re_mobile">
							<div ng-show="regForm.$dirty">
									<span style="color:red" ng-show="regForm.mob.$touched && regForm.mob.$error.required">You can't leave this empty.</span>
									<span style="color:red" ng-show="regForm.mob.$touched && regForm.mob.$error.pattern">Invalid mobile number.</span>
							</div>
						
						</div>
						<br>
						
						<br>
						<div class="row" style="float:right">
							<input  type="submit" id="register" onclick="myFunction1()" class="btn  btn-info btn-default" ng-disabled="myForm.$invalid" value="Register"/>
						</div>
						
						</form>
						<div class="row" id="otp" style="display:none" >
							<label>Enter Otp For Validation:</label>
							<input type="text" name="newOTP" class="form-control" 
							placeholder="Enter Otp" ></input>
						</div>
						<div class="row">
						  <input type="submit" id="login" style="display:none;" class="btn  btn-info btn-default" ng-disabled="myForm.$invalid" value="Submit">
						</div>
		  
					</div>
					
				
				
			</div>
		</div>
		
		</div>
	</div>
	

</section>





<!-- FeedBack <SECTION></SECTION>-->
<div class="col-md-12"><br><br><br><hr></div>
<div id="band" class="container text-center">

  
  </div>
</div>


<!-- Container (Contact Section) -->
<div id="contact" class="container">
  <h3 class="text-center">Contact Us Here</h3>
  <p class="text-center"><em>Let us Help You !</em></p>

  <div class="row">
    <div class="col-md-4">
      <p>Find us here</p>
      <p><span class="glyphicon glyphicon-map-marker"></span>Pune</p>
      <p><span class="glyphicon glyphicon-phone"></span>Phone: 1234567890</p>
      <p><span class="glyphicon glyphicon-envelope"></span>Email: abc@def.com</p>
    </div>
    <div class="col-md-8">
      <div class="row">
        <div class="col-sm-6 form-group">
          <input class="form-control" id="name" name="name" placeholder="Name" type="text" required>
        </div>
        <div class="col-sm-6 form-group">
          <input class="form-control" id="email" name="email" placeholder="Email" type="email" required>
        </div>
      </div>
      <textarea class="form-control" id="comments" name="comments" placeholder="Comment" rows="5"></textarea>
      <br>
      <div class="row">
        <div class="col-md-12 form-group">
          <button class="btn pull-right" type="submit">Send</button>
        </div>
      </div>
    </div>
  </div>
  <br>
  

  
</div>



<!-- Footer -->
<footer class="text-center">
  <a class="up-arrow" href="#myPage" data-toggle="tooltip" title="TO TOP">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a><br><br>
  <p> Copyright @ CarpoolNetworkTeam Project <a href="carpoolnet.com" data-toggle="tooltip" title="Visit CarNet">carpoolnet.com</a></p> 
</footer>

<script>
$(document).ready(function(){
  // Initialize Tooltip
  $('[data-toggle="tooltip"]').tooltip(); 
  
  // Add smooth scrolling to all links in navbar + footer link
  $(".navbar a, footer a[href='#myPage']").on('click', function(event) {

    // Make sure this.hash has a value before overriding default behavior
    if (this.hash !== "") {

      // Prevent default anchor click behavior
      event.preventDefault();

      // Store hash
      var hash = this.hash;

      // Using jQuery's animate() method to add smooth page scroll
      // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 900, function(){
   
        // Add hash (#) to URL when done scrolling (default click behavior)
        window.location.hash = hash;
      });
    } // End if
  });
})
</script>

</body>
</html>
