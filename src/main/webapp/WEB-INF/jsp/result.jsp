<%@page contentType="text/html;charset = UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Player Details</title>
</head>
<body>
	<h2>Submitted Player Information</h2>
	<table>
		<tr>
			<td>Player ID</td>
			<td>${playerId}</td>
		</tr>
		<tr>
			<td>Player Name</td>
			<td>${name}</td>
		</tr>
		<tr>
			<td>Player Age</td>
			<td>${playerAge}</td>
		</tr>
		<tr>
			<td>Batting Average</td>
			<td>${battingAvg}</td>
		</tr>
		<tr>
			<td>Bowling Average</td>
			<td>${bowlingAvg}</td>
		</tr>
		<tr>
			<td>Player Type</td>
			<td>${type}</td>
		</tr>
	</table>
	<pre>
	<a href="player">Player Details</a>
	
	<a href="index">Home</a>
	</pre>
</body>
</html>