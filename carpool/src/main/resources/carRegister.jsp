<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Bootstrap Example</title>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
 
  
  

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
	
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
		<div class="btn-group btn-group-lg">
  <button type="button" class="btn btn-primary">Cars</button>
  <div>
  
  
  </div>
  
  
  
  
  
  
  
  <button type="button" class="btn btn-primary">Register</button>
 
<div>



</div>
          
		
    <div class="form-group">
      <label for="Car ID">Car ID:</label>
      <input type="Car ID" class="form-control" id="Car ID" placeholder="Enter your Car ID" name="Car ID">
    </div>
	<div class="form-group">
      <label for="Plate.No">Plate No.:</label>
      <input type="Plate.No" class="form-control" id="Plate.No" placeholder="Enter your Plate Number" name="Plate.No">
    </div>
	<div class="form-group">
      <label for="Driver ID">Driver ID:</label>
      <input type="Driver ID" class="form-control" id="Driver ID" placeholder="Enter your Driver ID" name="Driver ID">
    </div>
    
	<div class="form-group">
	<label for="Color"> Color: </label>
	<input type="Color" class="form control" id="Color" placeholder="Choose color" name="color">
	</div>
	
	<div class="form-group">
	<label for="Preferences"> Preferences: </label>
	<div class="radio">
      <label><input type="radio" name="optradio">AC</label>
	  <label><input type="radio" name="optradio">Non-AC</label>
    </div>
	</div>
	
	<div class="form-group">
	<label for="Type"> Type: </label>
	
	<div class="dropdown">
  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"> Categories
  <span class="caret"></span></button>
  <ul class="dropdown-menu">
    <li><a href="#">Sedan</a></li>
    <li><a href="#">SUV</a></li>
    <li><a href="#">Mini</a></li>
  </ul>
</div>
		  
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Submit</button>
        </div>
      </div>
      
    </div>
  </div>
  
</div>
		</div>
        

		 <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#demo-1">Cars</button>
  <button type="button" class="btn btn-info"    data-toggle="modal" data-target="#demo-2">Register Cars</button>
 

  <!-- [ Modal #1 ] -->
  <div class="modal fade" id="demo-1" tabindex="-1">
    <div class="modal-dialog">
     
      
 
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title"> Car Details</h4>
        </div>
        <div class="modal-body">
          
        <table class="table table-bordered">
    <thead>
	<tr>
	<th> </th>
        <th>Car ID</th>
		
        <th>Plate No</th>
        <th>Driver No</th>
      </tr>
    </thead>
    <tbody>
	
	
	<tr>
        <td><input type="radio" name="radioGroup" checked></td>
       
        <td>288</td>
        <td>150</td>
        <td>123
        </td>
    </tr>
	
	<tr>
        <td><input type="radio" name="radioGroup" checked></td>
        
        <td>280</td>
        <td>159</td>
        <td>126        </td>
    </tr>
	
	
	<tr>
        <td><input type="radio" name="radioGroup" checked></td>
        
        <td>286</td>
        <td>157</td>
        <td>125
        </td>
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
  <div class="modal fade" id="demo-2" tabindex="-1">
    <div class="modal-dialog">
     <div class="modal-content">
      <button type="button" class="close" data-dismiss="modal"><i class="icon-xs-o-md"></i></button>
      <div class="modal-header">
        <div class="form-group">
      

	  
	  <label for="Car ID">Car ID:</label>
      <input type="Car ID" class="form-control" id="Car ID" placeholder="Enter your Car ID" name="Car ID">
    </div>
	<div class="form-group">
      <label for="Plate.No">Plate No.:</label>
      <input type="Plate.No" class="form-control" id="Plate.No" placeholder="Enter your Plate Number" name="Plate.No">
    </div>
	<div class="form-group">
      <label for="Driver ID">Driver ID:</label>
      <input type="Driver ID" class="form-control" id="Driver ID" placeholder="Enter your Driver ID" name="Driver ID">
    </div>
    
	<div class="form-group">
	<label for="Color"> Color: </label>
	<input type="Color" class="form control" id="Color" placeholder="Choose color" name="color">
	</div>
	
	<div class="form-group">
	<label for="Preferences"> Preferences: </label>
	<div class="radio">
      <label><input type="radio" name="optradio">AC</label>
	  <label><input type="radio" name="optradio">Non-AC</label>
    </div>
	</div>
	
	<div class="form-group">
	<label for="Type"> Type: </label>
	
	<div class="dropdown">
  <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"> Categories
  <span class="caret"></span></button>
  <ul class="dropdown-menu">
    <li><a href="#">Sedan</a></li>
    <li><a href="#">SUV</a></li>
    <li><a href="#">Mini</a></li>
  </ul>
</div>
		  
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Submit</button>
        </div>
      </div>
      
    </div>
  </div>
  
</div>
		</div>
        


</body>
</html>