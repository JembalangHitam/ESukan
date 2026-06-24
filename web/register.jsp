<%-- 
    Document   : register
    Created on : Jun 19, 2026, 3:48:41 AM
    Author     : 20248
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

    <head>

        <title>E-Sukan Registration</title>

        <link rel="stylesheet" href="style.css">

    </head>

    <body>

        <div class="container">

            <h1>E-Sukan Registration</h1>

            <form action="RegisterServlet" method="post">

                Full Name

                <input type="text"
                       name="fullname"
                       required>

                Email

                <input type="email"
                       name="email"
                       required>

                Password

                <input type="password"
                       name="password"
                       required>

                Role

                <select name="role">

                    <option value="Student">
                        Student
                    </option>

                    <option value="Admin">
                        Admin
                    </option>

                </select>

                <input type="submit"
                       value="Register">

            </form>

            <div class="register">

                <a href="login.jsp">
                    Already have an account? Login
                </a>

            </div>

        </div>

    </body>

</html>