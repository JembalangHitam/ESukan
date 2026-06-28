<%-- 
    Document   : manageFacility
    Created on : Jun 26, 2026, 12:46:39 AM
    Author     : 20248
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.FacilityDAO"%>
<%@page import="model.Facility"%>
<%@page import="java.util.List"%>

<%
    FacilityDAO facilityDAO = new FacilityDAO();
    List<Facility> facilityList = facilityDAO.getAllFacilities();
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Manage Facility</title>
        <link rel="stylesheet"
              href="../css/style.css">
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"/>
        <h1>Manage Facilities</h1>
        <form action="../FacilityServlet" method="post">
            <table>
                <tr>
                    <td>Facility Name</td>
                    <td>
                        <input type="text"
                               name="facilityName"
                               required>
                    </td>
                </tr>
                <tr>
                    <td>Location</td>
                    <td>
                        <input type="text"
                               name="location"
                               required>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit"
                               value="Add Facility">
                    </td>
                </tr>
            </table>
        </form>
        <%
            String errMessage
                    = (String) request.getAttribute("errMessage");

            if (errMessage != null) {
        %>
        <p><%= errMessage%></p>
        <%
            }
        %>
        <hr>
        <h2>Facility List</h2>
        <table border="1" cellpadding="10">
            <tr>
                <th>ID</th>
                <th>Facility Name</th>
                <th>Location</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <%
                for (Facility facility : facilityList) {
            %>
            <tr>
                <td><%= facility.getFacilityId()%></td>
                <td><%= facility.getFacilityName()%></td>
                <td><%= facility.getLocation()%></td>
                <td>
                    <a href="editFacility.jsp?id=<%= facility.getFacilityId()%>">
                        Edit
                    </a>
                </td>
                <td>
                    <a href="../FacilityServlet?action=delete&id=<%= facility.getFacilityId()%>">
                        Delete
                    </a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
        <br>
        <a href="managerDashboard.jsp">
            Back to Dashboard
        </a>
        <jsp:include page="../includes/footer.jsp"/>
    </body>
</html>
