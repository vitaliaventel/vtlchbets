<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">VTLCHBets</a> 
			<a class="navbar-brand" href="#">Profile</a>
			<a class="navbar-brand" href="#">About</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<form class="navbar-form navbar-right" name="Logout" method="POST" action="Controller">
           	 	<div class="form-group">
           	 	<button class="btn btn-primary" type="button" readonly>
				Welcome, <span class="glyphicon glyphicon-user"></span>${name}! Balance <span class="glyphicon glyphicon-piggy-bank"> </span><span class="badge">${balance}</span>
				</button>
           	 	</div>
           	 	<div class="form-group">
           	 	<input type="hidden" name="command" value ="logout"/>
           	 	</div>
           		<button type="submit" class="btn btn-success">
           		<span class="glyphicon glyphicon-log-out"></span> Log out</button>
        	</form>
		</div>
	</div>
	</nav>
</body>
</html>