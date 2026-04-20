 <%@ page import="javax.servlet.http.Cookie" %>
<%
String name = request.getParameter("name");
String domain = request.getParameter("domain");
int maxAge = Integer.parseInt(request.getParameter("maxAge"));

// Create cookie
Cookie cookie = new Cookie(name, "SampleValue");

// Set domain and expiry
cookie.setDomain(domain);
cookie.setMaxAge(maxAge);

// Add cookie to response
response.addCookie(cookie);
%>

<!DOCTYPE html>
<html>
<head>
<title>Cookie Added</title>
</head>
<body>

<h2>Cookie Created Successfully!</h2>

<p><b>Name:</b> <%= name %></p>
<p><b>Domain:</b> <%= domain %></p>
<p><b>Max Age:</b> <%= maxAge %> seconds</p>

<br>
<a href="showCookies.jsp">Go to Active Cookies</a>

</body>
</html>