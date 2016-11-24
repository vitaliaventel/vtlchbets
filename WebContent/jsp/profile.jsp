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
<title>Personal profile VTLCHBET</title>
</head>
<body>
	
	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="jumbotron">
			<center><h1>Personal information</h1></center>
		  <div class="container">
	     	 <center><form name="editprofile" method="POST" action="Controller">
		      	<input type="hidden" name="command" value ="editprofile"/>
		      	<input type="text" name="id" value="${id}"  placeholder="Last name" readonly>
		      	<br>
		        <input type="text" name="firstname" value="${name}" placeholder="First name" required>
		        <br>
		        <input type="text" name="lastname" value="${lastname}"  placeholder="Last name" required>
		        <br>
		        <input type="email" name="email" value="${email}"  placeholder="Email address" required>
		        <br>
		        <input type="password" name="password" value="${password}" placeholder="Password" required>
		        <br>
		        <button class="btn btn-sm btn-primary " type="submit">Save changes</button>
	     	 </form>
			</center>
	   	 </div>
    
		<div class="container">
			<h1>BETS HISTORY</h1>
			<div class="panel panel-success">
				<div class="panel-heading">UPCOMING BETS</div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>Bet value</th>
							<th>Your choice</th>
							<th>Team 1</th>
							<th>Team 2</th>
							<th>Result</th>
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
				<div class="panel-heading">FINISHED BETS</div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>Bet value</th>
							<th>Your choice</th>
							<th>Team 1</th>
							<th>Team 2</th>
							<th>Result</th>
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