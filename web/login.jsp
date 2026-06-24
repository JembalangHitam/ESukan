<%-- 
    Document   : login
    Created on : Jun 19, 2026, 4:04:05 AM
    Author     : 20248
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <title>E-Sukan Login</title>

    <link rel="stylesheet" href="style.css">

</head>

<body>

    <div class="container">

        <h1>E-Sukan Login</h1>

        <form action="LoginServlet" method="post">

            Email

            <input type="email"
                   name="email"
                   required>

            Password

            <input type="password"
                   name="password"
                   required>

            <input type="submit"
                   value="Login">

        </form>

        <div class="register">

            <a href="register.jsp">
                Register New Account
            </a>

        </div>

    </div>

</body>

</html>
