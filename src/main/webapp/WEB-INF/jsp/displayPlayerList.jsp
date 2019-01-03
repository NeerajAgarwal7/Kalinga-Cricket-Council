<%@page contentType="text/html;charset = UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<title>Player Details</title>

<body>
	<table border="1" style="font-size: 28px">
		<tr>
			<th>Player ID</th>
			<th>Player Name</th>
			<th>Player Age</th>
			<th>Batting Average</th>
			<th>Bowling Average</th>
			<th>Player Type</th>
		</tr>

		<c:forEach var="player" items="${playerList}">
			<tr>
				<td>${player.id}</td>
				<td>${player.name}</td>
				<td>${player.age}</td>
				<td>${player.battingAvg}</td>
				<td>${player.bowlingAvg}</td>
				<td>${player.type}</td>
			</tr>
		</c:forEach>
	</table>
	<pre>
	<a href="player">Player Details</a>
	
	<a href="index">Home</a>
	</pre>
</body>
</html>
