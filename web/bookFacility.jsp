<%-- 
    Document   : bookFacility
    Created on : Jun 25, 2026, 12:32:53 AM
    Author     : 20248
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.esukan.dao.FacilityDAO"%>
<%@page import="com.esukan.model.Facility"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Book Facility</title>
    </head>
    <body>

        <h1>Book Facility</h1>

        <form action="BookingServlet" method="post">

            <%
                FacilityDAO facilityDAO = new FacilityDAO();
                List<Facility> facilityList = facilityDAO.getAvailableFacilities();
            %>

            Facility:
            <br>

            <select name="facilityId" required>

                <%
                    for (Facility facility : facilityList) {
                %>

                <option value="<%=facility.getFacilityId()%>">
                    <%=facility.getFacilityName()%>
                </option>

                <%
                    }
                %>

            </select>

            <br><br>


            Booking Date:
            <br>
            <input type="date" name="bookingDate" required>
            <br><br>      
            Time Slot:
            <br>
            <select name="timeSlot" required>
                <option value="08:00-10:00">08:00 - 10:00</option>
                <option value="10:00-12:00">10:00 - 12:00</option>
                <option value="14:00-16:00">14:00 - 16:00</option>
                <option value="16:00-18:00">16:00 - 18:00</option>
            </select>
            <br><br>
            <input type="submit" value="Book Facility">

        </form>

        <br>

        <a href="studentDashboard.jsp">Back to Dashboard</a>

    </body>
</html>
