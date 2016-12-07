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
<script>
	function info(id){
		document.acceptBet.id.value=id;
	}
</script>
<title><fmt:message key="main.title"></fmt:message></title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div class="jumbotron">
		<div class="container">
			<h1><fmt:message key="main.welcometitle"></fmt:message></h1>
			<div class="panel panel-success">
				<div class="panel-heading"><fmt:message key="panel.success.head"></fmt:message></div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th><fmt:message key="table.id"></fmt:message></th>
							<th><fmt:message key="table.game"></fmt:message></th>
							<th><fmt:message key="table.team1"></fmt:message></th>
							<th><fmt:message key="table.value"></fmt:message></th>
							<th><fmt:message key="table.team2"></fmt:message></th>
							<th><fmt:message key="table.value"></fmt:message></th>
							<th><fmt:message key="table.result"></fmt:message></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${applicationScope.eventListUp}" var="event">
							<tr onclick="info(${event.idEvent})" data-toggle="modal" data-target="#betModal">
								<td><c:out value="${event.idEvent}" /></td>
								<td><c:out value="${event.gameName}" /></td>
								<td><c:out value="${event.team1}" /></td>
								<td><c:out value="${event.teamValue1}" /></td>
								<td><c:out value="${event.team2}" /></td>
								<td><c:out value="${event.teamValue2}" /></td>
								<td><c:out value="${event.result}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<div id="betModal" class="modal fade" role="dialog">
				<div class="modal-dialog">

					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title"><fmt:message key="betmodal.head"></fmt:message> ${name}</h4>
						</div>
						<div class="modal-body">
						<fmt:message key="betmodal.text"></fmt:message>
							<form name="acceptBet" method="POST" action="Controller">
								<input type="hidden" name="command" value="acceptBet" />
								<input type="text" name="id" value="" readonly/> 
								<hr>
								<label class="radio-inline">
									<input type="radio" name="winner" value="team1" required> <fmt:message key="table.team1"></fmt:message></label> 
								<label class="radio-inline">
									<input type="radio" name="winner" value="team2" required><fmt:message key="table.team2"></fmt:message></label>
								<input type="number" name="betValue" min="0.1" max=${balance} step="0.1" placeholder=<fmt:message key="placeholder.betvalue"></fmt:message> required>
								<button class="btn btn-sm btn-primary" type="submit"><fmt:message key="button.accept"></fmt:message></button>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal"><fmt:message key="button.close"></fmt:message></button>
						</div>
					</div>

				</div>
			</div>

			<div class="panel panel-danger">
				<div class="panel-heading"><fmt:message key="panel.danger.head"></fmt:message></div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th><fmt:message key="table.id"></fmt:message></th>
							<th><fmt:message key="table.game"></fmt:message></th>
							<th><fmt:message key="table.team1"></fmt:message></th>
							<th><fmt:message key="table.value"></fmt:message></th>
							<th><fmt:message key="table.team2"></fmt:message></th>
							<th><fmt:message key="table.value"></fmt:message></th>
							<th><fmt:message key="table.result"></fmt:message></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${applicationScope.eventListFinish}" var="event">
							<tr>
								<td><c:out value="${event.idEvent}" /></td>
								<td><c:out value="${event.gameName}" /></td>
								<td><c:out value="${event.team1}" /></td>
								<td><c:out value="${event.teamValue1}" /></td>
								<td><c:out value="${event.team2}" /></td>
								<td><c:out value="${event.teamValue2}" /></td>
								<td><c:out value="${event.result}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>
	</div>

		<div class="container">
		<div class="row">
			<div class="col-md-4">
				<h2>
					<img src="img/dotalogo.jpg" class="img-rounded">
				</h2>
				<p><fmt:message key="dota2.info1"></fmt:message></p>
				<button data-toggle="collapse" data-target="#dota"><fmt:message key="button.collapse"></fmt:message> &raquo;</button>
				<div id="dota" class="collapse"><fmt:message key="dota2.info2"></fmt:message></div>
			</div>
			<div class="col-md-4">
				<h2>
					<img src="img/csgologo.jpg" class="img-rounded">
				</h2>
				<p><fmt:message key="csgo.info1"></fmt:message></p>
				<button data-toggle="collapse" data-target="#csgo"><fmt:message key="button.collapse"></fmt:message> &raquo;</button>
				<div id="csgo" class="collapse"><fmt:message key="csgo.info2"></fmt:message></div>
			</div>
			<div class="col-md-4">
				<h2>
					<img src="img/hslogo.png" class="img-rounded">
				</h2>
				<p><fmt:message key="hs.info1"></fmt:message></p>
				<button data-toggle="collapse" data-target="#hs"><fmt:message key="button.collapse"></fmt:message> &raquo;</button>
				<div id="hs" class="collapse"><fmt:message key="hs.info2"></fmt:message></div>
			</div>
		</div>

		<hr>

		<jsp:include page="footer.jsp"></jsp:include>
	</div>

	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>