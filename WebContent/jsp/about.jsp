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
<title>VTLCHBets about</title>
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
			This project was created specifically to support e-sport, and it is intended to increase interest
			 in matches that are held as part of the biggest tournaments and leagues in the world.
			 On our pages you can locate the matches that you are interested in, and after the matches
			  end you can find out the exact result as recorded by the organizers.
			<br/>
			<br/>
			Zip: 02121
			<br/>
			City: Kyiv
			<br/>
			Country: Ukraine
			<br/>
			Address: From Maidan 125 meters south, second house on the right  
			Activities are performed in accordance with laws of Ukraine  
			<br/>
			tel: +3 9230 1299 32
			<br/>
			<br/>
			</h2>
			
			<hr/>
			<center><h2><strong>Good luck with the bets!</strong></h2></center>
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