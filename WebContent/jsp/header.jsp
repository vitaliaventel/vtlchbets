<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="ua.kpi.leshchenko.i18n.text" />
<html lang="${language }">
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
				  <button type="submit" name="buttonName" value="home" class="btn btn-default"><span class="glyphicon glyphicon-home"></span><fmt:message key="menu.home"></fmt:message></button>
      			  <button type="submit" name="buttonName" value="profile" class="btn btn-default"><span class="glyphicon glyphicon-user"></span><fmt:message key="menu.profile"></fmt:message></button>
      			  <button type="submit" name="buttonName" value="hall" class="btn btn-default"><span class="glyphicon glyphicon-tower"></span><fmt:message key="menu.hall"></fmt:message></button>
      			  <button type="submit" name="buttonName" value="about" class="btn btn-default"><span class="glyphicon glyphicon-info-sign"></span><fmt:message key="menu.about"></fmt:message></button>
    		  </form>
			</c:if>
			<c:if test="${type=='2'}">
							 <form class="navbar-form navbar-left" name="menu" method="POST" action="Controller">
				  <input type="hidden" name="command" value = "menu"/>
				  <button type="submit" name="buttonName" value="home" class="btn btn-default"><span class="glyphicon glyphicon-home"></span><fmt:message key="menu.home"></fmt:message></button>
				  <button type="submit" name="buttonName" value="profile" class="btn btn-default"><span class="glyphicon glyphicon-user"></span><fmt:message key="menu.profile"></fmt:message></button>
      			  <button type="submit" name="buttonName" value="moder" class="btn btn-default"><span class="glyphicon glyphicon-sunglasses"></span><fmt:message key="menu.moderpage"></fmt:message></button>
      			  <button type="submit" name="buttonName" value="hall" class="btn btn-default"><span class="glyphicon glyphicon-tower"></span><fmt:message key="menu.hall"></fmt:message></button>
      			  <button type="submit" name="buttonName" value="about" class="btn btn-default"><span class="glyphicon glyphicon-info-sign"></span><fmt:message key="menu.about"></fmt:message></button>
    		  </form>
			</c:if>
			<c:if test="${type=='3'}">
					<form class="navbar-form navbar-left" name="menu" method="POST" action="Controller">
				  <input type="hidden" name="command" value = "menu"/>
				  <button type="submit" name="buttonName" value="home" class="btn btn-default"><span class="glyphicon glyphicon-home"></span><fmt:message key="menu.home"></fmt:message></button>
				  <button type="submit" name="buttonName" value="profile" class="btn btn-default"><span class="glyphicon glyphicon-user"></span><fmt:message key="menu.profile"></fmt:message></button>
      			  <button type="submit" name="buttonName" value="admin" class="btn btn-default"><span class="glyphicon glyphicon-wrench"></span><fmt:message key="menu.adminpage"></fmt:message></button>
      			  <button type="submit" name="buttonName" value="hall" class="btn btn-default"><span class="glyphicon glyphicon-tower"></span><fmt:message key="menu.hall"></fmt:message></button>
      			  <button type="submit" name="buttonName" value="about" class="btn btn-default"><span class="glyphicon glyphicon-info-sign"></span><fmt:message key="menu.about"></fmt:message></button>
    		  </form>
			</c:if>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<form class="navbar-form navbar-right" name="Logout" method="POST" action="Controller">
           	 	<div class="form-group">
           	 	<button class="btn btn-primary" type="button" readonly>
				<fmt:message key="header.welcometag"></fmt:message> <span class="glyphicon glyphicon-user"></span>${name}! <fmt:message key="header.balancetag"></fmt:message> <span class="glyphicon glyphicon-piggy-bank"> </span><span class="badge">${balance}</span>
				</button>
           	 	</div>
           	 	<div class="form-group">
           	 	<input type="hidden" name="command" value ="logout"/>
           	 	</div>
           		<button type="submit" class="btn btn-success">
           		<span class="glyphicon glyphicon-log-out"></span> <fmt:message key="button.logout"></fmt:message></button>
        	</form>
		</div>
	</div>
	</nav>
</body>
</html>