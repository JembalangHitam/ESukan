<%-- 
    Document   : viewEmp
    Created on : Jun 19, 2026, 9:21:05 AM
    Author     : 20248
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
<head>
    <title>View Employees</title>
</head>
<body>

<h1>Employee List</h1>

<sql:setDataSource
    var="db"
    driver="org.apache.derby.jdbc.ClientDriver"
    url="jdbc:derby://localhost:1527/emp"
    user="app"
    password="app"/>

<sql:query var="result" dataSource="${db}">
    SELECT * FROM STAFF
</sql:query>

<table border="1">

    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>SALARY</th>
        <th>DESIGNATION</th>
        <th>EDIT</th>
    </tr>

    <c:forEach var="row" items="${result.rows}">

        <tr>

            <td>${row.ID}</td>

            <td>${row.NAME}</td>

            <td>${row.SALARY}</td>

            <td>${row.DESIGNATION}</td>

            <td>
                <a href="editForm.jsp?id=${row.ID}">
                    Edit
                </a>
            </td>

        </tr>

    </c:forEach>

</table>

<br>

<a href="index.jsp">Home</a>

</body>
</html>