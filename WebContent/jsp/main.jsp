<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link href="css/jumbotron.css" rel="stylesheet">
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<title>VTLCHBets main page</title>
</head>
<body>

	<jsp:include page="headerstart.jsp"></jsp:include>

	<div class="jumbotron">
		<div class="container">
			<h1>VTLCH eSport bets</h1>
			<div class="panel panel-default">
				<div class="panel-heading">UPCOMING EVENTS</div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Game</th>
							<th>Team 1</th>
							<th>Value</th>
							<th>Team 2</th>
							<th>Value</th>
							<th>Result</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${applicationScope.eventListUp}" var="event">
							<tr>
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
			
			<div class="panel panel-default">
				<div class="panel-heading">FINISHED EVENTS</div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Game</th>
							<th>Team 1</th>
							<th>Value</th>
							<th>Team 2</th>
							<th>Value</th>
							<th>Result</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${applicationScope.eventListFinish}" var="event">
							<tr>
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
				<p>Dota 2 is a free-to-play multiplayer online battle arena
					(MOBA) video game developed and published by Valve Corporation for
					Microsoft Windows, OS X, and Linux. The game is the stand-alone
					sequel to Defense of the Ancients (DotA), which was a
					community-created mod for Warcraft III: Reign of Chaos and its
					expansion pack, The Frozen Throne.</p>
				<button data-toggle="collapse" data-target="#dota">View
					details &raquo;</button>
				<div id="dota" class="collapse">Dota 2 is played in matches
					between two teams that consist of five players, with both teams
					occupying their own separate base on the map. Each of the ten
					players independently control a powerful character, known as a
					"hero", that all feature unique abilities and different styles of
					play. During a match, a player and their team collects experience
					points and items for their heroes in order to push through the
					opposing team's defenses. A team wins by being the first to destroy
					a large structure located in the opposing team's base, called the
					"Ancient".</div>
			</div>
			<div class="col-md-4">
				<h2>
					<img src="img/csgologo.jpg" class="img-rounded">
				</h2>
				<p>Counter-Strike: Global Offensive (CS:GO) is a multiplayer
					first-person shooter video game developed by Hidden Path
					Entertainment and Valve Corporation. It is the fourth game in the
					main Counter-Strike franchise. Counter-Strike: Global Offensive was
					released for Microsoft Windows, OS X, Xbox 360, and PlayStation 3
					in August 2012,[1] with the Linux version being released in
					September 2014.</p>
				<button data-toggle="collapse" data-target="#csgo">View
					details &raquo;</button>
				<div id="csgo" class="collapse">Players play as Terrorists or
					Counter Terrorists, and must complete objectives while attempting
					to eliminate the enemy team. Players purchase weapons and equipment
					at the beginning of every round with money awarded based on their
					performance. Completing objectives such as planting the bomb or
					killing an enemy earns players money, but negative actions, such as
					friendly fire towards a teammate or hostage will result in monetary
					penalty. In addition, when a round ends all players receive some
					amount of money, with players on the winning team receiving
					substantially more.</div>
			</div>
			<div class="col-md-4">
				<h2>
					<img src="img/hslogo.png" class="img-rounded">
				</h2>
				<p>Hearthstone: Heroes of Warcraft is a free-to-play online
					collectible card video game developed and published by Blizzard
					Entertainment, released worldwide on March 11, 2014 . Hearthstone
					builds upon the lore of the Warcraft series, using characters,
					creatures, and relics from the series.</p>
				<button data-toggle="collapse" data-target="#hs">View
					details &raquo;</button>
				<div id="hs" class="collapse">The game is a turn-based card
					game between two opponents, using constructed decks of thirty cards
					along with a selected hero with a unique power. Players use mana
					points to cast spells or summon minions to attack the opponent,
					with the goal to reduce the opponent's health to zero. Winning
					matches can earn in-game gold, rewards in the form of new cards,
					and other in-game prizes.</div>
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