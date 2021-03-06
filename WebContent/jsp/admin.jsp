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
	function view(id){
		document.viewProfile.id.value=id;
	}
</script>
<title><fmt:message key="admin.title"></fmt:message></title>
</head>
<body>
	
	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="jumbotron">
		<div class="container">
			<h1><fmt:message key="admin.userlist"></fmt:message></h1>
			<div class="panel panel-success">
				<div class="panel-heading"><fmt:message key="admin.head"></fmt:message></div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th><fmt:message key="id"></fmt:message></th>
							<th><fmt:message key="signup.fname"></fmt:message></th>
							<th><fmt:message key="signup.lname"></fmt:message></th>
							<th><fmt:message key="placeholder.email"></fmt:message></th>
							<th><fmt:message key="balance"></fmt:message></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${sessionScope.users}" var="user">
							<tr onclick="view(${user.idUser})" data-toggle="modal" data-target="#viewModal">
								<td><c:out value="${user.idUser}" /></td>
								<td><c:out value="${user.firstName}" /></td>
								<td><c:out value="${user.lastName}" /></td>
								<td><c:out value="${user.email}" /></td>
								<td><c:out value="${user.balance}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			
			<div id="viewModal" class="modal fade" role="dialog">
				<div class="modal-dialog">

					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title"><fmt:message key="adminmodal.title"></fmt:message></h4>
						</div>
						<div class="modal-body">
							<fmt:message key="adminmodal.head"></fmt:message>
							<form name="viewProfile" method="POST" action="Controller">
								<input type="hidden" name="command" value="viewProfile" />
								<input type="text" name="id" value="" readonly/> 
								<button class="btn btn-sm btn-primary" type="submit"><fmt:message key="button.submit"></fmt:message></button>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal"><fmt:message key="button.close"></fmt:message></button>
						</div>
					</div>

				</div>
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