<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
 	
 	<link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <link href="css/signin.css" rel="stylesheet">
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
    
  </head>

  <body>

    <div class="container">
      <form class="form-signin" name="SignUp" method="POST" action="Controller">
      	<input type="hidden" name="command" value ="signup"/>
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="firstName" class="sr-only">First name</label>
        <input type="text" name="firstName" class="form-control" placeholder="First name" required>
        <label for="lastName" class="sr-only">Last name</label>
        <input type="text" name="lastName" class="form-control" placeholder="Last name" required>
        <label for="email" class="sr-only">Email address</label>
        <input type="email" name="email" class="form-control" placeholder="Email address" required>
        <label for="password" class="sr-only">Password</label>
        <input type="password" name="password" class="form-control" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
      </form>

    </div>

    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>