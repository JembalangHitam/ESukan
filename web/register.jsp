<%--
Document   : register
Created on : Jun 26, 2026
Author     : 20248
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type"
          content="text/html; charset=UTF-8">
    <title>E-Sukan Register</title>
</head>

<body>

    <h1>Student Registration</h1>

    <form action="RegisterServlet" method="POST">

        <table border="0" cellspacing="5">

            <tr>
                <td>First Name</td>
                <td>
                    <input type="text"
                           name="firstName"
                           required>
                </td>
            </tr>

            <tr>
                <td>Last Name</td>
                <td>
                    <input type="text"
                           name="lastName"
                           required>
                </td>
            </tr>

            <tr>
                <td>Email</td>
                <td>
                    <input type="email"
                           name="email"
                           required>
                </td>
            </tr>

            <tr>
                <td>Password</td>
                <td>
                    <input type="password"
                           name="password"
                           required>
                </td>
            </tr>

            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Register">
                    <input type="reset" value="Reset">
                </td>
            </tr>

        </table>

    </form>

    <br>

    <%
        if (request.getAttribute("errMessage") != null) {
    %>

    <font color="red">
        <%= request.getAttribute("errMessage") %>
    </font>

    <%
        }
    %>

    <br><br>

    <a href="login.jsp">
        Back to Login
    </a>

</body>

</html>
