<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="ua.kpi.leshchenko.i18n.text" />
<html lang="${language }">
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
 	
 	<link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <link href="css/signin.css" rel="stylesheet">
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
   <title><fmt:message key="signup.title"></fmt:message></title>
  </head>

  <body>

    <div class="container">
      <form class="form-signin" name="SignUp" method="POST" action="Controller">
      	<input type="hidden" name="command" value ="signup"/>
        <h2 class="form-signin-heading"><fmt:message key="signup.head"></fmt:message></h2>
        <label for="firstName" class="sr-only"><fmt:message key="signup.fname"></fmt:message></label>
        <input type="text" name="firstName" class="form-control" placeholder=<fmt:message key="signup.fname"></fmt:message> required oninvalid="this.setCustomValidity('<fmt:message key="error.empty"></fmt:message>')" oninput="setCustomValidity('')">
        <label for="lastName" class="sr-only"><fmt:message key="signup.lname"></fmt:message></label>
        <input type="text" name="lastName" class="form-control" placeholder=<fmt:message key="signup.lname"></fmt:message> required oninvalid="this.setCustomValidity('<fmt:message key="error.empty"></fmt:message>')" oninput="setCustomValidity('')">
        <label for="email" class="sr-only"><fmt:message key="placeholder.email"></fmt:message></label>
        <input type="email" name="email" class="form-control" placeholder=<fmt:message key="placeholder.email"></fmt:message> required oninvalid="this.setCustomValidity('<fmt:message key="error.email"></fmt:message>')" oninput="setCustomValidity('')">
        <label for="password" class="sr-only"><fmt:message key="placeholder.password"></fmt:message></label>
        <input type="password" name="password" class="form-control" placeholder=<fmt:message key="placeholder.password"></fmt:message> required oninvalid="this.setCustomValidity('<fmt:message key="error.password"></fmt:message>')" oninput="setCustomValidity('')">
        <button class="btn btn-lg btn-primary btn-block" type="submit"><fmt:message key="button.accept"></fmt:message></button>
      </form>
      
      

    </div>

    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>