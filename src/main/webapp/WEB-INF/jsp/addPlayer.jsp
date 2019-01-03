<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<title>Add Player Data</title>
<script type="text/javascript">
	function validate() {
		document.getElementById("numErr").innerHTML = "";
		document.getElementById("ageErr").innerHTML = "";
		document.getElementById("batErr").innerHTML = "";
		document.getElementById("bowlErr").innerHTML = "";
		document.getElementById("nameErr").innerHTML = "";
		var status;

		if (isNaN(document.getElementById("num").value)) {
			document.getElementById("numErr").innerHTML = "Enter valid number";
			status = false;
		}
		
		if (isNaN(document.getElementById("age").value)) {
			document.getElementById("ageErr").innerHTML = "Enter valid Age";
			status = false;
		}

		if (!(document.getElementById("name").value
				.match("[a-zA-Z][a-zA-Z' '']*"))) {
			document.getElementById("nameErr").innerHTML = "Enter valid name";
			status = false;
		}

		if (!document.getElementById("bat").value.match("[0-9]+\.[0-9]*")) {
			document.getElementById("batErr").innerHTML = "Enter valid batting average";
			status = false;
		}

		if (!document.getElementById("bowl").value.match("[0-9]+\.[0-9]*")) {
			document.getElementById("bowlErr").innerHTML = "Enter valid bowling average";
			status = false;
		}
		return status;

	}
</script>
</head>
<body>
	<form:form name="myform" action="/KCC/addPlayer"
		onsubmit="return validate()" method="POST">
		<table>
			<tr>
				<td><form:label path="id" />Player Id</td>
				<td><form:input path="id" id="num" /></td>
				<td><p id="numErr" style="color: red"></p></td>
			</tr>
			<tr>
				<td><form:label path="age">Player Age</form:label></td>
				<td><form:input path="age" id="age" /></td>
				<td><p id="ageErr" style="color: red"></p></td>
			</tr>
			<tr>
				<td><form:label path="battingAvg">Batting Average</form:label></td>
				<td><form:input path="battingAvg" id="bat" /></td>
				<td><p id="batErr" style="color: red"></p></td>
			</tr>
			<tr>
				<td><form:label path="bowlingAvg">Bowling Average</form:label></td>
				<td><form:input path="bowlingAvg" id="bowl" /></td>
				<td><p id="bowlErr" style="color: red"></p></td>
			</tr>
			<tr>
				<td><form:label path="name">Player Name</form:label></td>
				<td><form:input path="name" id="name" /></td>
				<td><p id="nameErr" style="color: red"></p></td>
			</tr>
			<tr>
				<td><form:label path="type">Player Type</form:label>
				<td><form:select path="type">
						<form:option value="NONE" label="--- Select ---" />
						<form:option value="Batsman" label="Batsman" />
						<form:option value="Bowler" label="Bowler" />
						<form:option value="AllRounder" label="AllRounder" />
					</form:select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>

		</table>
	</form:form>
	
	<pre>
	<a href="player">Player Details</a>
	
	<a href="index">Home</a>
	</pre>
</body>
</html>