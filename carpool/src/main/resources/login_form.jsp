<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/custom.css">
</head>
<body>


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
</nav>



<div class="container">

  <form action="/action_page.php">
    <div class="form-group">
      <label for="email">User Name:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter User Name" name="email">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
    </div>
    
    <button type="submit" class="btn btn-default">Submit</button>
	<button type="submit" class="btn btn-default">Forgot Password?</button>
  </form>
  </form>
</div>


<!-- Footer -->
<br><br><br>
<footer class="text-center footer">
  <a class="up-arrow" href="#myPage" data-toggle="tooltip" title="TO TOP">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a><br><br>
  <p> Copyright @ CarpoolNetworkTeam Project <a href="carpoolnet.com" data-toggle="tooltip" title="Visit CarNet">carpoolnet.com</a></p> 
</footer>


</body>
</html>
