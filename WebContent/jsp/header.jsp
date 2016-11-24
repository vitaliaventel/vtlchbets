<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
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
			<c:if test="${type=='1'}">
			 <form class="navbar-form navbar-left" name="menu" method="POST" action="Controller">
				  <input type="hidden" name="command" value = "menu"/>
				  <button type="submit" name="buttonName" value="home" class="btn btn-default"><span class="glyphicon glyphicon-home"></span>Home</button>
      			  <button type="submit" name="buttonName" value="profile" class="btn btn-default"><span class="glyphicon glyphicon-user"></span>Profile</button>
      			  <button type="submit" name="buttonName" value="hall" class="btn btn-default"><span class="glyphicon glyphicon-tower"></span>Hall of Fame</button>
      			  <button type="submit" name="buttonName" value="about" class="btn btn-default"><span class="glyphicon glyphicon-info-sign"></span>About</button>
    		  </form>
			</c:if>
			<c:if test="${type=='2'}">
							 <form class="navbar-form navbar-left" name="menu" method="POST" action="Controller">
				  <input type="hidden" name="command" value = "menu"/>
				  <button type="submit" name="buttonName" value="home" class="btn btn-default"><span class="glyphicon glyphicon-home"></span>Home</button>
				  <button type="submit" name="buttonName" value="profile" class="btn btn-default"><span class="glyphicon glyphicon-user"></span>Profile</button>
      			  <button type="submit" name="buttonName" value="moder" class="btn btn-default"><span class="glyphicon glyphicon-sunglasses"></span>Moderator page</button>
      			  <button type="submit" name="buttonName" value="hall" class="btn btn-default"><span class="glyphicon glyphicon-tower"></span>Hall of Fame</button>
      			  <button type="submit" name="buttonName" value="about" class="btn btn-default"><span class="glyphicon glyphicon-info-sign"></span>About</button>
    		  </form>
			</c:if>
			<c:if test="${type=='3'}">
					<form class="navbar-form navbar-left" name="menu" method="POST" action="Controller">
				  <input type="hidden" name="command" value = "menu"/>
				  <button type="submit" name="buttonName" value="home" class="btn btn-default"><span class="glyphicon glyphicon-home"></span>Home</button>
				  <button type="submit" name="buttonName" value="profile" class="btn btn-default"><span class="glyphicon glyphicon-user"></span>Profile</button>
      			  <button type="submit" name="buttonName" value="admin" class="btn btn-default"><span class="glyphicon glyphicon-wrench"></span>Administrator page</button>
      			  <button type="submit" name="buttonName" value="hall" class="btn btn-default"><span class="glyphicon glyphicon-tower"></span>Hall of Fame</button>
      			  <button type="submit" name="buttonName" value="about" class="btn btn-default"><span class="glyphicon glyphicon-info-sign"></span>About</button>
    		  </form>
			</c:if>
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