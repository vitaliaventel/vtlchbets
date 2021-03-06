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
<title><fmt:message key="admin.profile.title"></fmt:message></title>
</head>
<body>
	
	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="jumbotron">
		<div class="container">
			<h1><fmt:message key="admin.profile.head"></fmt:message> ${viewId} </h1>
			<div class="panel panel-success">
				<div class="panel-heading"><fmt:message key="panel.success.head"></fmt:message></div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th><fmt:message key="id"></fmt:message></th>
							<th><fmt:message key="placeholder.betvalue"></fmt:message></th>
							<th><fmt:message key="table.your"></fmt:message></th>
							<th><fmt:message key="table.team1"></fmt:message></th>
							<th><fmt:message key="table.team2"></fmt:message></th>
							<th><fmt:message key="table.result"></fmt:message></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${sessionScope.betListUp}" var="bet">
							<tr>
								<td><c:out value="${bet.idBet}" /></td>
								<td><c:out value="${bet.betValue}" /></td>
								<td><c:out value="${bet.winner}" /></td>
								<td><c:out value="${bet.team1}" /></td>
								<td><c:out value="${bet.team2}" /></td>
								<td><c:out value="${bet.result}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			
			<div class="panel panel-danger">
				<div class="panel-heading"><fmt:message key="panel.danger.head"></fmt:message></div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th><fmt:message key="id"></fmt:message></th>
							<th><fmt:message key="placeholder.betvalue"></fmt:message></th>
							<th><fmt:message key="table.your"></fmt:message></th>
							<th><fmt:message key="table.team1"></fmt:message></th>
							<th><fmt:message key="table.team2"></fmt:message></th>
							<th><fmt:message key="table.result"></fmt:message></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${sessionScope.betListFinish}" var="bet">
							<tr>
								<td><c:out value="${bet.idBet}" /></td>
								<td><c:out value="${bet.betValue}" /></td>
								<td><c:out value="${bet.winner}" /></td>
								<td><c:out value="${bet.team1}" /></td>
								<td><c:out value="${bet.team2}" /></td>
								<td><c:out value="${bet.result}" /></td>
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