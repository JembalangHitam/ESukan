<%-- 
    Document   : editFacility
    Created on : Jun 23, 2026, 3:57:59 AM
    Author     : 20248
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.esukan.dao.FacilityDAO"%>
<%@page import="com.esukan.model.Facility"%>

<%
    int facilityId = Integer.parseInt(request.getParameter("id"));

    FacilityDAO facilityDAO = new FacilityDAO();

    Facility facility = facilityDAO.getFacilityById(facilityId);
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Facility</title>
</head>
<body>

<h1>Edit Facility</h1>

<form action="FacilityServlet" method="post">

    <input type="hidden"
           name="facilityId"
           value="<%=facility.getFacilityId()%>">

    Facility Name:
    <br>
    <input type="text"
           name="facilityName"
           value="<%=facility.getFacilityName()%>">
    <br><br>

    Location:
    <br>
    <input type="text"
           name="location"
           value="<%=facility.getLocation()%>">
    <br><br>

    Status:
    <br>

    <select name="status">

        <option><%=facility.getStatus()%></option>

        <option>Available</option>
        <option>Unavailable</option>
        <option>Maintenance</option>

    </select>

    <br><br>

    <input type="submit" value="Update Facility">

</form>

</body>
</html>
