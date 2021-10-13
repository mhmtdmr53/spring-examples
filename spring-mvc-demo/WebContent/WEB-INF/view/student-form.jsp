<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>

<title>Student Registration Form</title>
</head>

<body>

	<form:form action="processForm" modelAttribute="student">

		First Name: <form:input path="firstName" />
	
		<br><br>
	
		Last Name: <form:input path="lastName" />
	
		<br><br>
		
		<form:select path="country">
		
			<form:options items="${student.countryOptions}"/>
			
			</form:select>
		<br><br>
		Favorite Language: 
		
		Java <form:radiobutton path="language" value="Java"/>
		C++ <form:radiobutton path="language" value="C++"/>
		Python <form:radiobutton path="language" value="Python"/>
		C# <form:radiobutton path="language" value="C#"/>
		
		<br><br>
		
		Hobbies: 
		Basketball <form:checkbox path="hobies" value="basketball"/>
		Volleyball <form:checkbox path="hobies" value="volleyball"/>
		Reading <form:checkbox path="hobies" value="reading"/>
		
		
		<br><br>
		<input type="submit" value="Submit"/>
		
	</form:form>


</body>




</html>