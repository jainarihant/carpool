<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="css/custom.css">
  
  <script src="js/angular/angular.min.js"></script>  
  <script src="js/angular/app.js"></script>
  <script src="js/angular/login_controller.js"></script>

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

<!--Login-->    

	<div class="container text-center" style="margin-top:;">
		<div id="Second" class="row">
		  <div class="col-lg-6 col-md-6 col-sm-6"  >
		  
		  </div>
		  
		  <div class="col-lg-6 col-md-6 col-sm-6"  >
		  
		  <div ng-controller = "loginController as ctrl">
			<form method=post name="loginForm" ng-submit="ctrl.submit()" >
			
			<div class="row">
				<div class="form-group col-xs-4">
						<div class="input-group">
							<input type="text" name="uname" size="30" maxlength="15" class="form-control" placeholder="Username"
							aria-label="User Id" required ng-model="ctrl.user.username">
								<div ng-show="loginForm.$dirty">
									<span style="color:red" ng-show="loginForm.uname.$error.required">This is required field.</span>
								</div>
						</div>
				</div>

				<div class="form-group col-xs-4">	
						<div class="input-group">
							<input type="password" name="password" size="30" maxlength="15" class="form-control" placeholder="Password"
							aria-label="Password"  required ng-model="ctrl.user.password"/>
							<div ng-show="loginForm.$dirty">
								<span style="color:red" ng-show="loginForm.password.$touched && loginForm.password.$error.required">This is required field.</span>
						    </div>
						</div>
				</div>	
				
				<div class="form-group col-xs-4">
					<div class="input-group">
						<button type="submit" class="btn btn-light" >Login</button>
					</div>
				</div>
			</div>		
				
			</form>
		  </div>
		  
		</div>
	</div>
  </div>

