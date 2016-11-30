<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<title>Moderator page</title>
</head>
<body>
	
	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="jumbotron">
	<center><h2>Event create menu</h2>
	 			<form name="eventCreate" method="POST" action="Controller">
				  <input type="hidden" name="command" value = "eventCreate"/>
			        <input type="text" name="team1" placeholder="Team 1 name" required>
			        <br>
			        <input type="text" name="team2" placeholder="Team 2 name" required>
			        <br>
			        <input type="text" name="gameName" placeholder="Game name" required>
			        <br>
				  <button type="submit" class="btn btn-sm btn-success"><span class="glyphicon glyphicon-plus"></span>New event</button>
    		  </form>
    		  </center>
			<center><h1>Events list</h1></center>
		 			<div class="panel panel-success">
				<div class="panel-heading">OPEN EVENTS</div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Match ID</th>
							<th>Game</th>
							<th>Team 1</th>
							<th>Value</th>
							<th>Team 2</th>
							<th>Value</th>
							<th>Result</th>
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
							<h4 class="modal-title">Event update</h4>
						</div>
						<div class="modal-body">
							Close event dialog, match id:
							<form name="eventClose" method="POST" action="Controller">
								<input type="hidden" name="command" value="eventClose" />
								<input type="text" name="id" value="" readonly/> 
								<hr>
								<label class="radio-inline">
									<input type="radio" name="winner" value="team1" required> team1</label> 
								<label class="radio-inline">
									<input type="radio" name="winner" value="team2" required>team2</label>
								<button class="btn btn-sm btn-primary" type="submit">Accept</button>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						</div>
					</div>

				</div>
			</div>


			<div class="panel panel-danger">
				<div class="panel-heading">CLOSED EVENTS</div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Match ID</th>
							<th>Game</th>
							<th>Team 1</th>
							<th>Value</th>
							<th>Team 2</th>
							<th>Value</th>
							<th>Result</th>
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