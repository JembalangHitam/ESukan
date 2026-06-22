<%-- 
    Document   : manageFacility
    Created on : Jun 23, 2026, 3:57:47 AM
    Author     : 20248
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Facilities</title>
</head>
<body>

<h1>Manage Facilities</h1>

<form action="FacilityServlet" method="post">

    Facility Name:
    <br>
    <input type="text" name="facilityName" required>
    <br><br>

    Location:
    <br>
    <input type="text" name="location" required>
    <br><br>

    Status:
    <br>
    <select name="status">
        <option>Available</option>
        <option>Unavailable</option>
        <option>Maintenance</option>
    </select>

    <br><br>

    <input type="submit" value="Add Facility">

</form>

<br>

<a href="adminDashboard.jsp">Back to Dashboard</a>

</body>
</html>