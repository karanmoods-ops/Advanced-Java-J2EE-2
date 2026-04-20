 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Cookie Management</title>
</head>
<body>

<h2>Add Cookie</h2>

<form action="addCookie.jsp" method="post">
    Name: <input type="text" name="name" required><br><br>
    Domain: <input type="text" name="domain" required><br><br>
    Max Age (in sec): <input type="number" name="maxAge" required><br><br>
    
    <input type="submit" value="Add Cookie">
</form>

</body>
</html>