<!DOCTYPE html>
<html lang="en">
<head>
  <title>Create Trip</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
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
      <input type="number" class="form-control" id="datetime" placeholder="Enter date and time" name="datetime">
    </div>
	<div class="form-group">
      <label for="frequency">Frequency:</label>
      <input type="frequency" class="form-control" id="frequency" placeholder="Enter the frequency of trips" name="frequency">
    </div>
	<div class="form-group">
      <label for="enddate">End Date:</label>
      <input type="date" class="form-control" id="enddate"  name="enddate">
    </div>
    <div class="checkbox">
      <label><input type="checkbox" name="remember"> Remember me</label>
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
    <button type="submit" class="btn btn-default">Cancel</button>
  </form>
</div>

</body>
</html>
