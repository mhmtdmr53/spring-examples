<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Customer Confirmation</title>
</head>
<body>


<hr>

The Customer is Confirmed: ${customer.firstName} ${customer.lastName}

<br><br>

${customer.passes}. passes

<br>
<br>
Postal Code: ${customer.postalCode}

<br>

Course Code: ${customer.courseCode}
</body>


</html>