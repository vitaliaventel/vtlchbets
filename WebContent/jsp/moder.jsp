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
	function accept(id){
		document.eventClose.id.value=id;
	}
</script>
<title><fmt:message key="moder.title"></fmt:message></title>
</head>
<body>
	
	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="jumbotron">
	<center><h2><fmt:message key="moder.createmenu"></fmt:message></h2>
	 			<form name="eventCreate" method="POST" action="Controller">
				  <input type="hidden" name="command" value = "eventCreate"/>
			        <input type="text" name="team1" placeholder=<fmt:message key="table.team1"></fmt:message> required oninvalid="this.setCustomValidity('<fmt:message key="error.empty"></fmt:message>')" oninput="setCustomValidity('')">
			        <br>
			        <input type="text" name="team2" placeholder=<fmt:message key="table.team2"></fmt:message> required oninvalid="this.setCustomValidity('<fmt:message key="error.empty"></fmt:message>')" oninput="setCustomValidity('')">
			        <br>
			        <input type="text" name="gameName" placeholder=<fmt:message key="moder.gamename"></fmt:message> requiredoninvalid="this.setCustomValidity('<fmt:message key="error.empty"></fmt:message>')" oninput="setCustomValidity('')">
			        <br>
				  <button type="submit" class="btn btn-sm btn-success"><span class="glyphicon glyphicon-plus"></span><fmt:message key="moder.newevent"></fmt:message></button>
    		  </form>
    		  </center>
			<center><h1><fmt:message key="moder.eventlist"></fmt:message></h1></center>
		 			<div class="panel panel-success">
				<div class="panel-heading"><fmt:message key="moder.open"></fmt:message></div>
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
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${applicationScope.eventListUp}" var="event">
							<tr onclick="accept(${event.idEvent})" data-toggle="modal" data-target="#eventModal">
								<td><c:out value="${event.idEvent}" /></td>
								<td><c:out value="${event.gameName}" /></td>
								<td><c:out value="${event.team1}" /></td>
								<td><c:out value="${event.teamValue1}" /></td>
								<td><c:out value="${event.team2}" /></td>
								<td><c:out value="${event.teamValue2}" /></td>
								<td><c:out value="${event.result}" /></td>
								<td>
								<form name="eventDelete" method="POST" action="Controller">
				  					<input type="hidden" name="command" value = "eventDelete"/>
									<input type="hidden" name="id" value="${event.idEvent}"/> 
									<button type="submit" class="btn btn-sm btn-danger"><span class="glyphicon glyphicon-remove"></span>Delete</button>
								</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<div id="eventModal" class="modal fade" role="dialog">
				<div class="modal-dialog">

					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title"><fmt:message key="eventmodal.title"></fmt:message></h4>
						</div>
						<div class="modal-body">
							<fmt:message key="eventmodal.head"></fmt:message>
							<form name="eventClose" method="POST" action="Controller">
								<input type="hidden" name="command" value="eventClose" />
								<input type="text" name="id" value="" readonly/> 
								<hr>
								<label class="radio-inline">
									<input type="radio" name="winner" value="team1" required> <fmt:message key="table.team1"></fmt:message></label> 
								<label class="radio-inline">
									<input type="radio" name="winner" value="team2" required><fmt:message key="table.team2"></fmt:message></label>
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
				<div class="panel-heading"><fmt:message key="moder.closed"></fmt:message></div>
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
							<th></th>
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
								<td>
								<form name="eventDelete" method="POST" action="Controller">
				  					<input type="hidden" name="command" value = "eventDelete"/>
									<input type="hidden" name="id" value="${event.idEvent}"/> 
									<button type="submit" class="btn btn-sm btn-danger"><span class="glyphicon glyphicon-remove"></span>Delete</button>
								</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
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