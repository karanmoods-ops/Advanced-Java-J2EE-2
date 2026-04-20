<%
    String name = request.getParameter("username");
    int time = Integer.parseInt(request.getParameter("time"));

    // Create session
    session.setAttribute("user", name);

    // Convert minutes to seconds
    session.setMaxInactiveInterval(time * 60);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Session Created</title>
</head>
<body>

    <h2>Hello <%= name %>!</h2>
    <p>Your session is set for <%= time %> minutes.</p>

    <a href="checkSession.jsp">Click here to check session</a>

    <p>Or wait for <%= time %> minutes to see session expiry.</p>

</body>
</html>