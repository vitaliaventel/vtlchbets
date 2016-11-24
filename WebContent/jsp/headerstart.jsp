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
				<span class="icon-bar"></span>
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
 			<form class="navbar-form navbar-left" name="menu" method="POST" action="Controller">
				  <input type="hidden" name="command" value = "menu"/>
				  <button type="submit" name="buttonName" value="home" class="btn btn-default"><span class="glyphicon glyphicon-home"></span>Home</button>
      			  <button type="submit" name="buttonName" value="hall" class="btn btn-default"><span class="glyphicon glyphicon-tower"></span>Hall of Fame</button>
      			  <button type="submit" name="buttonName" value="about" class="btn btn-default"><span class="glyphicon glyphicon-info-sign"></span>About</button>
    		  </form>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<form class="navbar-form navbar-right" name="Signup" method="POST" action="Controller">
			<div class="form-group">
			<input type="hidden" name="command" value="tosignup"/>
			</div>
			<button type="submit" class="btn btn-primary"> Sign up</button>
			</form>
			<form class="navbar-form navbar-right" name="Signin" method="POST" action="Controller">
				<div class="form-group">
				<input type="hidden" name="command" value ="signin"/>
				</div>
				<div class="form-group">
					<input type="email" name="email" placeholder="Email" class="form-control" required>
				</div>
				<div class="form-group">
					<input type="password" name="password" placeholder="Password" class="form-control" required>
				</div>
				<button type="submit" class="btn btn-success">
				<span class="glyphicon glyphicon-log-in"></span> Sign in</button>
			</form>
		</div>
		</div>
	</nav>
</body>
</html>