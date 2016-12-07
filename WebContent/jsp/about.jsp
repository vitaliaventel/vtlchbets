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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link href="css/jumbotron.css" rel="stylesheet">
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<title><fmt:message key="menu.about"></fmt:message></title>
</head>
<body>

	<c:choose>
	    <c:when test="${type > '0'}">
	      <jsp:include page="header.jsp"></jsp:include>
	    </c:when>
	    <c:otherwise>
	      <jsp:include page="headerstart.jsp"></jsp:include>
	    </c:otherwise>
	</c:choose>
	
	<div class="jumbotron">
		<div class="container">
			<h2>
			<fmt:message key="about.info"></fmt:message>
			<br/>
			<br/>
			<fmt:message key="about.zip"></fmt:message>
			<br/>
			<fmt:message key="about.city"></fmt:message>
			<br/>
			<fmt:message key="about.country"></fmt:message>
			<br/>
			<fmt:message key="about.adress"></fmt:message> 
			<br/>
			<fmt:message key="about.phone"></fmt:message>
			<br/>
			<br/>
			</h2>
			
			<hr/>
			<center><h2><strong><fmt:message key="about.hf"></fmt:message></strong></h2></center>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
	
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>