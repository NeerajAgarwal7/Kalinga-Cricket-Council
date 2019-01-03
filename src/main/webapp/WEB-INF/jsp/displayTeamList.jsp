<%@page contentType="text/html;charset = UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<title>Team Details</title>

<body>
	<table border="1" style="font-size: 28px">
		<tr>
			<th>Team ID</th>
			<th>Team Name</th>
			<th>Country</th>
			<th>Player Name</th>
		</tr>
		<tr>
			<c:forEach var="team" items="${teamList}">
				<tr>
					<td>${team.teamId}</td>
					<td>${team.name}</td>
					<td>${team.country}</td>
					<c:forEach var="player" items="${team.players}">
						<td>${player.name}</td>
					</c:forEach>
			</c:forEach>

		</tr>
	</table>
	<pre>
	<a href="team">Team Details</a>
	
	<a href="index">Home</a>
	</pre>
</body>
</html>