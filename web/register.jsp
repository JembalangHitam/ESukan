<%-- 
    Document   : register
    Created on : Jun 19, 2026, 3:48:41 AM
    Author     : 20248
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>

<h1>User Registration</h1>

<form action="RegisterServlet" method="post">

    Full Name:<br>
    <input type="text" name="fullname">
    <br><br>

    Email:<br>
    <input type="email" name="email">
    <br><br>

    Password:<br>
    <input type="password" name="password">
    <br><br>

    Role:<br>
    <select name="role">
        <option value="Student">Student</option>
        <option value="Admin">Admin</option>
    </select>

    <br><br>

    <input type="submit" value="Register">

</form>

</body>
</html>