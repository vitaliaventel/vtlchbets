<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="ua.kpi.leshchenko.i18n.text" />
<html lang="${language }">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
			<form class="navbar-form navbar-left">
            <select id="language" name="language" onchange="submit()">
                <option value="en"  ${language == 'en' ? 'selected' : ''}>English</option>
                <option value="ru"  ${language == 'ru' ? 'selected' : ''}>Русский</option>
            </select>
       		 </form>
 			<form class="navbar-form navbar-left" name="menu" method="POST" action="Controller">
				  <input type="hidden" name="command" value = "menu"/>
				  <button type="submit" name="buttonName" value="home" class="btn btn-default"><span class="glyphicon glyphicon-home"></span><fmt:message key="menu.home"></fmt:message></button>
      			  <button type="submit" name="buttonName" value="hall" class="btn btn-default"><span class="glyphicon glyphicon-tower"></span><fmt:message key="menu.hall"></fmt:message></button>
      			  <button type="submit" name="buttonName" value="about" class="btn btn-default"><span class="glyphicon glyphicon-info-sign"></span><fmt:message key="menu.about"></fmt:message></button>
    		  </form>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<form class="navbar-form navbar-right" name="Signup" method="POST" action="Controller">
			<div class="form-group">
			<input type="hidden" name="command" value="tosignup"/>
			</div>
			<button type="submit" class="btn btn-primary"> <fmt:message key="button.signup"></fmt:message></button>
			</form>
			<form class="navbar-form navbar-right" name="Signin" method="POST" action="Controller">
				<div class="form-group">
				<input type="hidden" name="command" value ="signin"/>
				</div>
				<div class="form-group">
					<input type="email" name="email" placeholder=<fmt:message key="placeholder.email"></fmt:message> class="form-control" required oninvalid="this.setCustomValidity('<fmt:message key="error.email"></fmt:message>')" oninput="setCustomValidity('')">
				</div>
				<div class="form-group">
					<input type="password" name="password" placeholder=<fmt:message key="placeholder.password"></fmt:message> class="form-control" required oninvalid="this.setCustomValidity('<fmt:message key="error.password"></fmt:message>')" oninput="setCustomValidity('')">
				</div>
				<button type="submit" class="btn btn-success">
				<span class="glyphicon glyphicon-log-in"></span> <fmt:message key="button.signin"></fmt:message></button>
			</form>
		</div>
		</div>
	</nav>
</body>
</html>