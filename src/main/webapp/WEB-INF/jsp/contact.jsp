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
<h1>Mail Sender</h1>
<form action="send" method="POST">
	    <div class="form-group">
	      <label for="to_address">Email</label>
	      <input type="text" class="form-control" value="${email.to_address}"  id="to_address" name="to_address">
	    </div>
	    <div class="form-group">
	      <label for="subject">Subject</label>
	      <input type="text" class="form-control" value="${email.subject}"  id="subject" name="subject">
	    </div>
	    <div class="form-group">
	      <label for="body">Message</label>
	      <input type="text" class="form-control" value="${email.body}" id="body" name="body">
	    </div>
	    <button type="submit" class="btn btn-default">Submit</button>
	  </form>
</div>


</body>
</html>