<!--Register-->
<div class="container ">
    <div id="Second" class="row">
	  <div class="col-lg-6 col-md-6 col-sm-6"  >
		  
	  </div>	
      <div class="col-lg-6 col-md-6 col-sm-6" style="border: 1px solid  #cecece ; border-radius: 13px;" >
		<div ng-controller = "regController as ctrl1">
			<form method="post" name="regForm" ng-submit="ctrl1.submit()">
				
				<div style="margin-top:20px; margin-left:11px; width:300px;">
						<strong>Name</strong>
						<div>
							<input type="text" class="TextInput TextInput_large" id="fnInput" name="fn" maxlength="32" placeholder="First"
								required ng-model="ctrl1.user.fname" ng-pattern="re_text">	
								<div ng-show="regForm.$dirty">
									<span style="color:red" ng-show="regForm.fn.$touched && regForm.fn.$error.required">You can't leave this empty.</span>
									<span style="color:red" ng-show="regForm.fn.$touched && regForm.fn.$error.pattern">Please use only letters.</span>
								</div>
						</div>	
						
						
						<div>
							<input type="text" class="TextInput TextInput_large" id="lnInput" name="ln" maxlength="32" placeholder="Last"
								required ng-model="ctrl1.user.lname" ng-pattern="re_text">
								<div ng-show="regForm.$dirty">
									<span style="color:red" ng-show="regForm.ln.$touched && regForm.ln.$error.required">You can't leave this empty.</span>
									<span style="color:red" ng-show="regForm.ln.$touched && regForm.ln.$error.pattern">Please use only letters.</span>
								</div>
						</div>
				</div>
				
				
				<div style="margin-top:20px; margin-left:11px; width:300px;">
					<strong>Choose your username</strong>
					<input type="text" class="TextInput TextInput_large" id="unInput" name="uname" placeholder=""
						required ng-model="ctrl1.user.username" ng-minlength="6" ng-maxlength="30" ng-pattern="re_username">
						
						<div ng-show="regForm.$dirty">
							<span style="color:red" ng-show="regForm.uname.$touched && regForm.uname.$error.required">You can't leave this empty.</span>
						</div>
						<div ng-show="regForm.$dirty">
							<span style="color:red" ng-show="regForm.uname.$touched && regForm.uname.$error.minlength">
								Please use between 6 and 30 characters.</span>
							<span style="color:red" ng-show="regForm.uname.$touched && regForm.uname.$error.maxlength">
								Please use between 6 and 30 characters.</span>	
							<span style="color:red" ng-show="regForm.uname.$touched && regForm.uname.$error.pattern">Please use only letters (a-z) and numbers.</span>	
						</div>	
						<div ng-show="regForm.$dirty">
							<span style="color:red" ng-show="regForm.uname.$touched && regForm.uname.$invalid">This field is invalid.</span>
						</div>
				</div>
				
				
				
				<div style="margin-top:20px; margin-left:11px; width:300px;">
					<strong>Create a password</strong>
					<input type="password" class="TextInput TextInput_large" id="password" name="password" maxlength="15" placeholder="" ng-pattern="re_password"
						required ng-model="ctrl1.user.password" 
						ng-init="password_error_show=0"
						ng-focus="password_error_show=1"
						ng-change="password_error_show=password_error_show+1;changepassword()"
						ng-minlength="6">
						<div ng-show="regForm.$dirty">
							<span style="color:red" ng-show="regForm.password.$touched && regForm.password.$error.required">You can't leave this empty.</span>
							<span style="color:red" ng-show="regForm.password.$touched && regForm.password.$error.minlength">Please use between 6 and 15 characters.</span>
							<span style="color:red" ng-show="regForm.password.$touched && regForm.password.$error.pattern">Please use only letters (a-z), numbers and periods.</span>	
						</div>
						<!--
						<div ng-show="regForm.$dirty">
								<span style="color:red" ng-show="passValidation && password_error_show>0 ">Invalid password.</span>
						</div>
						-->
				</div>
				
				
				<div style="margin-top:20px; margin-left:11px; width:300px;">
					<strong>Confirm your password</strong>
					<input type="password" class="TextInput TextInput_large" id="cpassword" name="cpassword" maxlength="30" placeholder=""
						required ng-model="ctrl1.user.cpassword" 
						ng-init="cpassword_error_show=0"
						ng-focus="cpassword_error_show=1"
						ng-change="cpassword_error_show=cpassword_error_show+1;changepassword()"
						ng-minlength="6" ng-match="password" ng-change="changepassword()">
						<div ng-show="regForm.$dirty">
							<span style="color:red" ng-show="regForm.cpassword.$touched && regForm.cpassword.$error.required">You can't leave this empty.</span>
							
							<!--
							<span style="color:red" ng-show="regForm.password!==regForm.cpassword">Mismatch.</span>
							-->
						</div>
				</div>
				
				
				
				<div style="margin-top:20px; margin-left:11px; width:300px;">
					<strong>Email address</strong>
					<input type="email" class="TextInput TextInput_large" name="email" maxlength="30" placeholder=""
						required ng-model="ctrl1.user.email" ng-pattern="re_email">
						<div ng-show="regForm.$dirty">
							<span style="color:red" ng-show="regForm.email.$touched && regForm.email.$error.required">You can't leave this empty.</span>
							<span style="color:red" ng-show="regForm.email.$touched && regForm.email.$error.pattern">Invalid Email ID.</span>
							
						</div>
				</div>
				
				
				<div style="margin-top:20px; margin-left:11px; width:300px;">
					<strong>Mobile phone</strong>
					<input type="text" class="TextInput TextInput_large" name="mob" maxlength="30" placeholder=""
						required ng-model="ctrl1.user.mob" ng-pattern="re_mobile">
						<div ng-show="regForm.$dirty">
							<span style="color:red" ng-show="regForm.mob.$touched && regForm.mob.$error.required">You can't leave this empty.</span>
							<span style="color:red" ng-show="regForm.mob.$touched && regForm.mob.$error.pattern">Invalid mobile number.</span>
						</div>
				</div>

				
				
				<div style="margin-top:20px; margin-left:11px; width:300px; margin-bottom:20px;">
					<button name="login" id="login"  type="submit" class="btn btn-light" ng-disabled="myForm.$invalid">Sign Up</button>
				</div>

			</form>
		</div>
      </div>
    </div>
</div>


<div class="container" style="height:200px">
      
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