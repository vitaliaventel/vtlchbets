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
<title><fmt:message key="hall.title"></fmt:message></title>
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
			<center><h1><fmt:message key="halloffame"></fmt:message></h1></center>
			<div class="panel panel-info">
				<div class="panel-heading"><fmt:message key="hall.head"></fmt:message></div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th><fmt:message key="id"></fmt:message></th>
							<th><fmt:message key="signup.fname"></fmt:message></th>
							<th><fmt:message key="signup.lname"></fmt:message></th>
							<th><fmt:message key="balance"></fmt:message></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${applicationScope.hallList}" var="user">
							<tr>
								<td><c:out value="${user.idUser}" /></td>
								<td><c:out value="${user.firstName}" /></td>
								<td><c:out value="${user.lastName}" /></td>
								<td><c:out value="${user.balance}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
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