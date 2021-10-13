<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<title>Student Confirmation</title>
</head>
<body>


<hr>

The Student is Confirmed: ${student.firstName} ${student.lastName} from ${student.country}

<br><br>

${student.firstName}'s favorite language is ${student.language}

<br><br>

${student.firstName}'s hobies are
<ul>
	<c:forEach var="temp" items="${student.hobies}">
		<li> ${temp} </li>
	</c:forEach>
</ul>

</body>


</html>