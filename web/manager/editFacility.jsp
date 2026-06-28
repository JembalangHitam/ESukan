<%-- 
    Document   : editFacility
    Created on : Jun 26, 2026, 12:46:47 AM
    Author     : 20248
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.FacilityDAO"%>
<%@page import="model.Facility"%>

<%
    int facilityId
            = Integer.parseInt(request.getParameter("id"));

    FacilityDAO facilityDAO = new FacilityDAO();

    Facility facility
            = facilityDAO.getFacilityById(facilityId);
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Edit Facility</title>
    </head>
    <body>

        <h1>Edit Facility</h1>

        <hr>

        <form action="../FacilityServlet" method="post">

            <input type="hidden"
                   name="action"
                   value="update">

            <input type="hidden"
                   name="facilityId"
                   value="<%= facility.getFacilityId()%>">

            <table>

                <tr>
                    <td><b>Facility ID</b></td>
                    <td><%= facility.getFacilityId()%></td>
                </tr>

                <tr>
                    <td><b>Facility Name</b></td>
                    <td>
                        <input type="text"
                               name="facilityName"
                               value="<%= facility.getFacilityName()%>"
                               required>
                    </td>
                </tr>

                <tr>
                    <td><b>Location</b></td>
                    <td>
                        <input type="text"
                               name="location"
                               value="<%= facility.getLocation()%>"
                               required>
                    </td>
                </tr>

                <tr>
                    <td colspan="2">
                        <input type="submit"
                               value="Update Facility">

                        <a href="manageFacility.jsp">
                            Cancel
                        </a>
                    </td>
                </tr>

            </table>

        </form>

        <hr>

    </body>
</html>
