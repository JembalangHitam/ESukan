<%--
Document   : login
Created on : Jun 26, 2026, 12:45:06 AM
Author     : 20248
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>E-Sukan Login</title>
    </head>

<body>

    <h1>E-Sukan Login</h1>

    <p>Login to access the E-Sukan System.</p>

    <%
        String error = (String) request.getAttribute("errMessage");

        if (error != null) {
    %>

    <p style="color:red;">
        <%= error %>
    </p>

    <%
        }
    %>

    <form action="LoginServlet" method="POST">

        <table border="0" cellspacing="5">

            <tr>
                <td>Email</td>
                <td>
                    <input type="email"
                           name="email"
                           placeholder="Enter Email"
                           required>
                </td>
            </tr>

            <tr>
                <td>Password</td>
                <td>
                    <input type="password"
                           name="password"
                           placeholder="Enter Password"
                           required>
                </td>
            </tr>

            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Login">
                    <input type="reset" value="Reset">
                </td>
            </tr>

        </table>

    </form>

    <br>

    <p>
        Don't have an account?
        <a href="register.jsp">Register Here</a>
    </p>

</body>

</html>
