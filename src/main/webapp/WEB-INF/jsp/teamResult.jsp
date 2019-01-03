<%@page contentType="text/html;charset = UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Team Details</title>
</head>
<body>
	<h2>Submitted Team Information</h2>
	<table>
		<tr>
			<td>Team ID :</td>
			<td>${teamId}</td>
		</tr>
		<tr>
			<td>Team Name :</td>
			<td>${teamName}</td>
		</tr>
		<tr>
			<td>Country :</td>
			<td>country</td>
		</tr>
		<c:forEach var="player" items="${playerName}">
			<tr>
				<td>Player Name :</td>
				<td>${player.name}</td>
			</tr>
		</c:forEach>
	</table>
	<pre>
	<a href="team">Team Details</a>
	
	<a href="index">Home</a>
	</pre>
</body>
</html>