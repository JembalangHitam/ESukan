<%-- 
    Document   : login
    Created on : Jun 19, 2026, 4:04:05 AM
    Author     : 20248
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h1>User Login</h1>

<form action="LoginServlet" method="post">

    Email:<br>
    <input type="email" name="email">
    <br><br>

    Password:<br>
    <input type="password" name="password">
    <br><br>

    <input type="submit" value="Login">

</form>

</body>
</html>