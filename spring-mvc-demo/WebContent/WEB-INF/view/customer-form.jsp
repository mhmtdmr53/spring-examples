<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>

	<title>Customer Registration</title>

	<style>
		.error {color:red}
		.errors {color:blue}
		.errorss {color:black}
	</style>
</head>

<body>

	<form:form action="processForm" modelAttribute="customer">
	
		First Name: <form:input path="firstName"/>
		
		<br><br>
		
		Last Name (*): <form:input path="lastName"/>
		<form:errors path="lastName" cssClass="error" />
	
		<br>
		<br>
		
		Free Passes: <form:input path="passes"/>
		<form:errors path="passes" cssClass="errors" />
		
		<br>
		<br>
		
		Postal Code: <form:input path="postalCode"/>
		<form:errors path="postalCode" cssClass="errors" />
		
		<br>
		<br>
		
		Course Code: <form:input path="courseCode"/>
		<form:errors path="courseCode" cssClass="errorss" />
		
		<br>
		<br>
		<input type="submit" value="Submit" />
		
	</form:form>

</body>

</html>