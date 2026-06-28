<%-- 
    Document   : manageFacility
    Created on : Jun 23, 2026, 3:57:47 AM
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.esukan.dao.FacilityDAO"%>
<%@page import="com.esukan.model.Facility"%>

<%
    FacilityDAO facilityDAO = new FacilityDAO();
    List<Facility> facilityList = facilityDAO.getAllFacilities();
%>

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

        <a href="adminDashboard.jsp">Back to Dashboard</a>

        <br>

        <hr>

        <h2>Facility List</h2>

        <table border="1">

            <tr>
                <th>ID</th>
                <th>Facility Name</th>
                <th>Location</th>
                <th>Status</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>

            <%
                for (Facility facility : facilityList) {
            %>

            <tr>
                <td><%=facility.getFacilityId()%></td>
                <td><%=facility.getFacilityName()%></td>
                <td><%=facility.getLocation()%></td>
                <td><%=facility.getStatus()%></td>
                <td>
                    <a href="editFacility.jsp?id=<%=facility.getFacilityId()%>">
                        Edit
                    </a>
                </td>
                <td>
                    <a href="FacilityServlet?deleteId=<%=facility.getFacilityId()%>">
                        Delete
                    </a>
                </td>
            </tr>

            <%
                }
            %>

        </table>

    </body>
</html>
