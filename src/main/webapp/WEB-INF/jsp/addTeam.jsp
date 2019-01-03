<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Add Player Data</title>
<script type="text/javascript">
	function validate() {
		document.getElementById("numErr").innerHTML = "";
		document.getElementById("nameErr").innerHTML = "";
		document.getElementById("conErr").innerHTML = "";
		var status;

		if (isNaN(document.getElementById("num").value)) {
			document.getElementById("numErr").innerHTML = "Enter valid number";
			status = false;
		}
		if (!(document.getElementById("name").value
				.match("[a-zA-Z][a-zA-Z' '']*"))) {
			document.getElementById("nameErr").innerHTML = "Enter valid name";
			status = false;
		}

		if (!(document.getElementById("con").value
				.match("[a-zA-Z][a-zA-Z' '']*"))) {
			document.getElementById("conErr").innerHTML = "Enter valid Country name";
			status = false;
		}

		return status;
	}
</script>
</head>
<body>
	<form:form name="myform" action="/KCC/addTeam" onsubmit="return validate()" method="POST">
		<table>
			<tr>
				<td><form:label path="teamId" />Team Id</td>
				<td><form:input path="teamId" id="num" /></td>
				<td><p id="numErr" style="color: red"></p></td>
			</tr>
			<tr>
				<td><form:label path="country" />Country</td>
				<td><form:input path="country" id="con" /></td>
				<td><p id="conErr" style="color: red"></p></td>
			</tr>
			<tr>
				<td><form:label path="name" />Team Name</td>
				<td><form:input path="name" id="name" /></td>
				<td><p id="nameErr" style="color: red"></p></td>
			</tr>
		</table>
		<c:forEach var="player" items="${unsoldPlayerList}">
			<form:checkbox path="ids" value="${player.id}" />${player.name}
			<br>
		</c:forEach>

		<input type="submit" value="Submit" />

	</form:form>
</body>
</html>