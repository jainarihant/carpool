<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	  <style>
   		<%@include file="css/custom.css" %>
   </style>
  
  	<%-- <script>
		<%@include file="js/angular/angular.min.js" %>
		<%@include file="js/angular/app.js" %>
		<%@include file="js/angular/login_controller.js" %>
  	</script> --%>
    <script>
      function loadModalWindow() {
         // open your window here
         ("/modal1");
      }
  </script>
  </head>

  <body onload="loadModalWindow()">
    <h1>Hello World!</h1>
    
    <div id="modal1" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Confirm Booking?</h4>
			</div>
		<div class="modal-body">
			<a href="Profile.html" style="margin-left:70px;" class="btn btn-default">OK</a>
			<button type="button" style="margin-left:120px;" class="btn btn-default" data-dismiss="modal">CANCEL</button>
		</div>
		<div class="modal-footer">
		</div>
		</div>
	</div>
</div>
    
    
    
    
  </body>
</html>