<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
  <title>LMS</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class = "container">
<h1>Upload file</h1>
<form action="upload" method="POST" enctype="multipart/form-data">
	    <div class="form-group">
	      <label for="file">Attachment</label>
	      <input type="file" class="form-control" id="file" name="file">
	    </div> 
	    <button type="submit" class="btn btn-default">Submit</button>
	  </form>
</div>


</body>
</html>
